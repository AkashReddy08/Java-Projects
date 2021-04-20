package com.akash.service;

import com.akash.dao.StudentDao;
import com.akash.dao.StudentDaoImpl;
import com.akash.model.Student;

public class StudentService {
	public int insertStudent(Student student) throws Exception {
		
		StudentDao studentService= new StudentDaoImpl();
		
		 int count = studentService.registerStudent(student);
		 return count;
		
	}
	

}
