package com.qdhh.game.tianming;

import com.dyuproject.protostuff.Tag;

/**
 * @author HuSen
 * create on 2020/3/5 16:46
 */
public class DataItem {
    @Tag(1)
    public String key;
    @Tag(2)
    public byte[] data;
    @Tag(3)
    public int opType;
    @Tag(4)
    public long version;
}
