package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class RegisterStudent {
	
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Student Name-:");
		String sname= sc.nextLine();
		System.out.println("Enter Student Marks-:");
		int marks= sc.nextInt();
		System.out.println("Enter Student Email-:");
		String email=sc.next();
		System.out.println("Enter Student Password-:");
		String pass=sc.next();
		
		StudentDao stuDao= new StudentDaoImpl();
		
		Student stu= new Student();
		stu.setName(sname);
		stu.setMarks(marks);
		stu.setEmail(email);
		stu.setPassword(pass);
		
		
		String result;
		try {
			result = stuDao.registerStudent(stu);
			System.out.println(result);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
