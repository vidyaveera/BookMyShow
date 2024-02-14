package com.springbootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootproject.BookMyShow.entity.User;
import com.springbootproject.BookMyShow.repository.UserRepository;

@Repository
public class UserDao 
{
    @Autowired
	UserRepository userRepository;
	
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User findUser(int userId)
	{
		Optional<User> optional= userRepository.findById(userId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public User deleteUser(int userId)
	{
		User exUser=findUser(userId);
		if(exUser!=null)
		{
			userRepository.deleteById(userId);
		    return exUser;
		}
	
		return null;
	}

	public User updateUser(User user,int userId)
	{
		User exUser=findUser(userId);
		
		if(exUser!=null)
		{
			user.setUserId(userId);
			return userRepository.save(user);
		}
		return null;
	}
	
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}
	
}
