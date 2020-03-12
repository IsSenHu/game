package com.qdhh.game.tianming.pb;

import com.dyuproject.protostuff.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author HuSen
 * create on 2020/3/12 11:32 上午
 */
@Getter
@Setter
public class PlayerInfo {
    @Tag(1)
    private String userId;
    @Tag(2)
    private String zone;
    @Tag(3)
    private String nick;
    @Tag(4)
    private int icon;
    @Tag(5)
    private int level;
    @Tag(6)
    private int vip;
    @Tag(7)
    private BanSay banSay;
    @Tag(8)
    private String union;
    @Tag(9)
    private List<Integer> availableIcons;
    @Tag(10)
    private int showHero;
    @Tag(11)
    private List<Integer> availableRelic;

    @Getter
    @Setter
    public static class BanSay {
        /**
         * 禁言开始时间
         */
        @Tag(1)
        private String beginBanSay;
        /**
         * 结束禁言时间
         */
        @Tag(2)
        private String endBanSay;
        /**
         * 备注，一般是封禁原因，例如玩家违规操作，给与封禁等
         */
        @Tag(3)
        private String remark;
    }
}
