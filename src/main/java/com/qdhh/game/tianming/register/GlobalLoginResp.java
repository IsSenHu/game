package com.qdhh.game.tianming.register;

import com.dyuproject.protostuff.Tag;
import com.qdhh.game.tianming.ZoneStatus;

import java.util.List;

/**
 * @author HuSen
 * create on 2020/3/5 16:51
 */
public class GlobalLoginResp {
    @Tag(1)
    public String playerId;
    @Tag(2)
    public String zone;
    @Tag(3)
    public String url;
    @Tag(4)
    public String chName;
    @Tag(5)
    public List<ZoneStatus> zones;
}
