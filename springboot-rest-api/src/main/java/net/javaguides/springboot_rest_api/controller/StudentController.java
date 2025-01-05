package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http:/localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "John",
                "Mounce"
        );
        return ResponseEntity.ok().header("custom-header", "ramesh").body(student);
    }

    // http:/localhost:8080/students
    @GetMapping()
    public ResponseEntity <List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "john", "mounce"));
        students.add(new Student(2, "j", "m"));
        students.add(new Student(3, "a", "a"));
        students.add(new Student(4, "sanjay", "puppet"));
        return ResponseEntity.ok(students);
    }

    // Springboot REST API with Path Variable
    // {id} URI template Variable
    // http://localhost:8080/students/1
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable (@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        Student student =  new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Springboot REST API with request param
    // http://localhost:8080/students/query?id=1&firstName=john&lastName=mounce
    @GetMapping("/query")
    public ResponseEntity <Student> studentRequestVariable (@RequestParam int id,@RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // springboot REST API that handles HTTP  POST Request
    // @PostMapping and @RequestBody
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // spring boot REST PI that habdels HTTP PUT Request - updating existing resource
    @DeleteMapping("/{id}/delete")
    public ResponseEntity <String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Deleted student successfully");
    }

}


