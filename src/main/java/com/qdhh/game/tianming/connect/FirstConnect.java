package com.qdhh.game.tianming.connect;

import com.qdhh.game.MyEncrypt;
import com.qdhh.game.MyMD5Util;
import com.qdhh.game.ProtocstuffUtils;
import com.qdhh.game.XXTEAUtil;
import com.qdhh.game.tianming.AbstractTest;

import java.io.IOException;

/**
 * @author HuSen
 * create on 2020/3/5 15:10
 */
public class FirstConnect extends AbstractTest<ConnectReq, ConnectResp> {
    public static void main(String[] args) throws Exception {
        ConnectResp run = new FirstConnect().run();
        System.out.println(run);
    }

    @Override
    protected ConnectReq buildRequest() throws Exception {
        ConnectReq connectReq = new ConnectReq();
        connectReq.uniqueIdentifier = "1123";
        connectReq.randomBytes = "123".getBytes();

        byte[] certif = MyEncrypt.GenCertif(connectReq.uniqueIdentifier, connectReq.randomBytes);
        ConnnectReqEncode reqEncode = new ConnnectReqEncode();
        reqEncode.certificate = certif;
        reqEncode.randomBytes = connectReq.randomBytes;
        connectReq.encodeBytes = XXTEAUtil.Encrypt(ProtocstuffUtils.bean2Byte(reqEncode, ConnnectReqEncode.class), null, certif);

        connectReq.zoneTag = "destiny";
        connectReq.channel = "zone-10000";
        connectReq.platform = "ios";
        connectReq.idfa = "222222222222222222222222";
        connectReq.imei = "222222222222222222222222";
        connectReq.androidid = "222222222222222222222222";
        connectReq.os = "ios13.2";
        connectReq.device = "iphone11";
        connectReq.checkSmallGame = false;
        return connectReq;
    }

    @Override
    protected Class<ConnectReq> reqClass() {
        return ConnectReq.class;
    }

    @Override
    protected Class<ConnectResp> respClass() {
        return ConnectResp.class;
    }

    @Override
    protected String sessionId() {
        return "";
    }

    @Override
    protected String url() {
        return "firstConnect";
    }

    @Override
    protected byte[] reqKey() throws Exception {
        return MyMD5Util.Md5_16("whatADay");
    }

    @Override
    protected byte[] respKey() {
        return "123".getBytes();
    }
}
