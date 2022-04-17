

import java.util.HashSet;


public class Result 
{
	Course courses;
	Student students;
	double marks;  
	
	HashSet<Result> result = new HashSet<Result>();
	
	
	public Result()
	{
		Course course = new Course();
		setCourses(course);
		Student student = new Student();
		setStudents(student);
	}
	public Result(String studentID, String studentName, String courseCode, String courseName, double marks) 
	{  
		this();
		getCourses().setCourseCode(courseCode);
		getCourses().setCourseName(courseName);
		getStudents().setStudentID(studentID);
		getStudents().setStudentName(studentName);
		this.marks = marks;
	}
	
	public Course getCourses() 
	{
		return courses;
	}

	public void setCourses(Course courses) 
	{
		this.courses = courses;
	}

	public Student getStudents() 
	{
		return students;
	}

	public void setStudents(Student students) 
	{
		this.students = students;
	}

	public double getMarks() 
	{
		return marks;
	}

	public void setMarks(double marks) 
	{
		this.marks = marks;
	}
	
	public void addResult(String studentID, String studentName, String courseCode, String courseName, double marks) 
	{
		Result r = new Result (studentID, studentName, courseCode, courseName, getMarks());
		result.add(r);
	}
	

	

}
