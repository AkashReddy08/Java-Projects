package com.akash.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.akash.model.Student;

public class StudentDaoImpl implements StudentDao {
	// TODO Auto-generated method stub
			String dburl = "jdbc:mysql://localhost:3306/sys";
			String dbusername = "root";
			String dbpassword = "root1234";
			private static final String REGISTER_STUDENT = "INSERT student_details(name,password,email,mobileNo) into values(?,?,?,?)";

	@Override
	public int registerStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(dburl, dbusername, dbpassword);
			 ps= con.prepareStatement(REGISTER_STUDENT);
			 ps.setString(1, student.getName());
			 ps.setString(2, student.getPassword());
			 ps.setString(3, student.getEmail());
			 ps.setLong(4, student.getMobileNo());
			 int count=ps.executeUpdate();
			 if(count==0) {
				 return count;
			 }
			 else {
				 return count;
				 
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int loginStudent(String email, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
