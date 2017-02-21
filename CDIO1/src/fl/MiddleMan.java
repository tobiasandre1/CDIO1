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
	
	public Boolean createUser(UserDTO user) throws DALException{
		
		List<UserDTO> List = data.getUserList();
		UserDTO userFake = user;
		
		for (int q = 0; q < List.size(); q++){
			
			UserDTO userCompared = List.get(q);
			
			if (userFake.getUserId() == userCompared.getUserId()){
				
				return true;
				
			}
			
		}
		
		data.createUser(user);
		return false;
		
	}
	
	public void updateUser(UserDTO user){
		
	}
	
	public void deleteUser(int userId) throws DALException{
		
		data.deleteUser(userId);
		
	}
}

