package com.qdhh.game.tianming.connect;

import com.dyuproject.protostuff.Tag;

import java.util.Arrays;

/**
 * @author HuSen
 * create on 2020/3/5 15:18
 */
public class ConnectResp {
    @Tag(1)
    public String sessionId;
    @Tag(2)
    public byte[] randomBytes;
    @Tag(3)
    public String privateKey;
    @Tag(4)
    public String decryptKey;
    @Tag(5)
    public boolean smallGameDownloadEnabled;

    @Override
    public String toString() {
        return "ConnectResp{" +
                "sessionId='" + sessionId + '\'' +
                ", randomBytes=" + Arrays.toString(randomBytes) +
                ", privateKey='" + privateKey + '\'' +
                ", decryptKey='" + decryptKey + '\'' +
                ", smallGameDownloadEnabled=" + smallGameDownloadEnabled +
                '}';
    }
}
