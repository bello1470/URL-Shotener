package com.bellotech.urlshortener.web.dtos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;


public record CreateShortUrlForm(
        @NotBlank(message = "Original URL is required")
        String originalUrl) {
}
