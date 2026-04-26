package com.loganhere.usercard.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "error.email")
public class UserCardProperties {
    private String nullException;
    private String invalid;
    private String duplicate;
}
