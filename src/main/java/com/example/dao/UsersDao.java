package com.example.dao;
import java.util.List;

import com.example.model.Users;

public interface UsersDao {

	//public int insertUsers(Users p);
	public Users selectUsers(String name);
	//public int updatePet(Users p);
	public Users selectUsersByPassword(String user_password);
	public Users selectUsersByID(int user_id);
	public List<Users> selectAllUsers();
}
