package com.ciotems.consumerservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hgy.consumer")
//@NacosConfigurationProperties(dataId = "service-consumer.yaml", prefix = "ciotems", autoRefreshed = true)
@Component
@Data
public class ConsumerConfig {
    private String name;
    private String title;
    private String version;
    private String desc;
    private String author;
    private String email;

}
