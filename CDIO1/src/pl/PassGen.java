package pl;

import java.util.Random;

public class PassGen {

	public String Pass() {
	// TODO Auto-generated method stub
				
		//Random for deciding Uppercase, Lowercase, next is number? etc.
		//Char array where all letters and numbers will be stored before final result
		Random gen = new Random();
		char[] Pass  = new char[10];
				
		//Strings where numbers and letters gets "taken" from
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		final String Numbers = "1234567890";

		//UpperCaseCounter, LowerCaseCounter and NumberCounter. 
		//To ensure 3 upper/lower -case letters and 4 numbers
		int UCC = 0, LCC = 0, NC = 0;
		Boolean GhostLetter = true;
		
		//Final result
		String PasswordFull = "";
			
			for (int i = 0; i < 10; i++){
				
				//Loop for failsafe
				GhostLetter = true;
				while (GhostLetter == true){
					
					//Decides if next char is going to be a number or letter (NextType), and if its a letter 
					//- if its going to be upper/lower -case
					Boolean NextUpper = gen.nextBoolean();
					Boolean NextType = gen.nextBoolean();
					
					//NextType = True = Letter
					if (NextType == true){
						
						//NextUpper = True = Uppercase
						if ((NextUpper == true && UCC < 3) || (NextUpper == false && LCC == 3 && UCC < 3)){
							
							//Choses a random char in alphabet and puts it into array
							//Makes sure the char is gonna be uppercase
							Alphabet = Alphabet.toUpperCase();
							Pass[i] = Alphabet.charAt(gen.nextInt(Alphabet.length()-1));
							UCC++;
							
						} 
						else if (LCC < 3) {
							
							//Same as uppercase but ensures lowercase
							Alphabet = Alphabet.toLowerCase();
							Pass[i] = Alphabet.charAt(gen.nextInt(Alphabet.length()-1));
							LCC++;
							
						}
						
					}
					else if (NC < 4) {
						
						//If the next char isnt gonna be a letter its gonna be a number
						Pass[i] = Numbers.charAt(gen.nextInt(Numbers.length()-1));
						NC++;
						
					}
					
					//If spot in array is still empty it tries again
					GhostLetter = false;
					
					if (Pass[i] == 0){
						
						GhostLetter = true;
						
					}
					
				}
		
					
			}
								
			//Puts the password together as a string
			for (int j = 0; j < 10; j++){
				
				PasswordFull = PasswordFull + Pass[j];
				
			}
				
		return PasswordFull;
		
	}

}
