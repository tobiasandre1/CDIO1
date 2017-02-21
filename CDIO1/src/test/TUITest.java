package test;

import static org.junit.Assert.*;
import org.junit.Test;
import dal.IUserDAO.DALException;
import pl.TUI;

/**
 * Tests the methods within TUI.java
 * 
 * @author Danny Jønsson, 
 *
 */

public class TUITest extends TUI {
		
	
	@Test
	public void test() throws DALException {
		createUser();
	}

}
