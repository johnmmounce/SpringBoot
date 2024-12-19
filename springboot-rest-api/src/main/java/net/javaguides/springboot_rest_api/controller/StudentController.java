package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http:/localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "John",
                "Mounce"
        );
        return student;
    }

    // http:/localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "john", "mounce"));
        students.add(new Student(2, "j", "m"));
        students.add(new Student(3, "a", "a"));
        students.add(new Student(4, "sanjay", "puppet"));
        return students;
    }

    // Springboot REST API with Path Variable
    // {id} URI template Variable
    // http://localhost:8080/students/1
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable (@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // Springboot REST API with request param
}
