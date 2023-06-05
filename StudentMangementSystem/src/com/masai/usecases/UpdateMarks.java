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
		
		
		System.out.println(e.getMessage());
	}
    
     
	}

}
