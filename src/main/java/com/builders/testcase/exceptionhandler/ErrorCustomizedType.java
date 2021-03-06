package com.builders.testcase.exceptionhandler;

import lombok.Getter;

@Getter
public enum ErrorCustomizedType {

    ERROR_SYSTEM("Error of system"),
    ERROR_BUSINESS("Error business");

    private String title;

    ErrorCustomizedType(String title){
        this.title = title;
    }
}
