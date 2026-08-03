package com.loganhere.auto_log_starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(AutoLogProperties.class)
@ConditionalOnProperty(prefix = "auto-log", name = "enabled", havingValue = "true", matchIfMissing = true)
public class AutoLogAutoConfiguration {

    @Bean
    public AutoLogAspect autoLogAspect(AutoLogProperties properties) {
        return new AutoLogAspect(properties);
    }
}
