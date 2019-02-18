package com.chenhaibo.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.util.concurrent.TimeUnit;

@Slf4j
public class HttpUtil {

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS).build();

    public static String sendPostJson(String url, String data) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("content-type", "application/json;charset:utf-8")
                .post(RequestBody.create(
                        MediaType.parse("application/json; charset=utf-8"),
                        data
                )).build();

        String ret = null;
        try {
            Response response = OK_HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                ret = response.body().string();
            }
            log.debug("##HttpUtil.sendPost# 请求数据结果 ，url:{}, data:{}, ret:{}", url, data, ret);
        } catch (Exception e) {
            log.error("##HttpUtil.sendPost# 请求数据失败 ，url:{}, data:{}", url, data, e);
        }

        return ret;
    }
}
