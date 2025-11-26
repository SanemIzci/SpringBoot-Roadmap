package com.example.starter.config;
import com.example.starter.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Sanem", "Izci"));
        employees.add(new Employee("2", "Ada", "Lovelace"));
        employees.add(new Employee("3", "Grace", "Hopper"));
        employees.add(new Employee("4", "Alan", "Turing"));
        employees.add(new Employee("5", "Linus", "Torvalds"));
        employees.add(new Employee("6", "Sanem", "Lorem"));
        return employees;
    }
}
