package com.project.everytime.domain.posts.payload.request;

import java.time.LocalDateTime;

public record PostDto(
        Long id,
        String title,
        String content,
        LocalDateTime redDate,
        Long likeCount,
        boolean public_status
) {
}
