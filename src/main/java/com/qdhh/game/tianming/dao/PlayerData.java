package com.qdhh.game.tianming.dao;

import com.qdhh.game.tianming.BaseDataManager;

/**
 * @author HuSen
 * create on 2020/3/12 10:46 上午
 */
public class PlayerData extends BaseDataManager {

    private String zone;
    private String userId;

    public PlayerData(int port, String hostName, int dataBase, String password, String zone, String userId) {
        super(port, hostName, dataBase, password);
        this.zone = zone;
        this.userId = userId;
    }

    @Override
    protected String dataKey(Class<?> dataType) {
        return "DATA:" + zone + ":" + userId + ":" + typeKey(dataType);
    }
}
