package com.masai.usecases;

import java.util.List;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;

public class GetAllStudentDetalis {

	public static void main(String[] args) {

    StudentDao sDao= new StudentDaoImpl();
    try {
		List<Student>stuList= sDao.getAllStudentDetails();
		stuList.forEach(s->System.out.println(s));
	} catch (StudentException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e.getMessage());
	}

	}

}
