package com.masai.mainApp;

import java.util.Scanner;

import com.masai.usecases.DeleteStudentByRoll;
import com.masai.usecases.GetAllStudentDetalis;
import com.masai.usecases.GetStudentByRoll;
import com.masai.usecases.GetStudentsFromCourseUseCase;
import com.masai.usecases.RegisterInsideAcourse;
import com.masai.usecases.RegisterIntoCourse;
import com.masai.usecases.RegisterStudent;
import com.masai.usecases.StudentLoginUseCase;
import com.masai.usecases.UpdateMarks;

public class Main {

	
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{
		   
			System.out.println("Welcome To Student Management System -:");
			System.out.println("1.Register The Student :");
			System.out.println("2.Login Student :");
			System.out.println("3.Get Student By Roll Number :");
			System.out.println("4.Update Marks Of a Student :");
			System.out.println("5.Delete The Student Details :");
			System.out.println("6.Get All Student Details :");
			System.out.println("7.Register A Course :");
			System.out.println("8.Register a Student into a course");
			System.out.println("9.Get Student's course Details :");
			System.out.println("10.Exit");
			System.out.println();
			System.out.print("Please Enter your Choice :");
			
			
		     int choice = sc.nextInt();
		    
		    switch (choice) 
		    {
		    
			case 1 :
				 
				RegisterStudent.main(args);
				
				
				break;
			case 2:
				
				StudentLoginUseCase.main(args);
				System.out.println();
				break;
			case 3 :
				
				GetStudentByRoll.main(args);
				break;
			case 4:
				
				UpdateMarks.main(args);
				break;
			case 5:
				
				DeleteStudentByRoll.main(args);
				break;
			case 6:
				
				GetAllStudentDetalis.main(args);
				break;
			case 7 :
				
				RegisterIntoCourse.main(args);
				break;
			case 8:
				
				RegisterInsideAcourse.main(args);
				break;
			case 9:
				
				GetStudentsFromCourseUseCase.main(args);
				break;
			case 10:
				System.out.println("Exiting Student Management System...!!");
				System.exit(0);
				break;

			default:
				System.out.println("Please Choose A Valid choice..!!");
				
				break;
			}
			
		    }
			
		}
	
	}
	
	
	
//}
