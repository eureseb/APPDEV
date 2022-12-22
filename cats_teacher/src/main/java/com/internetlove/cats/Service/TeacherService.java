package com.internetlove.cats.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetlove.cats.Entity.TeacherEntity;
import com.internetlove.cats.Repository.TeacherRepository;


@Service
public class TeacherService {

	@Autowired
	TeacherRepository trepo;
	
	public TeacherEntity postTeacher(TeacherEntity teacher) {
		return trepo.save(teacher);
	}
	
	public List<TeacherEntity> getAllTeachers(){
		return trepo.findAll();
	}

	public Optional<TeacherEntity> findByTeacherId(int teacherid) {
		if (trepo.findById(teacherid)!=null)
			return trepo.findById(teacherid);
		else
			return null;
	}
	
	public TeacherEntity putTeacher(int teacherid, TeacherEntity newTeacherDetails) throws Exception{
		TeacherEntity teacher = new TeacherEntity();
		try {
			teacher = trepo.findById(teacherid).get();
			teacher.setFirstname(newTeacherDetails.getFirstname());
			teacher.setLastname(newTeacherDetails.getLastname());
			teacher.setContactNumber(newTeacherDetails.getContactNumber());
			teacher.setCourse(newTeacherDetails.getCourse());
			
			return trepo.save(teacher);
		}
		catch(NoSuchElementException nex) {
			throw new Exception("ID Number " + teacherid + "does not exist");
		}
	}
	
	public String deleteTeacher(int teacherid) {
		String msg;
		if(trepo.findById(teacherid).isEmpty()) {
			
			msg = "Teacher ID Number " + teacherid + " is NOT found!";
		}
		else {
			msg = "Teacher ID Number " + teacherid + " is successfully deleted";
		trepo.deleteById(teacherid);
		}
		return msg;
	}
	
}
