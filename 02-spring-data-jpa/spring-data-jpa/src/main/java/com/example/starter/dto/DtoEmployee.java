package com.example.starter.dto;

import com.example.starter.entities.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {

    private Long id;

    private String name;

    private DtoDepartment department;
}
