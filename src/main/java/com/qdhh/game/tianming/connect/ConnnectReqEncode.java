package com.qdhh.game.tianming.connect;

import com.dyuproject.protostuff.Tag;

/**
 * @author HuSen
 * create on 2020/3/5 16:21
 */
public class ConnnectReqEncode {
    @Tag(1)
    public byte[] certificate;
    @Tag(2)
    public byte[] randomBytes;
}
