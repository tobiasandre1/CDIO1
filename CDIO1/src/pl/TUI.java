package pl;

import java.util.List;
import java.util.Scanner;

import dal.IUserDAO.DALException;
import fl.MiddleMan;
import dto.UserDTO;
import pl.PassGen;

public class TUI {
	
	MiddleMan connector = new MiddleMan();
	Scanner input = new Scanner(System.in); //Make new scanner for user inputs
	private int ID = 0;

	
	public static void main(String [] args) throws DALException{
		TUI textInterface = new TUI();
		textInterface.menu();
	}
	
	public TUI(){
	}
	
	public void menu() throws DALException{
		
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
			case "1": //looping = false;
					//input.close(); //Close the input
					createUser();  
					break;
			case "2": //looping = false;
					//input.close(); //Close the input
					showUsers();
					break;
			case "3": //looping = false;
					//input.close(); //Close the input
					updateUser();
					break;
			case "4": //looping = false;
					//input.close(); //Close the input
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
				
		UserDTO user = new UserDTO();
		PassGen Pass = new PassGen();
		
		System.out.println("Please provide a username: ");
		Boolean TooLongName = true;
		String Name = "";
		
		while (TooLongName == true){
			
			Name = input.nextLine();
			if (Name.length() <= 20){
				
				TooLongName = false;
				
			} else {
				
				System.out.println("Username too long, try again: ");
				
			}
			
		}
		
		System.out.println("Please provide initials: ");
		Boolean TooLongIni = true;
		String Ini = "";
		
		while (TooLongIni == true){
			
			Ini = input.nextLine();
			if (Ini.length() <= 3){
				
				TooLongIni = false;
				
			} else {
				
				System.out.println("Too many initials, try again: ");
				
			}
			
		}
		
		System.out.println("Please provide cpr: ");
		Boolean TooLongCpr = true;
		String Cpr = "";
		
		while (TooLongCpr == true){
			
			Cpr = input.next();
			if (Cpr.length() == 10){
				
				TooLongCpr = false;
				
			} else {
				
				System.out.println("Wrong input, try again: ");
				
			}
			
		}
		
		user.setUserId(ID);
		user.setUserName(Name);
		user.setPassword(Pass.Pass());
		user.setIni(Ini);
		user.setCpr(Cpr);
		
		connector.createUser(user);
		
		ID++;
		
	}
	
	public void showUsers() throws DALException{
		List<UserDTO> list = connector.getUserList();
		UserDTO temp;
		
		for(int i=0; i<list.size(); i++){
			temp = list.get(i);
			if(temp!=null){
				System.out.println(temp);
				
			}
		}
		System.out.println("\n");
	}
	
	public void updateUser(){
		
	}
	
	public void deleteUser() throws DALException{
		
		connector.deleteUser(input.nextInt());
		
	}
	
	public void endProgram(){
		
		System.exit(0);
	}

}
