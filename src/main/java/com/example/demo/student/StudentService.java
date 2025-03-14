package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class StudentService {

	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
    public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	public void registerNewStudent(Student student){
		Optional<Student> studentByEmail = studentRepository.findStudendByEmail(student.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
        System.out.println(student);
    }
	public void deleteStudent(long id){
		boolean exists = studentRepository.existsById(id);
		if(!exists){
			throw new IllegalStateException(
				"student with id "+ id +" does not exist"
			);
		}
		studentRepository.deleteById(id);
	}
	@Transactional
	public void updateStudent(Student student, long id){
		Student student1 = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
		student1.setDob(student.getDob());
		student1.setEmail(student.getEmail());
		student1.setName(student.getName());

	}
	
}
