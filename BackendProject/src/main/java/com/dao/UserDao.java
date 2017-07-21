package com.dao;

import java.util.List;

import com.model.PROJ2_USER;

public interface UserDao {
	PROJ2_USER authenticate(PROJ2_USER user);
    void updateUser(PROJ2_USER user);
	PROJ2_USER registerUser(PROJ2_USER user);
	
	public List<PROJ2_USER> getAllUsers(PROJ2_USER user);
}