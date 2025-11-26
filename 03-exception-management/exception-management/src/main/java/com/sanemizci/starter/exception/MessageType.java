package com.sanemizci.starter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum MessageType {

    NO_RECORD_EXIST("1001","NO RECORDS FOUND"),
    GENERAL_EXCEPTİON("9999","GENERAL ERROR OCCURED");

    private String code;
    private String message;


    MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }

}
