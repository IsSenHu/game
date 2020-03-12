package com.qdhh.game.tianming;

import com.dyuproject.protostuff.Tag;

import java.util.ArrayList;

/**
 * @author HuSen
 * create on 2020/3/5 16:45
 */
public class HttpResp {

    @Tag(1)
    public byte[] resp;
    @Tag(2)
    public ArrayList<DataItem> datas;
    @Tag(3)
    public long version;
    @Tag(4)
    public long serverTime;
    @Tag(5)
    public long sysTblVersion;

    public HttpResp() {
        datas = new ArrayList<DataItem>();
    }
}
