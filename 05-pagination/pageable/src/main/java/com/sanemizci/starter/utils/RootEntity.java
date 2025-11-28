package com.sanemizci.starter.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RootEntity<T> {
    private int status;

    private T payload;

    private String errorMessage;

    public static <T> RootEntity<T> ok(T payload) {
        RootEntity<T> rootEntity = new RootEntity<T>();
        rootEntity.setStatus(HttpStatus.OK.value());
        rootEntity.setPayload(payload);
        rootEntity.setErrorMessage(null);
        return rootEntity;

    }
}
