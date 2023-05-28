package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;

public class RegisterInsideAcourse {

	public static void main(String[] args) {

     StudentDao sdao= new StudentDaoImpl();
     
     Scanner sc= new Scanner(System.in);
     System.out.print("Enter Student's roll to Register inside a Course :");
     int roll= sc.nextInt();
     try {
		Student stu= sdao.getStudentByRoll(roll);
		if(stu!=null)
		{
			System.out.println("Enter the Course Id :");
			int cid=sc.nextInt();
			
			try {
				String mess= sdao.registerStudentInsideACourse(roll, cid);
				System.out.println(mess);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	} catch (StudentException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e.getMessage());
	} 
     
   sc.close();
	}
	

}
