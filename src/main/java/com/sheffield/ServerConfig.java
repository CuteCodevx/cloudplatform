package com.sheffield;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig  implements ApplicationListener<WebServerInitializedEvent> {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            return "http://"+address.getHostAddress() +":8080/";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
    }



    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        return factory.createMultipartConfig();
    }


}
