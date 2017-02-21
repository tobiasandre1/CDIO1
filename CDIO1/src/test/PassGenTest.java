package test;

import static org.junit.Assert.*;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import dto.UserDTO;
import pl.PassGen;

/**
 * Tests password generation and validility of passwords generated
 * 
 * @author von Scholten
 *
 */

public class PassGenTest {
	UserDTO testUser = new UserDTO();
	PassGen testPassGen = new PassGen();

	@Test
	public void test() {

		// tests set and get
		testUser.setPassword("123abcABC#?!!");
		System.out.println(testUser.getPassword());
		assertEquals("123abcABC#?!!", testUser.getPassword());

		// tests Pass() methode
		// testUser.setPassword(testPassGen.Pass());
		// System.out.println(testUser.getPassword());

		// generates and splits password string into an array
		String[] testValidate = testPassGen.Pass().split("(?!^)");
		
		//asserts password lenght must be ?? characters long
		assertEquals(10, testValidate.length);

		//
		for (int i = 0; i < testValidate.length; i++) {
			System.out.println(testValidate[i]);
			// if(){
			//
			// }
		}
	}

}
