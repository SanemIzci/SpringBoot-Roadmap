package com.sanemizci.starter.Controller;

import com.sanemizci.starter.Model.Personel;
import com.sanemizci.starter.dto.DtoPersonel;
import com.sanemizci.starter.utils.RestPageableEntitiy;
import com.sanemizci.starter.utils.RestPageableRequest;
import com.sanemizci.starter.utils.RootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRestPersonelController {

    public RootEntity<RestPageableEntitiy<DtoPersonel>> getAllPageable(RestPageableRequest pageableRequest);
}
