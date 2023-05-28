package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class UpdateMarks {

	public static void main(String[] args) {
	StudentDao sdao= new StudentDaoImpl();
     Scanner sc= new Scanner(System.in);
     System.out.println("Enter The Rollno. Of Student to update marks-:");
     int roll=sc.nextInt();
     try {
		Student stu1=sdao.getStudentByRoll(roll);
		if(stu1!=null)
		{
			System.out.println("Enter The Marks You want to update :");
			int marks=sc.nextInt();
			
			Student s=sdao.updateMarks(roll, marks);
			System.out.println(s);
		}
	} catch (StudentException e) {
		
		//e.printStackTrace();
		System.out.println(e.getMessage());
	}
     
     sc.close();
     
     
     
     
//     System.out.println("Enter the marks You want to Update");
//     int marks= sc.nextInt();
//     
//     
//     
//     try {
//		Student stu=sdao.updateMarks(roll,marks);
//		System.out.println("Student marks Updated SucessFully");
//		System.out.println(stu);
//		
//	} catch (StudentException e) {
//		// TODO Auto-generated catch block
//		System.out.println(e.getMessage()+" "+roll);
//	}
     
	}

}
