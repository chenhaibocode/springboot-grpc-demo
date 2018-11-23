package com.chenhaibo.configuration;

import com.chenhaibo.registry.ServiceRegistry;
import com.chenhaibo.registry.impl.ServiceRegistryImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/20 23:10
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "registry")
public class RegistryConfig {
    private String servers;
    private String nodepath;

    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistryImpl(servers, nodepath);
    }


    public void setServers(String servers) {
        this.servers = servers;
    }

    public void setNodepath(String nodepath) {
        this.nodepath = nodepath;
    }
}
