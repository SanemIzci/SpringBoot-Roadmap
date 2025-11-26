package com.example.starter.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DtoStudentIU {

    @NotEmpty(message = "Firstname alanı boş bırakılamaz")
    @Size(min = 3, max = 15)
    private String firstName;

    @Size(min = 2, max = 30)
    private String lastName;

    private LocalDate dateOfBirth;

    @Email(message = "Please enter a valid email")
    private String email;

    @Size(min = 11, max = 11, message = "TCKN 11 basamaklı olmalıdır")
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String tckn;
}
