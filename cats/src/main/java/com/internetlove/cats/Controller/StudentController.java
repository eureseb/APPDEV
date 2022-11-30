package com.internetlove.cats.Controller;

import com.internetlove.cats.Entity.StudentEntity;
import com.internetlove.cats.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentEntity> all(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public StudentEntity one(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentEntity saveStudent(@Validated @RequestBody StudentEntity studentEntity) {
        return studentService.insertStudent(studentEntity);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return studentService.deleteById(id);
    }

    @PutMapping()
    public StudentEntity update(@Validated @RequestBody StudentEntity studentEntity){
        return studentService.update(studentEntity);
    }
}
