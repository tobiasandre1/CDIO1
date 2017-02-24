package test;

import static org.junit.Assert.*;
import org.junit.Test;
import dto.UserDTO;
import pl.PassGen;

/**
 * Tests password generation and validility of passwords generated
 * 
 * The program shall auto-generate a password according to following rules 6 or
 * more characters with at least 3 of the following 4 categories lowercase
 * letters (a to z) uppercase letters (A to Z) digits (0 to 9) special
 * characters {'.', '-', '_', '+', '!', '?', '='}
 * 
 * @author von Scholten
 *
 */

public class PassGenTest {
	UserDTO testUser = new UserDTO();
	PassGen testPassGen = new PassGen();
	int amountOfTest = 100000;
	int lowercase, uppercase, digit, valid, invalid;

	@Test
	public void test1() {

		System.out.println("-----running test1-----");

		// tests set and get
		testUser.setPassword("123abcABC#?!!");
		System.out.println(testUser.getPassword());
		assertEquals("123abcABC#?!!", testUser.getPassword());

		// generates and show random password
		testUser.setPassword(testPassGen.Pass());
		System.out.println(testUser.getPassword());

	}

	@Test
	public void test2() {
		System.out.println("-----running test2-----");

		// generates and splits password string into an array
		String[] testValidate = testPassGen.Pass().split("(?!^)");

		// asserts password lenght must be 10 characters long
		assertEquals(10, testValidate.length);

		valid = 0; // valid pass. count
		invalid = 0; // invalid pass. count

		for (int j = 0; j < amountOfTest; j++) {
			lowercase = 0; // lowercase count
			uppercase = 0; // uppercase count
			digit = 0; // digit count

			/*
			 * checking character properties
			 */

			for (int i = 0; i < testValidate.length; i++) {
				char ch = testValidate[i].charAt(0);

				// check if ch is a lowercase letter
				if (Character.isLowerCase(ch)) {
					lowercase++;
				}
				// check if ch is a uppercase letter
				if (Character.isUpperCase(ch)) {
					uppercase++;
				}
				// check if ch is a digit
				if (Character.isDigit(ch)) {
					digit++;
				}
				// check if ch is a whitespace
				if (Character.isSpaceChar(ch)) {
				}

			}

			if (lowercase > 1 && uppercase > 1 && digit > 1) {
				valid++;

			} else {
				invalid++;
				System.err.println("invalid password: " + testValidate);
			}
		}

		// asserts the expected result with the acutal result
		assertEquals(amountOfTest, valid);
		System.out.println("validt pass count: " + valid);
		System.out.println("test passed");
		if (invalid == 0)
			System.err.println("invalidt passs count: " + invalid);
	}
}
