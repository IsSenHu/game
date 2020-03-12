package com.qdhh.game.tianming.coin;

import com.dyuproject.protostuff.Tag;

/**
 * @author HuSen
 * create on 2020/3/5 17:57
 */
public class GmAddReq {
    @Tag(1)
    public int id;
    @Tag(2)
    public long count;
}
