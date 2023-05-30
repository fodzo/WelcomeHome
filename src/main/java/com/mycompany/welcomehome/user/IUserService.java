package com.mycompany.welcomehome.user;

import java.util.List;

import com.mycompany.welcomehome.exception.DuplicatedEntryException;

public interface IUserService {
	public User registerUser(User user) throws DuplicatedEntryException;
	public List<User> users();

}
