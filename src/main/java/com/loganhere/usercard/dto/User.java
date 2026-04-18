package com.loganhere.usercard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    @NotBlank
    private String name;
}
