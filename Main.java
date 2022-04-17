

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("-----------------------------------------------\r\n"
				+ "------ Welcome to FedUni Results Manager ------\r\n"
				+ "-----------------------------------------------");
		Scanner sc = new Scanner (System.in);
		Menu menu = new Menu();	
		menu.switchMenu(sc);
	}		
}

