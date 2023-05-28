package com.masai.dao;

import java.util.List;

import com.masai.bean.Course;
import com.masai.bean.Student;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;

public interface StudentDao {
	public String RegisterStudent(Student student)throws StudentException;
    public Student getStudentByRoll(int roll)throws StudentException;
    public Student updateMarks(int roll,int marks) throws StudentException;
    public Student deleteStudentByRoll(int roll)throws StudentException;
    public Student loginStudent(String username, String password) throws StudentException;
    public List<Student> getAllStudentDetails()throws StudentException;
    public Course addCourse(Course course)throws CourseException;
}
