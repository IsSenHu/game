package com.qdhh.game.tianming.register;

import com.dyuproject.protostuff.Tag;

/**
 * @author HuSen
 * create on 2020/3/5 16:51
 */
public class RegisterRequest {
    @Tag(1)
    public String account;
    @Tag(2)
    public String pwd;
}
