package com.qdhh.game.tianming.connect;

import com.dyuproject.protostuff.Tag;

import java.util.Arrays;

/**
 * @author HuSen
 * create on 2020/3/5 15:09
 */
public class ConnectReq {
    @Tag(1)
    public String uniqueIdentifier;
    @Tag(2)
    public byte[] randomBytes;
    @Tag(3)
    public byte[] encodeBytes;
    @Tag(4)
    public String zoneTag;
    @Tag(5)
    public String channel;
    @Tag(6)
    public String platform;
    @Tag(7)
    public String idfa;
    @Tag(8)
    public String imei;
    @Tag(9)
    public String androidid;
    @Tag(10)
    public String os;
    @Tag(11)
    public String device;
    @Tag(12)
    public boolean checkSmallGame;

    @Override
    public String toString() {
        return "ConnectReq{" +
                "uniqueIdentifier='" + uniqueIdentifier + '\'' +
                ", randomBytes=" + Arrays.toString(randomBytes) +
                ", encodeBytes=" + Arrays.toString(encodeBytes) +
                ", zoneTag='" + zoneTag + '\'' +
                ", channel='" + channel + '\'' +
                ", platform='" + platform + '\'' +
                ", idfa='" + idfa + '\'' +
                ", imei='" + imei + '\'' +
                ", androidid='" + androidid + '\'' +
                ", os='" + os + '\'' +
                ", device='" + device + '\'' +
                ", checkSmallGame=" + checkSmallGame +
                '}';
    }
}
