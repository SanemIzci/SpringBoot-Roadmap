package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.utils.PagerUtil;
import com.sanemizci.starter.utils.RestPageableEntitiy;
import com.sanemizci.starter.utils.RestPageableRequest;
import com.sanemizci.starter.utils.RootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestBaseController {
    public Pageable toPageable(RestPageableRequest request){
        return PagerUtil.toPageable(request);
    }
    public <T> RestPageableEntitiy<T> toPageableResponse(Page<?> page, List<T> content){
        return PagerUtil.toPageableResponse(page,content);
    
    }
    public <T> RootEntity<T> ok(T payload){
        return RootEntity.ok(payload);
    }
}
