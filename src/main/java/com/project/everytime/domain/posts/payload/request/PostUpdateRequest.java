package com.project.everytime.domain.posts.payload.request;

import jakarta.validation.constraints.NotBlank;

public record PostUpdateRequest (
        @NotBlank
        String title,
        @NotBlank
        String content,
        @NotBlank
        Long likeCount,
        @NotBlank
        boolean public_status,
        @NotBlank
        Long writerId
) {
}
