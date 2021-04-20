package com.akash.dao;

import com.akash.model.Student;

public interface StudentDao  {
	public int registerStudent(Student student) throws Exception;
	public int loginStudent(String email,String password);
	public int deleteStudent(int id);
	
	
	

}
