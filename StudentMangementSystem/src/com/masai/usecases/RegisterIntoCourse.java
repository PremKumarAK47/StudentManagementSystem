package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Course;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;

public class RegisterIntoCourse {

	public static void main(String[] args) {

    Scanner sc= new Scanner(System.in);
    System.out.print("Enter Course Name :");
    String cName=sc.nextLine();
    
    System.out.print("Enter Course Fee :");
    int fee= sc.nextInt();
    
    Course crs= new Course();
    crs.setcName(cName);
    crs.setFee(fee);
    
    StudentDao sDao= new StudentDaoImpl();
    try {
		Course cours= sDao.addCourse(crs);
		System.out.println("Here is Course Details :");
		System.out.println("Course Id :"+ cours.getCid());
		System.out.println("Course Name :"+cours.getcName());
		System.out.println("Course Fee :"+cours.getFee());
	} catch (CourseException e) {
		System.out.println(e.getMessage());
	}
    // sc.close();
	}
 
}
