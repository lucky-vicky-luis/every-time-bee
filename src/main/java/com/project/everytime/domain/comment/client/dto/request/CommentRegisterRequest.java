package com.project.everytime.domain.comment.client.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CommentRegisterRequest(
        @NotBlank
        String content,
        @NotBlank
        Long postId,
        @NotBlank
        Long userId
) {
}
