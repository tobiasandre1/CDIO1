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
			
			Name = input.next();
			if (Name.length() >= 2 && Name.length() <= 20){
				
				TooLongName = false;
				
			} else {
				
				System.out.println("Only 2-20 signs, try again: ");
				
			}
			
		}
		
		System.out.println("Please provide initials: ");
		Boolean TooLongIni = true;
		String Ini = "";
		
		while (TooLongIni == true){
			
			Ini = input.next();
			if (Ini.length() >= 2 && Ini.length() <= 4){
				
				TooLongIni = false;
				
			} else {
				
				System.out.println("Only 2-4 intitals, try again: ");
				
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
		
		System.out.println("Please provide desired ID: ");
		Boolean CheckID = true;
		while(CheckID == true){
		
			Boolean TooLongID = true;
			int ID = -1;
			
			while (TooLongID == true){
				
				ID = input.nextInt();
				if (ID >= 11 && ID <= 99){
					
					TooLongID = false;
					
				} else {
					
					System.out.println("Only a number range 11-99, try again: ");
					
				}
				
			}
			
			user.setUserId(ID);
			user.setUserName(Name);
			user.setPassword(Pass.Pass());
			user.setIni(Ini);
			user.setCpr(Cpr);
			
			CheckID = connector.createUser(user);
			
			if (CheckID == true){
				
				System.out.println("ID already taken, try again");
				
			}
			
		}

			
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
	
public void updateUser() throws DALException{
		
		Scanner updateInput = new Scanner(System.in);
		System.out.println("Type in the userID you want to update");
		int choiceID = updateInput.nextInt();
		
		boolean nextUpdate = true;
		
		while(nextUpdate){
			//system message
			System.out.println("You are updating data for userID: " + choiceID);
			System.out.println("Select an option by typing the corresponding number and pressing \"enter\"");
			System.out.println("1. Update username");
			System.out.println("2. Update password");
			System.out.println("3. Update initials");
			System.out.println("4. Update CPR");
			System.out.println("5. Add role");
			System.out.println("6. Remove role");
			System.out.println("7. Main menu");
			
			String choice = updateInput.next(); //Assign this value as a choice
			
			switch(choice){
			case "1": System.out.println("Type in new username. Username must be between 2 and 20 characters");
			  		choice = updateInput.next();
					connector.updateUserName(choiceID, choice);
					break;
			case "2": System.out.println("Type in new password");
					choice = updateInput.next();
					connector.updatePassword(choiceID, choice);
					break;
			case "3": System.out.println("Type in new initials. Must be between 2 and 4 characters");
					choice = updateInput.next();
					connector.updateINI(choiceID, choice);
					break;
			case "4": System.out.println("Type in new CPR. Must be 10 characters long");
					choice = updateInput.next();
					connector.updateCPR(choiceID, choice);
					break;
			case "5": System.out.println("Type in the role you want to add");
					System.out.println("The roles are: Admin, Pharmacist, Foreman, Operator");
					choice = updateInput.next();
					connector.addRole(choiceID, choice);
					break;
			case "6": System.out.println("Type in the role you want to remove");
					System.out.println("The roles are: Admin, Pharmacist, Foreman, Operator");
					choice = updateInput.next();
					connector.removeRole(choiceID, choice);
					break;
			case "7": nextUpdate = false;
					break;
			default: System.out.println("You entered " + choice + " which is not a valid choice.\n");
					break;
				
			}
			
		}
}
	
	public void deleteUser() throws DALException{
		
		connector.deleteUser(input.nextInt());
		
	}
	
	public void endProgram(){
		
		System.exit(0);
	}

}
