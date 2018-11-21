package com.chenhaibo.registry;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/20 23:07
 * @Description:
 */
public interface ServiceRegistry {

    /**
     * 注册服务信息
     *
     * @param serviceName    服务名称
     * @param serviceAddress 服务地址
     */
    void register(String serviceName, String serviceAddress);
}