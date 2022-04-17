

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface 
{
	Result rs;
	Scanner sc = new Scanner (System.in);
	BufferedReader bufferReader = new BufferedReader (new InputStreamReader(System.in));
	
	public UserInterface() 
	{
		rs = new Result();
	}

	public void enterValuee(String message1, String message2, String message3) 
	{
		String[] data;
		boolean enterAgain;
		do {
		enterAgain = false;	
		char choice4 = ' ';
		data = new String[2];
		System.out.print("Please enter "+message1+": ");
		 data[0] = sc.next(); 
		System.out.print("Please enter "+message2+": ");
		 try {
			data[1] = bufferReader.readLine();
		} catch (IOException e1) 
		 {
			e1.printStackTrace();
		} 
		 
        if (message1.contains("course code")) 
        {
        	addCourses(data[0], data[1]);
        }
        if (message1.contains("student id")) 
        {
        	addStudents(data[0], data[1]);
        }
		
		do {
			System.out.println("\n"+"Would you like to [A]dd a new "+message3+" or [R]eturn to the previous menu?");
			try {
				choice4 = sc.next(".").charAt(0);
				System.out.println();
				boolean otherChar = (choice4 == 'A' || choice4 == 'a' || choice4 == 'Z' || choice4 == 'R'
						|| choice4 == 'r');
				if (otherChar == false) {
					System.out.println("Invalid input. Please choice either between A or R!!! " + "\n");
					choice4 = 'Z';
				}

				if (choice4 == 'A' || choice4 == 'a') 
				{
					enterAgain = true;
				}

			} catch (Exception e) {
				System.out.println("Invalid input. Please choice either between A or R!!! " + "\n");
			    sc.nextLine();
				choice4 = 'Z';
			} 
		} while (choice4 == 'Z');
		
		} while (enterAgain == true);
	}
	
	public void addCourses(String courseCode, String courseName) 
	{
		rs.getCourses().courseDetails(courseCode, courseName);
	}
	
	public void addStudents(String studentID, String studentName) 
	{
		rs.getStudents().studentDetails(studentID, studentName);
	}
	
	public String enterValue(String message)  
	{
		String input;
		System.out.print("Please enter "+message+": ");
		input = sc.next();
		return input;
	}
	
	public Double inputMarks() 
	{
		double marks;
		System.out.print("Please enter final score: ");
		marks = sc.nextDouble();
		return marks;
	}
	
	
	public String [] studentExists(String checkKey) 
	{	
		String[] studentsDetails = new String[2];
		if (rs.getStudents().studentList.containsKey(checkKey)==true) 
		{
			studentsDetails[0] = checkKey;
			studentsDetails[1]= rs.getStudents().studentList.get(studentsDetails[0]);
		}
	
		else 
		{
			System.out.println("Student does not exist."+"\n");	
		}
		
		return studentsDetails;
	}
	
	public String [] courseExists(String checkKey) 
	{	
		String[] courseDetails = new String[2];
		if (rs.getCourses().courseList.containsKey(checkKey)==true) 
		{
			courseDetails[0] = checkKey;
			courseDetails[1]= rs.getCourses().courseList.get(courseDetails[0]);
		}
	
		else 
		{
			System.out.println("Course does not exist."+"\n");	
		}
		
		return courseDetails;
	}
	
	public void enterResult()
	{
		String[] students;
		String[] courses;
		double marks=0.0;
		boolean enterAgain;
		do {
		enterAgain = false;
		students = new String[2];
		String input;
		System.out.print("Please enter student id: ");
		input = sc.next();
		students = studentExists(input);
			if (students[0]==null || students[1]==null) 
			{
				enterAgain = true;
			}
		}while(enterAgain == true);
		
		do {
		enterAgain = false;
		courses = new String[2];
		String input;
		System.out.print("Please enter course code: ");
		input = sc.next();
		courses = courseExists(input);
		if (courses[0]==null || courses[1]==null) 
		{
			enterAgain = true;
		}
		}while(enterAgain == true);
		
		do {
		enterAgain = false;
		System.out.print("Please enter final score: ");
		try {
			marks = sc.nextDouble();
			if (marks>100.00 || marks<0.0) 
			{
				System.out.println("Score is not between 0.0 and 100.0 inclusive."+"\n");
				enterAgain = true;
			}
		} catch (Exception e) {
			System.out.println("Score is not between 0.0 and 100.0 inclusive."+"\n");
			sc.nextLine();
			enterAgain = true;
		}
		}while(enterAgain == true);
		
		rs.setMarks(marks);
		rs.addResult(students[0], students[1], courses[0], courses[1], rs.getMarks());
		wouldYoulike();
	}
	
	public void wouldYoulike() 
	{
		boolean enterAgain;
		do {
			char choice4 = ' ';
			enterAgain = false;
			
			
			do {
				System.out.println("\n"+"Would you like to [A]dd a new result or [R]eturn to the previous menu?");
				try {
					choice4 = sc.next(".").charAt(0);
					System.out.println();
					boolean otherChar = (choice4 == 'A' || choice4 == 'a' || choice4 == 'Z' || choice4 == 'R'
							|| choice4 == 'r');
					if (otherChar == false) {
						System.out.println("Invalid input. Please choice either between A or R!!! " + "\n");
						choice4 = 'Z';
					}

					if (choice4 == 'A' || choice4 == 'a') 
					{
						enterResult();
					}
					
					if (choice4 == 'R' || choice4 == 'r') 
					{
						enterAgain = false;
					}

				} catch (Exception e) {
					System.out.println("Invalid input. Please choice either between A or R!!! " + "\n");
				    sc.nextLine();
					choice4 = 'Z';
				} 
			} while (choice4 == 'Z');
		} while (enterAgain == true);
		
	}
	
	public void viewCourse() 
	{
		boolean enterAgain;
		String[] coursesExists;
		do {
		enterAgain = false;
		coursesExists = new String[2];
		String input;
		System.out.print("Please enter course code: ");
		input = sc.next();
		coursesExists = courseExists(input);
		if (coursesExists[0]==null || coursesExists[1]==null) 
		{
			enterAgain = true;
		}
		}while(enterAgain == true);
		
		String courseResult = coursesExists[0];
		System.out.println("");
		
		for (Result r: rs.result) 
		{
			if (r.getCourses().getCourseCode().contains(courseResult)==true) 
			{	
				System.out.println("Results for course: "+r.courses.getCourseCode());
				break;
			}
	
		}
		
		HashSet<Double> minmax = new HashSet<Double>();
		
		for (Result r: rs.result) 
		{
			if (r.getCourses().getCourseCode().contains(courseResult)==true) 
			{	
				minmax.add(r.getMarks());
				System.out.println(r.getStudents().getStudentID() + " - " + r.getStudents().getStudentName() + " - " + r.getMarks());
			}
			
		}
		
		System.out.println("Maximum score: "+Collections.max(minmax));
		System.out.println("Minimum score: "+Collections.min(minmax));
		System.out.println("\n");
		
		
	}
	
	public void viewStudent() 
	{
		boolean enterAgain;
		String[] studentExists;
		
		do {
			enterAgain = false;
			studentExists = new String[2];
			String input;
			System.out.print("Please enter student id: ");
			input = sc.next();
			studentExists = studentExists(input);
			if (studentExists[0]==null || studentExists[1]==null) 
			{
				enterAgain = true;
			}
			
			}while(enterAgain == true);
		
		
		String studentResult = studentExists[0];
		
		System.out.println("");
		
		for (Result r: rs.result) 
		{
			if (r.getStudents().getStudentID().contains(studentResult)==true) 
			{	
				System.out.println("Results for student: "+r.getStudents().getStudentID()+" - "+r.getStudents().getStudentName());
				break;
			}
		}
		
		double averageMark = 0.0;
		
		for (Result r: rs.result) 
		{
			if (r.getStudents().getStudentID().contains(studentResult)==true) 
			{	
				averageMark = averageMark + r.getMarks();
				System.out.println(r.getCourses().getCourseCode()+" - "+r.getMarks());
			}
		}
		
		System.out.println("Average result: "+averageMark/2);
		System.out.println("\n");
	}
	
	public void viewResult()
	{
		boolean enterAgain;
		do {
			char choice4 = ' ';
			enterAgain = false;
			do {
				System.out.println("Would you like to view [C]ourse results, [S]tudent results or [R]eturn?");
				try {
					choice4 = sc.next(".").charAt(0);
					boolean otherChar = (choice4 == 'C' || choice4 == 'S' || choice4 == 'Z' || choice4 == 'R'
							|| choice4 == 'r' || choice4 == 'c' || choice4 == 's');
					if (otherChar == false) {
						System.out.println("Invalid input. Please choice either between C , S or R!!! " + "\n");
						choice4 = 'Z';
					}

					if (choice4 == 'C' || choice4 == 'c') 
					{
						viewCourse();
						enterAgain = true;
					}
					
					if (choice4 == 'S' || choice4 == 's') 
					{
						viewStudent();
						enterAgain = true;
					}

				} catch (Exception e) {
					System.out.println("Invalid input. Please choice either between between C , S or R!!! " + "\n");
				    sc.nextLine();
					choice4 = 'Z';
				} 
			} while (choice4 == 'Z');
		} while (enterAgain == true);
	}
	
}


