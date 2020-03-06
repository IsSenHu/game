package com.qdhh.game.tianming.enter;

import com.dyuproject.protostuff.Tag;
import com.qdhh.game.tianming.DataItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuSen
 * create on 2020/3/5 17:43
 */
public class CheckValueResp {
    @Tag(1)
    public List<DataItem> datas;
    @Tag(2)
    public boolean zoneCombined;

    public CheckValueResp() {
        datas = new ArrayList<>();
    }
}
