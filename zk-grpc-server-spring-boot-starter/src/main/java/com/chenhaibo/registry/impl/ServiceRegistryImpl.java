package com.chenhaibo.registry.impl;

import com.chenhaibo.registry.ServiceRegistry;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/20 23:08
 * @Description:
 */
@Component
public class ServiceRegistryImpl implements ServiceRegistry, Watcher {

    private static final String digest = "digest";
    private String REGISTRY_PATH;
    private static final int SESSION_TIMEOUT = 20000;

    private Logger logger = LoggerFactory.getLogger(ServiceRegistryImpl.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private ZooKeeper zk;

    public ServiceRegistryImpl() {
    }

    public ServiceRegistryImpl(String zkServers, String nodepath, String username, String password) {
        try {
            zk = new ZooKeeper(zkServers, SESSION_TIMEOUT, this);
            String idPassword = username + ":" + password;
            zk.addAuthInfo(digest, idPassword.getBytes());
            REGISTRY_PATH = nodepath;
            latch.await();
            logger.debug("connected to zookeeper");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("create zookeeper client failure", e);
        }
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        //创建跟节点
        String registryPath = REGISTRY_PATH;
        try {
            //创建节点,创建
            if (zk.exists(registryPath, false) == null) {
                zk.create(registryPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                logger.debug("create registry node :" + registryPath);
            }
            //创建服务节点,临时节点
            String addressPath = registryPath + "/" + serviceName;
            String addressNode = zk.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.info("create address node serviceAddress:" + serviceAddress + " addressNode:" + addressNode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("create node failure", e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            latch.countDown();
        }
    }
}