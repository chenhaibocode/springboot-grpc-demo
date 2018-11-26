package com.chenhaibo.discovery.impl;

import com.chenhaibo.discovery.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/22 17:49
 * @Description:
 */
@Slf4j
@Component
public class ServiceDiscoveryImpl implements ServiceDiscovery {

    private static final int SESSION_TIMEOUT = 20000;
    private String zkServers;
    private String nodepath;
    private ZooKeeper zk = null;
    // 服务实例
    private Map<String, String> instanceMap;

    public ServiceDiscoveryImpl(){}

    public ServiceDiscoveryImpl(String zkServers, String nodepath){
        this.zkServers = zkServers;
        this.nodepath = nodepath;
        instanceMap = new ConcurrentHashMap<>();
        getZkClient();
    }

    // 获取zk连接
    private void getZkClient() {
        try {
            // 服务器在需求中并不需要做任何监听
            zk = new ZooKeeper(zkServers,
                    SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    try {
                        // 获取新的服务器列表,重新注册监听
                        updateServers();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从zk中获取在线服务器信息
     */
    private void updateServers() throws Exception {
        List<String> children = zk.getChildren(nodepath,true);
        for (String child : children) {
            String path = nodepath + "/" + child;
            byte[] data = zk.getData(path, false, null);
            log.info("zk path : " + path);
            if(null == data || data.length <1) {
                continue;
            }
            log.info("zk value : " + new String(data));
            instanceMap.put(path, new String(data));
        }
    }

    /**
     * 随机获取一个可用的服务地址，作负载均衡使用
     * @return
     */
    private Optional<String> getServer(){
        if(null == instanceMap || instanceMap.size() <1) {
            return Optional.ofNullable(null);
        }
        int size = instanceMap.size();
        if (size == 0) {
            log.error("does not have available server.");
            return Optional.ofNullable(null);
        }
        int rand = new Random().nextInt(size);
        log.info("size=" + size + ",rand=" + rand);;
        String server = (String)instanceMap.values().toArray()[rand];
        return Optional.ofNullable(server);
    }

    @Override
    public ManagedChannel getManagedChannel() {
        Optional<String> server = getServer();
        if (server.isPresent()) {
            String[] array = server.get().split(":");
            log.info("server host=" + array[0] + ",port=" + array[1]);
            ManagedChannel managedChannel = ManagedChannelBuilder
                    .forAddress(array[0], Integer.parseInt(array[1])).usePlaintext().build();
            return managedChannel;
        }else {
            log.error("not find avaliable server====");
        }
        return null;
    }
}