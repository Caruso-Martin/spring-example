package com.springexample.example;

import com.springexample.example.daos.StudentRepository;
import com.springexample.example.domain.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import static java.util.Calendar.APRIL;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student martin = new Student(1L, "Martin", "martin@gmail.com", LocalDate.of(2001, APRIL, 29), 20);

            studentRepository.save(martin);
        };
    }
}
