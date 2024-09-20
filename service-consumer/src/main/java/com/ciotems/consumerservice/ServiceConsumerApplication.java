package com.ciotems.consumerservice;

import com.ciotems.consumerservice.configuration.SpringYmlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class ServiceConsumerApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ServiceConsumerApplication.class, args);
        SpringYmlConfig springYmlConfig = context.getBean(SpringYmlConfig.class);
        log.info("http://localhost:{}{}/doc.html", springYmlConfig.getPort(), springYmlConfig.getContextPath());
    }

}
