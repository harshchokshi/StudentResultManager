

import java.util.Scanner;


public class Menu 
{
	static int selectedChoice;
	
	public void menuOptions () 
	{
		System.out.println("Main Menu - please select an option:");
		System.out.println("1.) Add course");
		System.out.println("2.) Add student");
		System.out.println("3.) Add result");
		System.out.println("4.) View results");
		System.out.println("5.) Quit"+"\n");
	}
	
	public void switchMenu(Scanner sc) 
	{
		UserInterface ui = new UserInterface();
		boolean switchOperator = true;
		while(switchOperator) 
		{
		menuOptions();
		System.out.print("Enter your option: ");
		try {
			selectedChoice = sc.nextInt();
			System.out.println(" ");
			switch(selectedChoice) {
			case 1:
				ui.enterValuee("course code", "course name", "course");
				break;
			case 2:
				ui.enterValuee("student id", "student name", "student");
				break;
			case 3:
				ui.enterResult();
				break;
			case 4:
				ui.viewResult();
				break;
			case 5:
				switchOperator = systemExit();;
				break;
		    default:
			    System.out.println("\n"+"Enter only number between 1 to 5.");
			    break;
		}
		} catch (Exception e) {
			System.out.println("\n"+"Unexpected input other than number. Try again !!!");
			sc.nextLine();
		}
		
		 
		 
	}
	} 
	
	public boolean systemExit() 
	{
		System.out.println("Thanks for using FedUni Results Manager!");
		return false;
	}
	
	
}
	
	
