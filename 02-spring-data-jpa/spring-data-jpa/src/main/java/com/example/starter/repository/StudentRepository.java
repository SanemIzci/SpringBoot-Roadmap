package com.example.starter.repository;

import com.example.starter.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value="from Student",nativeQuery=false)
    List<Student> findAllStudents();

    @Query(value="from Student s WHERE s.id=:studentId")
    Optional<Student> findStudentById(Long studentId);

}
