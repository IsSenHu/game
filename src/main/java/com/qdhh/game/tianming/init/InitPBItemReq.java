package com.qdhh.game.tianming.init;

import com.dyuproject.protostuff.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuSen
 * create on 2020/3/5 18:08
 */
public class InitPBItemReq {
    @Tag(1)
    public List<Integer> types;

    public InitPBItemReq() {
        types = new ArrayList<>();
    }
}
