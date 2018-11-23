package com.chenhaibo.configuration;

import com.chenhaibo.discovery.ServiceDiscovery;
import com.chenhaibo.discovery.impl.ServiceDiscoveryImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/22 17:51
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "registry")
public class DiscoveryConfig {
    private String servers;
    private String nodepath;

    @Bean
    public ServiceDiscovery serviceDiscovery() {
        return new ServiceDiscoveryImpl(servers, nodepath) ;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public void setNodepath(String nodepath) {
        this.nodepath = nodepath;
    }
}
