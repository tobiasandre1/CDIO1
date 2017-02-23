package test;

import static org.junit.Assert.*;
import org.junit.Test;
import dto.UserDTO;
import pl.PassGen;

/**
 * Tests password generation and validility of passwords generated
 * 
 * test1 tests generation, set and get
 * 
 * test2 tests if generated passwords is validt (20000 passwords)
 * and counts the amount of validt and invalidt passwords /20000
 * 
 * @author von Scholten
 *
 */

public class PassGenTest {
	UserDTO testUser = new UserDTO();
	PassGen testPassGen = new PassGen();
	int lc, uc, d, v, iv;

	@Test
	public void test1() {

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

		// generates and splits password string into an array
		String[] testValidate = testPassGen.Pass().split("(?!^)");

		// asserts password lenght must be 10 characters long
		assertEquals(10, testValidate.length);

		v = 0; //
		iv = 0;

		for (int j = 0; j < 20000; j++) {
			lc = 0; // lowercase count
			uc = 0; // uppercase count
			d = 0; // digit count

			/*
			 * checking character properties
			 */

			for (int i = 0; i < testValidate.length; i++) {
				// System.out.println(testValidate[i]);
				char ch = testValidate[i].charAt(0);

				// check if ch is a lowercase letter
				if (Character.isLowerCase(ch)) {
					// System.out.println("this is a lowercase letter");
					lc++;
				}
				// check if ch is a uppercase letter
				if (Character.isUpperCase(ch)) {
					// System.out.println("this is a uppercase letter");
					uc++;
				}
				// check if ch is a digit
				if (Character.isDigit(ch)) {
					// System.out.println("this is a digit");
					d++;
				}
				// check if ch is a whitespace
				if (Character.isSpaceChar(ch)) {
					// System.err.println("this is af whitespace");
				}

			}
			// System.out.println("lowercase count: " + lc);
			// System.out.println("uppercase count: " + uc);
			// System.out.println("digit count: " + d);

			if (lc >= 3 && uc >= 3 && d >= 3) {
				// System.out.println("is validt");
				v++;

			} else {
				iv++;
				// System.err.println("is invalidt");
			}
		}

		assertEquals(20000, v);
		System.out.println("validt pass count: " + v);
		System.err.println("invalidt passs count: " + iv);
	}

}
