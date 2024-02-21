package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.MARCH;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student miguel = new Student(
                    "Miguel",
                    "miguel@higuera.dev",
                    LocalDate.of(
                            2000, FEBRUARY, 9
                    ),
                    25
            );

            Student russell = new Student(
                    "Russell",
                    "russell@gmail.com",
                    LocalDate.of(
                            2000, MARCH, 20
                    ),
                    25
            );

            studentRepository.saveAll(
                    List.of(miguel, russell)
            );
        };
    }
}
