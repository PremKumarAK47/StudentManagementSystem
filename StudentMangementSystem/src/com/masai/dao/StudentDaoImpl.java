package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Student;
import com.masai.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String RegisterStudent(Student student) {
		String message ="Not Inserted";
		
		
		
		try(Connection conn =DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into Student(name,marks,email,password) values(?,?,?,?)");
		
		ps.setNString(1, student.getName());
		ps.setInt(2,student.getMarks());
		ps.setString(3, student.getEmail());
		ps.setString(4,student.getPassword());
		
		int x= ps.executeUpdate();
		if(x>0)
		{
			message="Student Registerd Sucessfully..!!";
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message =e.getMessage();
		}
		
		
		
		
		return message;
	}

}
