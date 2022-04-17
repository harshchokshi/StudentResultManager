package version0003;

import java.util.HashMap;

public class Course
{  
	String courseCode, courseName;
	
	HashMap<String, String> courseList =  new HashMap<String, String>();  

	public String getCourseCode() 
	{
		return courseCode;
	}

	public void setCourseCode(String courseCode) 
	{
		this.courseCode = courseCode;
	}

	public String getCourseName() 
	{
		return courseName;
	}

	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	} 
	
	public void courseDetails(String courseCode, String courseName) 
	{
		courseList.put(courseCode, courseName);
	}

}