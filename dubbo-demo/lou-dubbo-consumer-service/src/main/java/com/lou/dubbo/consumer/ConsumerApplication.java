package com.lou.dubbo.consumer;

import com.lou.dubbo.provider.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Reference(version = "${provider.service.version}")
    private HelloService helloService;

    @GetMapping("getHello")
    public String getHello(@RequestParam(value = "name") String name) {
        return helloService.getHello(name);
    }

    @GetMapping("test")
    public String test(){
        return "Hello dubbo consumer service";
    }
}
