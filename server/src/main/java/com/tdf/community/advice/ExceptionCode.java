package com.tdf.community.advice;

import lombok.Getter;

public enum ExceptionCode {

    FILE_SIZE_EXCEED(404,"파일사이즈를 초과하였습니다");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }

}
