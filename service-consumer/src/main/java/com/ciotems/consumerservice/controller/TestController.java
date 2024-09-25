package com.ciotems.consumerservice.controller;

import com.alibaba.fastjson2.JSON;
import com.ciotems.consumerservice.configuration.ConsumerConfig;
import com.ciotems.consumerservice.service.EchoService;
import jakarta.annotation.Resource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private EchoService echoService;
    @Resource
    private ConsumerConfig consumerConfig;
    @Resource
    private Environment environment;


    @GetMapping(value = "/ciotems-config")
    public String ciotemsConfig() {
//        String env = environment.getProperty("ciotems.name");

        return JSON.toJSONString(consumerConfig);
    }

    @GetMapping(value = "/echo-rest")
    public String rest(@RequestParam String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
    }

    @GetMapping(value = "/echo-feign")
    public String feign(@RequestParam String str) {
        return echoService.echo(str);
    }
}
