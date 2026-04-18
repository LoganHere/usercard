package com.loganhere.usercard.emailvalidation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-validation-service", url = "http://localhost:8081")
public interface EmailValidationClient {

    @PostMapping("/email/validate")
    EmailValidationResponse validateEmail(@RequestBody EmailValidateRequest request);
}
