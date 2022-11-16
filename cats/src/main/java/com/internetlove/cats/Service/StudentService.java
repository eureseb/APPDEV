package com.internetlove.cats.Service;

import com.internetlove.cats.Entity.StudentEntity;
import com.internetlove.cats.Entity.UniversityEntity;
import com.internetlove.cats.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentEntity> getAllStudents(){ return studentRepository.findAll(); }

    public StudentEntity getStudentById(int id){
        Optional<StudentEntity> result = studentRepository.findById(id);
        StudentEntity student;
        if(result.isPresent()){
            student = result.get();
        }
        else {
            throw new RuntimeException();
        }
        return student;
    }

    public StudentEntity insertStudent(StudentEntity student){
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(int id, StudentEntity updatedStudent) throws Exception {
        StudentEntity student = new StudentEntity();
        try {
            student = studentRepository.findById(id).get();

            student.setName(updatedStudent.getName());
            student.setContactNumber(updatedStudent.getContactNumber());
            student.setEmail(updatedStudent.getEmail());
            student.setDateEnrolled(updatedStudent.getDateEnrolled());
            student.setCourses(updatedStudent.getCourses());

            return studentRepository.save(student);
        }catch(NoSuchElementException ex) {
            throw new Exception("ID Number " + id + " does not exist!");
        }
    }

    public String deleteById(int id) {
        String msg;
        if(studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            msg = "University ID Number " + id + " is successfully deleted!";
        }
        else
            msg = "University ID Number " + id + " is not found!";
        return msg;
    }
}
