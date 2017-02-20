package dal;

import java.util.ArrayList;
import java.util.List;

import dto.UserDTO;

public class UserDAO1 implements IUserDAO{
	List<UserDTO> userList = new ArrayList();
	
	
	public UserDTO getUser(int userId){
		return userList.get(userId);
	}
	
	public List<UserDTO> getUserList(){
		return userList;
	}
	
	public void createUser(UserDTO user){
		
		userList.add(user);
		
	}
	
	public void updateUser(UserDTO user){
		
	}
	
	public void deleteUser(int userId){
		
		userList.remove(userId);
		
	}

}
