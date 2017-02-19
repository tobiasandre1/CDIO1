package fl;

import java.util.List;

import dto.UserDTO;
import dal.UserDAO1;

public class MiddleMan {
		
	UserDAO1 Data = new UserDAO1();
	
	public List<UserDTO> getUserList(){
		return null;
	}
	
	public void createUser(UserDTO user){
		
		Data.createUser(user);
		
	}
	
	public void updateUser(UserDTO user){
		
	}
	
	public void deleteUser(int userId){
		
		Data.deleteUser(userId);
		
	}
}

