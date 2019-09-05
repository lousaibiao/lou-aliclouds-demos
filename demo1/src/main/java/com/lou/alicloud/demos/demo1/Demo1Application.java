package com.lou.alicloud.demos.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope
@EnableFeignClients
public class Demo1Application {

    @Autowired
    public Demo1Application(Demo2Service demo2Service) {
        this.demo2Service = demo2Service;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    private final Demo2Service demo2Service;

    @Value(value = "${person.name:aa}")
    private String personName;

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable(name = "name") String name) {
        return "hello " + name;
    }

    @GetMapping("getPersonName")
    public String getPersonName() {
        return personName;
    }

    @GetMapping("feignTest")
    public String feignTest(@RequestParam(value = "name") String name) {
        return demo2Service.getAppName(name);
    }
}
