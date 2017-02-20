package pl;

import java.util.Scanner;

import dal.IUserDAO.DALException;
import fl.MiddleMan;
import dto.UserDTO;

public class TUI {
	MiddleMan connector = new MiddleMan();
	
	public static void main(String [] args) throws DALException{
		TUI textInterface = new TUI();
		textInterface.menu();
	}
	
	public TUI(){
	}
	
	public void menu() throws DALException{
		Scanner input = new Scanner(System.in); //Make new scanner for user inputs
		
		String choice = "";
		boolean looping = true;
		
		while(looping){
			
			//System message before user input
			System.out.println("Select an option by typing the corresponding number and pressing \"enter\"");
			System.out.println("1. Create a new user");
			System.out.println("2. Show all existing users");
			System.out.println("3. Update an existing user");
			System.out.println("4. Delete an existing user");
			System.out.println("5. Close the program");
			
				choice = input.next(); //Assign this value as a choice
			/*
			 * Determine which method to run. 
			 * If the choice does not correspond to a case, 
			 * the user is given the option to type a new number
			 */
			switch(choice){
			case "1": looping = false;
					input.close(); //Close the input
					createUser();  
					break;
			case "2": looping = false;
					input.close(); //Close the input
					showUsers();
					break;
			case "3": looping = false;
					input.close(); //Close the input
					updateUser();
					break;
			case "4": looping = false;
					input.close(); //Close the input
					deleteUser();
					break;
			case "5": looping = false;
					input.close(); //Close the input
					endProgram();
					break;
			default: looping = true;
					System.out.println("You entered " + choice + " which is not a valid choice.\n");
					break;
			}
		}
	}
	
	public void createUser() throws DALException{
		
		int ID = 0;
		
		UserDTO user = new UserDTO();
		
		user.setUserId(ID);
		user.setUserName("Filler");
		user.setPassword("Filler");
		user.setIni("F");
		user.setCpr(123);
		
		connector.createUser(user);
		
		ID++;
		
	}
	
	public void showUsers(){
		
	}
	
	public void updateUser(){
		
	}
	
	public void deleteUser() throws DALException{
		
		connector.deleteUser(0);
		
	}
	
	public void endProgram(){
		
		System.exit(0);
	}

}
