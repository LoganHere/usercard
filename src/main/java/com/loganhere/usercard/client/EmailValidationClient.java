package com.loganhere.usercard.client;

import com.loganhere.usercard.dto.EmailValidateRequest;
import com.loganhere.usercard.dto.EmailValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-validation-service", url = "${validate.server.url}")
public interface EmailValidationClient {

    @PostMapping
    EmailValidationResponse validateEmail(@RequestBody EmailValidateRequest request);
}
