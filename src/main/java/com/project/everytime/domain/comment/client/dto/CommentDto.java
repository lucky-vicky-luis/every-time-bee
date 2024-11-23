package com.project.everytime.domain.comment.client.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private Long id;
    private String content;
    private Long postId;
    private Long userId;
    private LocalDateTime regDate;

}
