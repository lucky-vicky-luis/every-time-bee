package com.project.everytime.domain.user.exception;

import com.project.everytime.global.exception.BusinessException;

public class UserException extends BusinessException {
    private static final UserException USER_NOT_FOUND_EXCEPTION = new UserException(UserError.USER_NOT_FOUND_EXCEPTION);

    public UserException(UserError error) {
        super(error);
    }

    public static UserException notFoundUser() {
        return USER_NOT_FOUND_EXCEPTION;
    }
}
