package com.qdhh.game.tianming.enter;

import com.alibaba.fastjson.JSON;
import com.qdhh.game.tianming.AbstractTest;

import java.util.ArrayList;

/**
 * @author HuSen
 * create on 2020/3/5 17:44
 */
public class EnterTest extends AbstractTest<CheckValueReq, CheckValueResp> {
    public static void main(String[] args) throws Exception {
        CheckValueResp checkValueResp = new EnterTest().run();
        System.out.println(JSON.toJSONString(checkValueResp, true));
    }
    @Override
    protected String url() {
        return "enterGame";
    }

    @Override
    protected String sessionId() {
        return "55683b5e-034a-4b72-9f7c-07eb10d09186";
    }

    @Override
    protected CheckValueReq buildRequest() throws Exception {
        return new CheckValueReq();
    }

    @Override
    protected Class<CheckValueReq> reqClass() {
        return CheckValueReq.class;
    }

    @Override
    protected Class<CheckValueResp> respClass() {
        return CheckValueResp.class;
    }
}
