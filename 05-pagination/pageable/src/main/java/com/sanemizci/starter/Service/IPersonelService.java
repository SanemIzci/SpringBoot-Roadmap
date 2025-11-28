package com.sanemizci.starter.Service;

import com.sanemizci.starter.Model.Personel;
import com.sanemizci.starter.dto.DtoPersonel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonelService {

    Page<Personel> getAllPageable(Pageable pageable);
    List<DtoPersonel> toDtoList(List<Personel> personelList);
}
