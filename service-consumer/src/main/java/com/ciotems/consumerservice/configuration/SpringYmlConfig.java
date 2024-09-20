package com.ciotems.consumerservice.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huguoya
 */
@Component
@Getter
public class SpringYmlConfig {
    @Value("${spring.profiles.active:}")
    private String profilesActive;
    @Value("${server.port:}")
    private String port;
    @Value("${server.servlet.context-path:}")
    private String contextPath = "/";
}
