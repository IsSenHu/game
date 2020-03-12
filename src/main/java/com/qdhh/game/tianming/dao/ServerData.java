package com.qdhh.game.tianming.dao;

import com.qdhh.game.tianming.BaseDataManager;

/**
 * @author HuSen
 * create on 2020/3/12 10:52 上午
 */
public class ServerData extends BaseDataManager {

    public ServerData(int port, String hostName, int dataBase, String password) {
        super(port, hostName, dataBase, password);
    }

    @Override
    protected String dataKey(Class<?> dataType) {
        return "DATA:" + typeKey(dataType);
    }
}
