package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class UpdateMarks {

	public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
     System.out.println("Enter The Rollno. Of Student to update marks-:");
     int roll=sc.nextInt();
     System.out.println("Enter the marks You want to Update");
     int marks= sc.nextInt();
     
     StudentDao sdao= new StudentDaoImpl();
     
     try {
		Student stu=sdao.updateMarks(roll,marks);
		System.out.println("Student marks Updated SucessFully");
		System.out.println(stu);
		
	} catch (StudentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
