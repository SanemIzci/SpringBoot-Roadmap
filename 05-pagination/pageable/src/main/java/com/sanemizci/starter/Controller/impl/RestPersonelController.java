package com.sanemizci.starter.Controller.impl;

import com.sanemizci.starter.Controller.IRestPersonelController;
import com.sanemizci.starter.Model.Personel;
import com.sanemizci.starter.Service.IPersonelService;
import com.sanemizci.starter.dto.DtoPersonel;
import com.sanemizci.starter.utils.RestPageableEntitiy;
import com.sanemizci.starter.utils.RestPageableRequest;
import com.sanemizci.starter.utils.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/api/personel")
public class RestPersonelController extends RestBaseController implements IRestPersonelController {

    @Autowired
    private IPersonelService personelService;

    @GetMapping("/list/pageable")
    @Override
    public RootEntity<RestPageableEntitiy<DtoPersonel>> getAllPageable(RestPageableRequest restPageableRequest) {
        Page<Personel> page=personelService.getAllPageable(toPageable(restPageableRequest));
        RestPageableEntitiy<DtoPersonel>pageableResponse=toPageableResponse(page,personelService.toDtoList(page.getContent()));
        return ok(pageableResponse);
    }
}
