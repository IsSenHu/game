package com.qdhh.game.tianming.pb;

import com.dyuproject.protostuff.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author HuSen
 * create on 2020/3/12 11:51 上午
 */
@Getter
@Setter
public class HeroItem {
    @Tag(1)
    private int id;
    @Tag(2)
    private int heroId;
    @Tag(3)
    private int grade;
    @Tag(4)
    private int level;
    @Tag(5)
    private int weaponId;
    @Tag(6)
    private int hatId;
    @Tag(7)
    private int clothId;
    @Tag(8)
    private int shoesId;
    @Tag(9)
    private int relicId;
    @Tag(10)
    private Rune rune;
    @Tag(11)
    private int duty;
    @Tag(12)
    private int star;
    @Tag(13)
    private List<Integer> duties;

    @Getter
    @Setter
    public static class Rune {
        @Tag(1)
        private int level;
        @Tag(2)
        private List<Integer> props;
        @Tag(3)
        private List<Integer> tempProps;
    }
}
