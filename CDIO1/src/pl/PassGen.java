package pl;

import java.util.Random;

public class PassGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random gen = new Random();
		char[] Pass  = new char[10];
		
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		String Numbers = "1234567890";
		
		int UCC = 0, LCC = 0, NC = 0;
		
		for (int i = 0; i < 10; i++){
		
			Boolean NextUpper = gen.nextBoolean();
			Boolean NextType = gen.nextBoolean();
			
			if (NextType == true){
				
				if ((NextUpper == true && UCC < 3) || (NextUpper == false && LCC == 3 && UCC < 3)){
					
					Alphabet = Alphabet.toUpperCase();
					Pass[i] = Alphabet.charAt(gen.nextInt(Alphabet.length()-1));
					UCC++;
					
				} 
				else if (LCC < 3) {
					
					Alphabet = Alphabet.toLowerCase();
					Pass[i] = Alphabet.charAt(gen.nextInt(Alphabet.length()-1));
					LCC++;
					
				}
				
			}
			else if (NC < 4) {
				
				Pass[i] = Numbers.charAt(gen.nextInt(Numbers.length()-1));
				NC++;
				
			}
			
		}
		
		String PasswordFull = "";
		for (int j = 0; j < 10; j++){
			
			PasswordFull = PasswordFull + Pass[j];
			
		}
		
		System.out.println(PasswordFull);
		
	}

}
