package com.project.everytime.domain.posts.payload.request;

public record PostDeleteRequest(
        Long postId,
        Long writerId
) {
}
