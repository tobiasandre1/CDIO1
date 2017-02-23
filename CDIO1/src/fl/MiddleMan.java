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
	
	public UserDTO getUser(int userId) throws DALException{
		UserDTO tempData = null;
		for(int i = 0; i < data.getUserList().size(); i++){
			if(data.getUserList().get(i).getUserId() == userId){
				tempData = data.getUserList().get(i);
			}
		}
		return tempData;
	}
	public void updateUserName(int userId, String newName) throws DALException{
		getUser(userId).setUserName(newName);
		data.updateUser(getUser(userId));
	}
	public void updatePassword(int userId, String newPassword) throws DALException{
		getUser(userId).setPassword(newPassword);
		data.updateUser(getUser(userId));
	}
	public void updateINI(int userId, String newINI) throws DALException{
		getUser(userId).setIni(newINI);
		data.updateUser(getUser(userId));
	}
	public void updateCPR(int userId, String newCPR) throws DALException{
		getUser(userId).setCpr(newCPR);
		data.updateUser(getUser(userId));
	}
	public void addRole(int userId, String newRole) throws DALException{
		getUser(userId).addRole(newRole);
		data.updateUser(getUser(userId));
	}
	public void removeRole(int userId, String removeRole) throws DALException{
		getUser(userId).removeRole(removeRole);
		data.updateUser(getUser(userId));
	}
	//returns false if no user was removed
	public boolean deleteUser(int userId) throws DALException{
		boolean userRemoved = false;
		if(data.deleteUser(userId) == true){
			userRemoved = true;
		}
		return userRemoved;
	}
}

