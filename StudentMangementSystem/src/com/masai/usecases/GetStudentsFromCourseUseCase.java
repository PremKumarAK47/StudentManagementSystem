package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.StudentDTO;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

public class GetStudentsFromCourseUseCase {
	
	public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter the Course Name :");
		
		String cname= sc.nextLine();

		
		StudentDao dao = new StudentDaoImpl();
		
		try {
		List<StudentDTO> dtos= dao.getAllStudentsByCname(cname);
		
		dtos.forEach(dto -> {
		System.out.println("Student Roll :"+dto.getRoll());
		System.out.println("Student Name :"+dto.getName());
		System.out.println("Student Email :"+dto.getEmail());
		System.out.println("Student Course :"+dto.getCname());
		System.out.println("Course Fee :"+dto.getFee());
			
		});		
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
