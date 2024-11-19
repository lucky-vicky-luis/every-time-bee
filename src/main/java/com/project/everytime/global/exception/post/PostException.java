package com.project.everytime.global.exception.post;

import com.project.everytime.global.exception.BusinessException;

public class PostException extends BusinessException {
    private static final PostException POST_NOT_FOUND_EXCEPTION = new PostException(PostError.POST_NOT_FOUND_EXCEPTION);

    public PostException(PostError error) {
        super(error);
    }

    public static PostException notFoundPost() {
        return POST_NOT_FOUND_EXCEPTION;
    }
}
