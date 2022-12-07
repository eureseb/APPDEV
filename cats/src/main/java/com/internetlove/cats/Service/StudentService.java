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

    public StudentEntity getStudentById(String studentId){
        int id = Integer.parseInt(studentId);
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

    public StudentEntity update(StudentEntity updatedStudent) {

        Optional<StudentEntity> given = studentRepository.findById(updatedStudent.getId());

        if(given.isPresent()){
            StudentEntity student = given.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setMiddleName(updatedStudent.getMiddleName());
            student.setLastName(updatedStudent.getLastName());
            student.setContactNumber(updatedStudent.getContactNumber());
            student.setEmail(updatedStudent.getEmail());
            student.setDateEnrolled(updatedStudent.getDateEnrolled());
            student.setCourses(updatedStudent.getCourses());
            return studentRepository.save(student);
        }
        return null;
    }

    public String deleteById(String id){

        StringBuilder sb = new StringBuilder();

        StudentEntity student = this.getStudentById(id);

        if(student != null){
            studentRepository.deleteById(student.getId());
            sb.append("Student deleted");
        }
        else {
            sb.append("Student not found or already deleted");
        }

        return sb.toString();
    }


}
