package com.lou.alicloud.demos.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RefreshScope
@RestController
public class Demo2Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @Value("${spring.application.name:}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @GetMapping("getAppName")
    public String getApplicationName(@RequestParam(value = "name") String name) {
        return "hello " + name + ", response from port " + port;
    }

}
