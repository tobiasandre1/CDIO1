package fl;

import java.util.List;

import dto.UserDTO;
import dal.UserDAO1;
import dal.IUserDAO;
import dal.IUserDAO.DALException;

public class MiddleMan {
		
	IUserDAO Data = new UserDAO1();
	
	public List<UserDTO> getUserList(){
		return null;
	}
	
	public void createUser(UserDTO user) throws DALException{
		
		Data.createUser(user);
		
	}
	
	public void updateUser(UserDTO user){
		
	}
	
	public void deleteUser(int userId) throws DALException{
		
		Data.deleteUser(userId);
		
	}
}

