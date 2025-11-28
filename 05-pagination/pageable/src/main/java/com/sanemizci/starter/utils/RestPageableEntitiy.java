package com.sanemizci.starter.utils;

import lombok.Data;

import java.util.List;

@Data
public class RestPageableEntitiy<T> {
    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private Long totalElements;
}
