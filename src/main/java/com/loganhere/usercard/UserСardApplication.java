package com.loganhere.usercard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserСardApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserСardApplication.class, args);
	}

}
