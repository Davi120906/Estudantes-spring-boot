package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        
        return args -> {
            Student laura = new Student(
                "Laura",
                LocalDate.of(2007,Month.DECEMBER,21),
                "lauranormanda@gmail.com"
            );
            Student theo = new Student(
                "Theo",
                LocalDate.of(2007,Month.OCTOBER,18),
                "theoferreira@gmail.com"
            );
            studentRepository.saveAll(List.of(laura,theo));
        };
    }
}
 