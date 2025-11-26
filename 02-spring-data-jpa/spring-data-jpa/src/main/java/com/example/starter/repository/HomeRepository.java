package com.example.starter.repository;

import com.example.starter.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {

}
