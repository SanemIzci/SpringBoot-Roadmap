package com.sanemizci.starter.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity<T> {

    private Boolean result;
    private String errorMessage;
    private T data;


    //This is for the success case
    public static <T> RootEntity<T> ok(T data){
        RootEntity <T> rootEntity = new RootEntity<>();
        rootEntity.setData(data);
        rootEntity.setResult(true);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }
    //This is for the error case
    public static <T> RootEntity<T> error(String errorMessage){
        RootEntity <T> rootEntity=new RootEntity<>();
        rootEntity.setResult(false);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }



}
