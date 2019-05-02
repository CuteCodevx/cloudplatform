package com.sheffield.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 0:44
 * @version 1.0
 */
@Component
public class ServerConfig  implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            return "http://"+address.getHostAddress() +":"+this.serverPort + "/";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }
}
