package com.project.everytime.global.exception.post;

import com.project.everytime.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostError implements ErrorProperty {
    POST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 게시글을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
