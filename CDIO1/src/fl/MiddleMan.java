package fl;

import java.util.List;

import dto.UserDTO;
import dal.UserDAO1;
import dal.IUserDAO;
import dal.IUserDAO.DALException;

public class MiddleMan {
		
	IUserDAO data = new UserDAO1();
	
	public List<UserDTO> getUserList() throws DALException{
		return data.getUserList();
	}
	
	public void createUser(UserDTO user) throws DALException{
		
		data.createUser(user);
		
	}
	
	public void updateUser(UserDTO user){
		
	}
	
	public void deleteUser(int userId) throws DALException{
		
		data.deleteUser(userId);
		
	}
}

