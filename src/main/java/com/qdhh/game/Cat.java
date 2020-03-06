package com.qdhh.game;

import com.dyuproject.protostuff.Tag;
import lombok.Data;

/**
 * @author HuSen
 * create on 2019/12/30 10:07
 */
@Data
public class Cat {

    @Tag(1)
    private String name;

    @Tag(2)
    private int age;
}
