package com.sanemizci.starter.Repository;

import com.sanemizci.starter.Model.Personel;
import jakarta.persistence.criteria.From;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonelRepository extends JpaRepository<Personel,Long> {
    @Query(value="from Personel")
    Page<Personel> getAllPageable(Pageable pageable);
}
