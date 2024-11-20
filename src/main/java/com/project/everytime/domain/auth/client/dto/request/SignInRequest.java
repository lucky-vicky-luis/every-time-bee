package com.project.everytime.domain.auth.client.dto.request;

public record SignInRequest(
        String nickname,
        String password
){}