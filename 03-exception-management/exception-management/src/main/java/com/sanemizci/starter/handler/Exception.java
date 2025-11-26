package com.sanemizci.starter.handler;

import lombok.Data;

import java.util.Date;

@Data
public class Exception<E> {
    private String hostName;
    private String path;
    private Date createDate;
    private E message;

}
