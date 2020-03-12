package com.qdhh.game.tianming.dao;

import com.qdhh.game.tianming.BaseDataManager;

/**
 * @author HuSen
 * create on 2020/3/12 10:55 上午
 */
public class ZoneData extends BaseDataManager {

    private String zone;

    public ZoneData(int port, String hostName, int dataBase, String password, String zone) {
        super(port, hostName, dataBase, password);
        this.zone = zone;
    }

    @Override
    protected String dataKey(Class<?> dataType) {
        return "DATA:" + zone + ":" + typeKey(dataType);
    }
}
