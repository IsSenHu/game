package com.qdhh.game.tianming;

import com.alibaba.fastjson.JSON;
import com.qdhh.game.tianming.dao.PlayerData;
import com.qdhh.game.tianming.dao.ServerData;
import com.qdhh.game.tianming.dao.ZoneData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * http://localhost:22222/data?type=3&queryType=1&className=com.qdhh.game.tianming.pb.APArenaInfoInCrossDaoMeta&hostName=127.0.0.1&port=6320&password=&dataBase=0&zone=-10000&userId=17742292006
 *
 * @author HuSen
 * create on 2020/3/12 10:57 上午
 */
@Slf4j
@RestController
public class DataController {

    @GetMapping("/data")
    public void query(Integer type, Integer queryType, String className, String hostName, Integer port, String password, Integer dataBase, String zone, String userId) {
        switch (type) {
            case 1: {
                PlayerData playerData = new PlayerData(port, hostName, dataBase, password, zone, userId);
                doQuery(playerData, queryType, className);
                break;
            }
            case 2: {
                ZoneData zoneData = new ZoneData(port, hostName, dataBase, password, zone);
                doQuery(zoneData, queryType, className);
                break;
            }
            case 3: {
                ServerData serverData = new ServerData(port, hostName, dataBase, password);
                doQuery(serverData, queryType, className);
                break;
            }
            default:
        }
    }

    private void doQuery(BaseDataManager baseDataManager, Integer queryType, String className) {
        try {
            Class<?> aClass = Class.forName(className);
            switch (queryType) {
                case 1: {
                    Object query = baseDataManager.query(aClass);
                    log.info("query result:{}", JSON.toJSONString(query, true));
                    break;
                }
                case 2: {
                    List<?> objects = baseDataManager.queryItems(aClass);
                    log.info("query result:{}", JSON.toJSONString(objects, true));
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
