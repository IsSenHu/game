package com.qdhh.game.tianming.targets;

import com.qdhh.game.tianming.AbstractTest;

/**
 * @author HuSen
 * create on 2020/3/12 12:20 下午
 */
public class TargetTest extends AbstractTest<GetAPArenaTargetsReq, Object> {

    public static void main(String[] args) throws Exception {
        new TargetTest().run();
    }

    @Override
    protected String url() {
        return "getAPArenaTargets";
    }

    @Override
    protected String sessionId() {
        return "f21c3781-ba58-42a9-8a29-1232061bc7b9";
    }

    @Override
    protected GetAPArenaTargetsReq buildRequest() {
        return new GetAPArenaTargetsReq();
    }

    @Override
    protected Class<GetAPArenaTargetsReq> reqClass() {
        return GetAPArenaTargetsReq.class;
    }

    @Override
    protected Class<Object> respClass() {
        return Object.class;
    }
}
