package com.project.everytime.domain.posts.payload.request;

import jakarta.validation.constraints.NotBlank;

public record PostDeleteRequest(
        @NotBlank
        Long postId,
        @NotBlank
        Long writerId
) {
}
