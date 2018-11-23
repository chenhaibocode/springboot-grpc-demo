package com.chenhaibo.listener;

import com.chenhaibo.registry.ServiceRegistry;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/20 23:12
 * @Description:
 */
@Component
public class RegistryListener implements ServletContextListener {

    private String serverAddress = "0.0.0.0";

    @Value("${grpc.server.port}")
    private int serverPort;

    @Autowired
    private ServiceRegistry serviceRegistry;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(GrpcService.class);
        for (Object bean : beans.values()) {
            if(null != bean) {
                //注册服务
                serviceRegistry.register(bean.getClass().getName(), String.format("%s:%d", serverAddress, serverPort));
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
