package com.qdhh.game.tianming.register;

import com.alibaba.fastjson.JSON;
import com.qdhh.game.tianming.AbstractTest;

/**
 * @author HuSen
 * create on 2020/3/5 17:15
 */
public class RegisterTest extends AbstractTest<RegisterRequest, GlobalLoginResp> {
    public static void main(String[] args) throws Exception {
        GlobalLoginResp loginResp = new RegisterTest().run();
        System.out.println(JSON.toJSONString(loginResp, true));
    }

    @Override
    protected RegisterRequest buildRequest() {
        RegisterRequest request = new RegisterRequest();
        request.account = "husen1999";
        request.pwd = "123456";
        return request;
    }

    @Override
    protected Class<RegisterRequest> reqClass() {
        return RegisterRequest.class;
    }

    @Override
    protected Class<GlobalLoginResp> respClass() {
        return GlobalLoginResp.class;
    }

    @Override
    protected String url() {
        return "newRegister";
    }

    @Override
    protected String sessionId() {
        return "55683b5e-034a-4b72-9f7c-07eb10d09186";
    }
}
