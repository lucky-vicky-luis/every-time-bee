package com.project.everytime.domain.posts.exception;

import com.project.everytime.global.exception.BusinessException;

public class PostNotFoundException extends BusinessException {
    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException() {
        super(PostError.POST_NOT_FOUND_EXCEPTION);
    }

}
