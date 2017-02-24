package dal;

import java.util.ArrayList;
import java.util.List;

import dto.UserDTO;

public class UserDAO1 implements IUserDAO{
	List<UserDTO> userList = new ArrayList<UserDTO>();
	
	
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
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUserId() == user.getUserId()){
				userList.set(i, user);
			}
		}
	}
	//returns false if no user was removed
	public boolean deleteUser(int userId){
		boolean userRemoved = false;
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getUserId() == userId){
				userList.remove(i);
				userRemoved = true;
			}
		}
		return userRemoved;
	}

}
