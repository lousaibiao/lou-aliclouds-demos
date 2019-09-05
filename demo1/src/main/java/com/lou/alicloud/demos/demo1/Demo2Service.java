package com.lou.alicloud.demos.demo1;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-service2")
public interface Demo2Service {
    @GetMapping("getAppName")
    @LoadBalanced
    String getAppName(@RequestParam(value = "name") String name);
}
