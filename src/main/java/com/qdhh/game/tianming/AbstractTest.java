package com.qdhh.game.tianming;

import com.qdhh.game.ProtocstuffUtils;
import com.qdhh.game.XXTEAUtil;
import okhttp3.*;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author HuSen
 * create on 2020/3/5 16:58
 */
public abstract class AbstractTest<Req, Resp> {
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(1000, TimeUnit.SECONDS)
            .build();

    public Resp run() throws Exception {
        Req req = buildRequest();

        byte[] bytes = ProtocstuffUtils.bean2Byte(req, reqClass());
        if (bytes == null) {
            throw new RuntimeException();
        }
        byte[] data = new byte[bytes.length + 1];
        data[0] = 1;
        System.arraycopy(bytes, 0, data, 1, bytes.length);

        Request.Builder builder = new Request.Builder()
                .url("http://121.199.5.122:8080/zhmjServer/")
                .addHeader("URL", url())
                .addHeader("lan", "zh")
                .addHeader("Session", sessionId())
                .post(RequestBody.create(XXTEAUtil.Encrypt(data, null, reqKey())));

        Request request = builder.build();
        Call call = CLIENT.newCall(request);

        try (Response response = call.execute()) {
            ResponseBody body = response.body();
            if (body == null) {
                throw new RuntimeException();
            }

            byte[] resp = body.bytes();
            byte[] md5AndContext = Arrays.copyOfRange(resp, 17, resp.length);
            byte[] decrypt = XXTEAUtil.Decrypt(md5AndContext, null, respKey());
            HttpResp httpResp = ProtocstuffUtils.byte2Bean(decrypt, HttpResp.class);
            return ProtocstuffUtils.byte2Bean(httpResp.resp, respClass());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected abstract String url();

    protected abstract String sessionId();

    protected byte[] reqKey() throws Exception {
        return new BASE64Decoder().decodeBuffer("MTIz");
    }

    protected byte[] respKey() throws IOException {
        return new BASE64Decoder().decodeBuffer("MTIz");
    }

    protected abstract Req buildRequest() throws Exception;
    protected abstract Class<Req> reqClass();
    protected abstract Class<Resp> respClass();
}
