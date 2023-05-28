package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class DeleteStudentByRoll {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Roll no. of Student You want to delete :");
		int roll=sc.nextInt();
		
		StudentDao sDao= new StudentDaoImpl();
		
		try {
			Student stu= sDao.deleteStudentByRoll(roll);
			//System.out.println("Student Deleted SucessFully !!");
			System.out.println(stu);
		} catch (StudentException e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
