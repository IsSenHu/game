package com.qdhh.game;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

/**
 * @author HuSen
 * create on 2019/12/30 10:09
 */
public class CatInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ServletInputStream is = request.getInputStream();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            byteStream.write(ch);
        }
        byte[] data = byteStream.toByteArray();
        byteStream.close();
        Cat cat = ProtocstuffUtils.byte2Bean(data, Cat.class);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
