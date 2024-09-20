package com.ciotems.consumerservice.controller;

import com.alibaba.fastjson2.JSON;
import com.ciotems.consumerservice.configuration.CiotemsConfig;
import com.ciotems.consumerservice.service.EchoService;
import jakarta.annotation.Resource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private EchoService echoService;
    @Resource
    private CiotemsConfig ciotemsConfig;
    @Resource
    private Environment environment;


    @GetMapping(value = "/ciotems-config")
    public String ciotemsConfig() {
//        String env = environment.getProperty("ciotems.name");

        return JSON.toJSONString(ciotemsConfig);
    }

    @GetMapping(value = "/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
    }

    @GetMapping(value = "/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }
}
