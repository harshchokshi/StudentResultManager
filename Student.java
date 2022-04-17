package version0003;

import java.util.HashMap;

public class Student 
{
	String studentID, studentName;
	
	HashMap<String, String> studentList =  new HashMap<String, String>(); 

	public String getStudentID() 
	{
		return studentID;
	}

	public void setStudentID(String studentID) 
	{
		this.studentID = studentID;
	}

	public String getStudentName() 
	{
		return studentName;
	}

	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}  
	
	public void studentDetails(String studentID, String studentName) 
	{
		studentList.put(studentID, studentName);
	}
}
