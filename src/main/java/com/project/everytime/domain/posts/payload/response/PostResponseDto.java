package com.project.everytime.domain.posts.payload.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostResponseDto(
        Long id,
        String title,
        String content,
        LocalDateTime regDate,
        Long likeCount,
        boolean public_status,
        Long writerId
) {
}
