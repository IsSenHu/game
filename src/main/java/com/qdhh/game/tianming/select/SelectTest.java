package com.qdhh.game.tianming.select;

import com.alibaba.fastjson.JSON;
import com.qdhh.game.tianming.AbstractTest;

/**
 * @author HuSen
 * create on 2020/3/6 9:45
 */
public class SelectTest extends AbstractTest<SelectReq, SelectResp> {
    public static void main(String[] args) throws Exception {
        SelectResp run = new SelectTest().run();
        System.out.println(JSON.toJSONString(run, true));
    }
    @Override
    protected String url() {
        return "selectStageType";
    }

    @Override
    protected String sessionId() {
        return "24028c62-cc4a-4f1d-84df-e56de55e28ae";
    }

    @Override
    protected SelectReq buildRequest() {
        SelectReq req = new SelectReq();
        req.type = 1;
        return req;
    }

    @Override
    protected Class<SelectReq> reqClass() {
        return SelectReq.class;
    }

    @Override
    protected Class<SelectResp> respClass() {
        return SelectResp.class;
    }
}
