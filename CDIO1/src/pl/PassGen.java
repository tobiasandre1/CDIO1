package pl;

import java.util.Random;

public class PassGen {

	public String Pass() {
	// TODO Auto-generated method stub
				
		//Random for deciding Uppercase, Lowercase, next is number? etc.
		//Char array where all letters and numbers will be stored before final result
		Random gen = new Random();
		char[] pass  = new char[10];
				
		//Strings where numbers and letters gets "taken" from
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final String numbers = "1234567890";

		//UpperCaseCounter, LowerCaseCounter and NumberCounter. 
		//To ensure 3 upper/lower -case letters and 4 numbers
		int ucc = 0, lcc = 0, nc = 0;
		Boolean ghostLetter = true;
		
		//Final result
		String passwordFull = "";
			
			for (int i = 0; i < 10; i++){
				
				//Loop for failsafe
				ghostLetter = true;
				while (ghostLetter == true){
					
					//Decides if next char is going to be a number or letter (NextType), and if its a letter 
					//- if its going to be upper/lower -case
					Boolean nextUpper = gen.nextBoolean();
					Boolean nextType = gen.nextBoolean();
					
					//NextType = True = Letter
					if (nextType == true){
						
						//NextUpper = True = Uppercase
						if ((nextUpper == true && ucc < 3) || (nextUpper == false && lcc == 3 && ucc < 3)){
							
							//Choses a random char in alphabet and puts it into array
							//Makes sure the char is gonna be uppercase
							alphabet = alphabet.toUpperCase();
							pass[i] = alphabet.charAt(gen.nextInt(alphabet.length()));
							ucc++;
							
						} 
						else if (lcc < 3) {
							
							//Same as uppercase but ensures lowercase
							alphabet = alphabet.toLowerCase();
							pass[i] = alphabet.charAt(gen.nextInt(alphabet.length()));
							lcc++;
							
						}
						
					}
					else if (nc < 4) {
						
						//If the next char isnt gonna be a letter its gonna be a number
						pass[i] = numbers.charAt(gen.nextInt(numbers.length()));
						nc++;
						
					}
					
					//If spot in array is still empty it tries again
					ghostLetter = false;
					
					if (pass[i] == 0){
						
						ghostLetter = true;
						
					}
					
				}
		
					
			}
								
			//Puts the password together as a string
			for (int j = 0; j < 10; j++){
				
				passwordFull = passwordFull + pass[j];
				
			}
				
		return passwordFull;
		
	}

}
