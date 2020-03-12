package com.qdhh.game.tianming.enter;

import com.dyuproject.protostuff.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuSen
 * create on 2020/3/5 17:43
 */
public class CheckValueReq {
    @Tag(1)
    public List<String> clsNames;

    public CheckValueReq() {
        clsNames = new ArrayList<>();
    }
}
