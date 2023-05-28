package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.utility.DBUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String RegisterStudent(Student student) {
		String message ="Not Inserted";
		
		
		
		try(Connection conn =DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into Student(name,marks,email,password) values(?,?,?,?)");
		
		ps.setString(1, student.getName());
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
		
	
	try(Connection conn	=DBUtil.provideConnection();) {
		PreparedStatement ps= conn.prepareStatement("select * from student where name=? && password=?");
	 ps.setString(1, username);
	 ps.setString(2, password);
	 
	 ResultSet rs =ps.executeQuery();
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
		 throw new StudentException("Invalid UserName and Password !!");
	 }
	
	
	} catch (SQLException e) {
		
		throw new StudentException(e.getMessage());
		
	}
		System.out.println("Welcome "+stu.getName()+", You have been Logged in SucessFully !!");
		return stu;
	}

	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student>stuList= new ArrayList<Student>();
		
	
	 try(Connection conn=DBUtil.provideConnection();) {
		PreparedStatement ps= conn.prepareStatement("Select * from student");
	      ResultSet rs=ps.executeQuery();
	      while(rs.next())
	      {
	    	  int r=rs.getInt("roll");
	    	  String n=rs.getString("name");
	    	  int m=rs.getInt("marks");
	    	  String e=rs.getString("email");
	    	  String p=rs.getString("password");
	    	  
	    	  Student stu= new Student(r, n, m, e, p);
	    	  stuList.add(stu);
	    	  
	      }
	 
	 } catch (SQLException e) {
		 throw new StudentException(e.getMessage());
		
	}
	 if(stuList.size()==0)
	 {
		 throw new StudentException("No Students found...,Please Register Some Student !");
	 }
		
		
		return stuList;
		
	}

	@Override
	public Course addCourse(Course course) throws CourseException {
		//Course cours=null;
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			//PreparedStatement ps= conn.prepareStatement("insert into course(cname,fee) values(?,?)");
			PreparedStatement ps= conn.prepareStatement("insert into course(cname,fee) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, course.getcName());
			ps.setInt(2, course.getFee());
			
			ps.executeUpdate();
			
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                int courseId = generatedKeys.getInt(1);
	                course.setCid(courseId);
	            }
	        }
			
			}
		
		
		catch (Exception e) {
			//throw new CourseException("Please Define The Course Table");
			e.printStackTrace();
		}
		System.out.println("Course Details Added SucessFully..!!");
		return course;
	}

	@Override
	public String registerStudentInsideACourse(int roll, int cid) throws StudentException, CourseException {
		String message="Student Not Registered into a course";
		/*
		 * Here we can use the getStudentByRoll(int roll); then we had to written only one query
		 * otherwise we have to written 3 query like this.
		 * means we can optimize this.
		 */
		
		try(Connection conn =DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("Select * from student where roll=?");
		    
			ps.setInt(1,roll);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement ps2=conn.prepareStatement("select * from course where cid=?");
				ps2.setInt(1, cid);
				
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
				{
					PreparedStatement ps3=conn.prepareStatement("insert into course_student values(?,?)");
					ps3.setInt(1, roll);
					ps3.setInt(2, cid);
					
					int x=ps3.executeUpdate();
					if(x>0)
					{
						message="Student Registered into a course SucessFully !";
					}
					else {
						throw new StudentException("Technical Error !");
					}
				}
				else {
					throw new CourseException("Invalid Course");
				}
			}
			else {
				throw new StudentException("Student not Registerd with this roll !");
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		
		return message;
	}
	
	

}
