package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping
	public List<Student> getStudents(){
		return studentService.getStudents();
	}

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.registerNewStudent(student);
    }
    @DeleteMapping(path= "{studentId}")
	public void deleteStudent(@PathVariable("studentId") long id	){
        studentService.deleteStudent(id);
 	}
    @PutMapping(path= "{studentId}")
    public void updateStudent(@PathVariable("studentId") long id ,@RequestBody Student student){
        studentService.updateStudent(student, id);
    }
}
