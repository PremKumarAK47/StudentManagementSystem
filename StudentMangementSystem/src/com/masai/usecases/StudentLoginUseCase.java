package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class StudentLoginUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Student's Name-:");
		String name= sc.nextLine();
		System.out.println("Enter Student's Password");
		String pass=sc.nextLine().trim();
		
		
		StudentDao sDao= new StudentDaoImpl();
		try {
			Student stu= sDao.loginStudent(name, pass);
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
