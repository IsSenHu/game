package com.qdhh.game;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import java.nio.charset.StandardCharsets;

/**
 * @author HuSen
 * create on 2019/12/30 10:30
 */
@Configuration
public class Config {

    @Bean
    public HttpMessageConverters messageConverters() {
        ProtobufHttpMessageConverter converter = new ProtobufHttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        return new HttpMessageConverters(converter);
    }
}
