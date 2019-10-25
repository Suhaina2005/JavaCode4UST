package com.netapp.ngdc.devexp.azuredevopsapiaccess.model;

import java.util.Scanner;

public class RemainderApplication {

	private static RemainderService rs=new RemainderService();
	private static  int maxId=rs.getMaxID();

	public static void main(String args[]) {
		int choice=1;
		while(choice!=4) {
			System.out.println("1. Add new Remainder");
			System.out.println("2. Update Remainder");
			System.out.println("3. View Remainder");
			System.out.println("4. Exit");
			System.out.println("Enter the choice... :");
			Scanner scanner = new Scanner(System. in); 
			choice = scanner.nextInt();
			switch(choice) {
			case 1: {
				System.out.println("Enter the name/desc of the Remainder: ");
				String name=scanner.nextLine();
				System.out.println("Date to remaind:");
				String rDate=scanner.nextLine();
				System.out.println("Time to remaind:");
				String rTime=scanner.nextLine();
				Remainder r=new Remainder(++maxId,name,rDate,rTime,"New");
				if (rs.addRemainder(r).equals("Success"))
					System.out.println("Remainder created with Id :" + maxId);
				else
					System.out.println("Error in creating Remainder");
			}
			case 2: {
				System.out.println("Enter the Id of the remainder to modify: ");
				int id=scanner.nextInt();
				System.out.println("Enter the name/desc of the Remainder: ");
				String name=scanner.nextLine();
				System.out.println("Date to remaind:");
				String rDate=scanner.nextLine();
				System.out.println("Time to remaind:");
				String rTime=scanner.nextLine();
				Remainder r=new Remainder(++maxId,name,rDate,rTime,"New");
				if (rs.updateRemainder(r).equals("Success"))
					System.out.println("Remainder updated with Id :" + id);
				else
					System.out.println("Error in updating Remainder");
			}
			case 3: {
				System.out.println("Enter the Id of the remainder to view: ");
				int id=scanner.nextInt();
				Remainder r=rs.getRemainderById(id);
				if (r!=null)
					rs.viewRemainder(r);
				else
					System.out.println("Remainder not available");
			}
			case 4: {
				System.out.println("BFN - C U again");
			}
			default :{
				System.out.println("Invalid choice - try again");
			}
			}
			
		}
		
	}
}
