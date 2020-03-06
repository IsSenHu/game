package com.qdhh.game.tianming.coin;

import com.alibaba.fastjson.JSON;
import com.qdhh.game.tianming.AbstractTest;

/**
 * @author HuSen
 * create on 2020/3/5 17:57
 */
public class AddCoinTest extends AbstractTest<GmAddReq, GmResp> {
    public static void main(String[] args) throws Exception {
        GmResp resp = new AddCoinTest().run();
        System.out.println(JSON.toJSONString(resp, true));
    }
    @Override
    protected String url() {
        return "gmAddCoin";
    }

    @Override
    protected String sessionId() {
        return "55683b5e-034a-4b72-9f7c-07eb10d09186";
    }

    @Override
    protected GmAddReq buildRequest() throws Exception {
        GmAddReq req = new GmAddReq();
        req.count = 1000_000_0;
        req.id = 6;
        return req;
    }

    @Override
    protected Class<GmAddReq> reqClass() {
        return GmAddReq.class;
    }

    @Override
    protected Class<GmResp> respClass() {
        return GmResp.class;
    }
}
