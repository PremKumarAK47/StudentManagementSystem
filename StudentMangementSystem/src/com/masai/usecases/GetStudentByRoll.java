package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class GetStudentByRoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter The Roll no Of Student You want to find");
		int roll= sc.nextInt();
		StudentDao sDao= new StudentDaoImpl();
		try {
			Student stu=sDao.getStudentByRoll(roll);
			System.out.println(stu);
		} catch (StudentException se) {
			// TODO Auto-generated catch block
			System.out.println(se.getMessage()+" "+roll);
		}
		//sc.close();
		// It will cause Error in main class for switch case
	}

}
