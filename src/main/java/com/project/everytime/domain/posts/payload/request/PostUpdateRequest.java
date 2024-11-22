package com.project.everytime.domain.posts.payload.request;

import java.time.LocalDateTime;

public record PostUpdateRequest (
        Long id,
        String title,
        String content,
        LocalDateTime regDate,
        Long likeCount,
        boolean public_status,
        Long writerId
) {
}
