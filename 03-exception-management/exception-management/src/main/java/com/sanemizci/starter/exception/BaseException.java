package com.sanemizci.starter.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BaseException extends RuntimeException{

    public BaseException(){

    }

    public BaseException(ErrorMessage errorMessage){
        super(errorMessage.prepareErrorMessage());

    }



}
