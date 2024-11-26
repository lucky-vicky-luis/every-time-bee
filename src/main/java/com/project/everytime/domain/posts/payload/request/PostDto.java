package com.project.everytime.domain.posts.payload.request;

import jakarta.validation.constraints.NotBlank;

public record PostDto(
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
