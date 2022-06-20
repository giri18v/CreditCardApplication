package com.creditcard.exception;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;

@Getter
@Setter
public class InvalidParamterException extends RuntimeException{


    private String errorCode;
    private String errorMessage;

    public InvalidParamterException(String errorCode,String message){
        this.errorCode=errorCode;
        this.errorMessage=message;

    }


}
