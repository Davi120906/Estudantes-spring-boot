package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents(){
		return List.of(new Student(1L,"Laura",LocalDate.of(2007,Month.DECEMBER,11),17,"lauranormand@gmail.com"));
	}
}
