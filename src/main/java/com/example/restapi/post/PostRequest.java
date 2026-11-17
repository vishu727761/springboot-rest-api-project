package com.example.restapi.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title must not exceed 100 characters")
        String title,

        @NotBlank(message = "Content is required")
        @Size(min = 5, max = 1000, message = "Content must be between 5 and 1000 characters")
        String content
) {}
