package com.project.everytime.domain.auth.client.dto.request;

import com.project.everytime.domain.user.domain.enums.School;

public record SignUpRequest(
        String email,
        String nickname,
        String password
//        School school
){}