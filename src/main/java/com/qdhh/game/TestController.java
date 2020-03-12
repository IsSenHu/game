package com.qdhh.game;

import com.qdhh.game.proto.RpcProto;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author HuSen
 * create on 2019/12/30 10:04
 */
@Slf4j
@Controller
public class TestController {

    @PostMapping("/show")
    public ResponseEntity<RpcProto.Cat> show(RequestEntity<RpcProto.Cat>  cat) {
        log.info("小猫咪:{}", cat.getBody());
        return ResponseEntity.ok(Objects.requireNonNull(cat.getBody()));
    }

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) {
        RpcProto.Cat cat = RpcProto.Cat.newBuilder().setName("小花").setAge(23).build();
        Request.Builder builder = new Request.Builder()
                .url("http://localhost:8080/show")
                .addHeader("Content-Type", "application/x-protobuf")
                .addHeader("Accept", "application/x-protobuf")
                .post(RequestBody.create(cat.toByteArray()));
        Request request = builder.build();
        Call call = CLIENT.newCall(request);
        try (Response response = call.execute()) {
            ResponseBody body = response.body();
            if (body == null) {
                return;
            }
            RpcProto.Cat parseFrom = RpcProto.Cat.parseFrom(body.bytes());
            log.debug("响应:{}", parseFrom);
        } catch (Exception e) {
            log.error("请求到指定地址发送错误:{}", call.request().url());
        }
    }
}
