package com.qdhh.game.tianming;

import com.dyuproject.protostuff.Tag;

/**
 * @author HuSen
 * create on 2020/3/5 16:52
 */
public class ZoneStatus {
    @Tag(1)
    public String nameId;
    @Tag(2)
    public String chName;
    /**
     * 1:流畅,2:普通,3:高负载,4:爆满,5:推荐
     */
    @Tag(3)
    public int status;
    @Tag(4)
    public int zoneId;
}
