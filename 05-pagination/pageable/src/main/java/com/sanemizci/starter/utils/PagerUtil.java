package com.sanemizci.starter.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass
public class PagerUtil {

    public Boolean isNullOrEmpty(String value){
        return value == null || value.trim().length() == 0;
    }

    public Pageable toPageable(RestPageableRequest request){
        Sort sort = Sort.unsorted(); // default: sıralama yok

        if (!isNullOrEmpty(request.getColumnName())) {
            boolean asc = Boolean.TRUE.equals(request.getAsc());
            sort = Sort.by(
                    asc ? Sort.Direction.ASC : Sort.Direction.DESC,
                    request.getColumnName()
            );
            return PageRequest.of(request.getPageNumber(), request.getPageSize(), sort);
        }

        return PageRequest.of(request.getPageNumber(), request.getPageSize());
    }

    public <T> RestPageableEntitiy <T> toPageableResponse(Page<?> page, List<T> content) {
        RestPageableEntitiy<T> restPageableEntitiy=new RestPageableEntitiy<T>();
        restPageableEntitiy.setContent(content);
        restPageableEntitiy.setPageSize(page.getSize());
        restPageableEntitiy.setPageNumber(page.getNumber());
        restPageableEntitiy.setTotalElements(page.getTotalElements());
        return restPageableEntitiy;
    }
}

