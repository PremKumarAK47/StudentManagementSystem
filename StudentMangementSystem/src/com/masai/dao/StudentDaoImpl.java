package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Student;
import com.masai.exception.StudentException;
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

	@Override
	public Student getStudentByRoll(int roll) throws StudentException {
		
		Student stu=null;
		
		
		try(Connection conn=DBUtil.provideConnection();) {
			PreparedStatement ps=conn.prepareStatement("select * from Student where roll=?");
		
		ps.setInt(1, roll);
		
		ResultSet rs= ps.executeQuery();
		if(rs.next())
		{
			int r=rs.getInt("roll");
			String n=rs.getNString("name");
			int m= rs.getInt("marks");
			String e=rs.getString("email");
			String p=rs.getString("password");
			
			 stu= new Student(r, n, m, e, p);
			
		}
		else {
			throw new StudentException("Student Not Registered with this roll no. "+roll);
			
		}
		
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new StudentException(e.getMessage());
		}
		
		
		return stu;
	}

	@Override
	public Student updateMarks(int roll,int marks) throws StudentException {
		Student stu=new Student();
		try(Connection conn=DBUtil.provideConnection();) 
		{
			PreparedStatement ps=conn.prepareStatement("UPDATE student SET marks = marks + ? WHERE roll = ?");
		
		ps.setInt(1, marks);
		ps.setInt(2, roll);
		
		int x= ps.executeUpdate();
		if(x>0)
		{
			PreparedStatement ps1= conn.prepareStatement("Select * from student where roll=?");
			ps1.setInt(1, roll);
			ResultSet rs= ps1.executeQuery();
			
			if(rs.next())
			{
				
				int r=rs.getInt("roll");
				String n=rs.getNString("name");
				int m= rs.getInt("marks");
				String e=rs.getString("email");
				String p=rs.getString("password");
				
				 stu= new Student(r, n, m, e, p);
				
			}
			
		}
		
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new StudentException(e.getMessage());
		}
		System.out.println("Student's Marks Updated Sucessfully !!");
		return stu;
	}

	@Override
	public Student deleteStudentByRoll(int roll) throws StudentException {
		
		Student stu=getStudentByRoll(roll);
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("Delete from Student where roll=?");
		
		ps.setInt(1,roll);
		
		int x=ps.executeUpdate();		
		if(x>0)
		{
			System.out.println("Student Deleted Sucessfully !!");
		}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			//throw new StudentException("Student not Found with this Roll no. "+ roll);
			//No need to handle here already handled in getStudentByRoll.
		}
	
		return stu;
	}

	@Override
	public Student loginStudent(String username, String password) throws StudentException {
		Student stu=null;
		
		
		
		return stu;
	}

}
