package com.lou.alicloud.demos.demo1;

import org.springframework.stereotype.Component;

@Component
public class Demo2ServiceFallback implements Demo2Service {
    @Override
    public String getAppName(String name) {
        return "服务挂了，没有appname";
    }
}
