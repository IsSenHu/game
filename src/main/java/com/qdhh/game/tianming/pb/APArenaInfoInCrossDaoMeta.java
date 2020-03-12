package com.qdhh.game.tianming.pb;

import com.dyuproject.protostuff.Tag;
import lombok.Getter;
import lombok.Setter;

/**
 * @author HuSen
 * create on 2020/3/12 11:47 上午
 */
@Setter
@Getter
public class APArenaInfoInCrossDaoMeta {
    @Tag(1)
    private long version;
    /**
     * 战区
     */
    @Tag(2)
    private String group;
    /**
     * 赛季结束时间
     */
    @Tag(3)
    private long seasonEndTime;
    /**
     * 第几赛季
     */
    @Tag(4)
    private int index;
}
