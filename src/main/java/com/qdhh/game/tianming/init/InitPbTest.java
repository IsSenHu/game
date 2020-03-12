package com.qdhh.game.tianming.init;

import com.qdhh.game.tianming.AbstractTest;

/**
 * @author HuSen
 * create on 2020/3/5 18:07
 */
public class InitPbTest extends AbstractTest<InitPBItemReq, InitPBItemResp> {
    public static void main(String[] args) throws Exception {
        new InitPbTest().run();
    }
    @Override
    protected String url() {
        return "initPBItem";
    }

    @Override
    protected String sessionId() {
        return "55683b5e-034a-4b72-9f7c-07eb10d09186";
    }

    @Override
    protected InitPBItemReq buildRequest() {
        InitPBItemReq req = new InitPBItemReq();
        req.types.add(6);
        return req;
    }

    @Override
    protected Class<InitPBItemReq> reqClass() {
        return InitPBItemReq.class;
    }

    @Override
    protected Class<InitPBItemResp> respClass() {
        return InitPBItemResp.class;
    }
}
