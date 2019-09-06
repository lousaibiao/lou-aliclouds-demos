package com.lou.dubbo.provider.service.impl;

import com.lou.dubbo.provider.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "${dubbo.application.version}")
public class HelloServiceImpl implements HelloService {
    @Override
    public String getHello(String name) {
        return "this is HelloServiceImpl for name: " + name;
    }
}
