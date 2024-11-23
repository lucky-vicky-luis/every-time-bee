package com.project.everytime.domain.comment.client.dto.request;

public record CommentRegisterRequest(
        String content,
        Long postId,
        Long userId
) {
}
