package com.ciotems.nacosdiscoverprovider;

import com.ciotems.nacosdiscoverprovider.configuration.SpringYmlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ServiceProviderApplication {

    public static void main(String[] args) {
      var context =  SpringApplication.run(ServiceProviderApplication.class, args);
        SpringYmlConfig springYmlConfig = context.getBean(SpringYmlConfig.class);
        log.info("http://localhost:{}{}/doc.html", springYmlConfig.getPort(), springYmlConfig.getContextPath());
    }

}
