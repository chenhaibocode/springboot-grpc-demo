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
import java.net.InetAddress;
import java.util.Map;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/20 23:12
 * @Description:
 */
@Component
public class RegistryListener implements ServletContextListener {

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
                serviceRegistry.register(bean.getClass().getName(), String.format("%s:%d", getLocalAddress(), serverPort));
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private String getLocalAddress(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0.0.0.0";
    }
}
