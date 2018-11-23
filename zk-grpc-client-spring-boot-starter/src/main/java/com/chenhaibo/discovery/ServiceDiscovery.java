package com.chenhaibo.discovery;

import io.grpc.ManagedChannel;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/23 00:04
 * @Description:
 */
public interface ServiceDiscovery {

    ManagedChannel getManagedChannel();
}
