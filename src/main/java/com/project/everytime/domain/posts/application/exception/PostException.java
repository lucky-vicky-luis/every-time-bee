package com.project.everytime.domain.posts.application.exception;

import com.project.everytime.global.exception.BusinessException;

public class PostException extends BusinessException {
    private static final PostException POST_NOT_FOUND_EXCEPTION = new PostException(PostError.POST_NOT_FOUND_EXCEPTION);
    private static final PostException REQUEST_IS_NULL_EXCEPTION = new PostException(PostError.REQUEST_IS_NULL_EXCEPTION);

    public PostException(PostError error) {
        super(error);
    }

    public static PostException notFoundPost() {
        return POST_NOT_FOUND_EXCEPTION;
    }
}
