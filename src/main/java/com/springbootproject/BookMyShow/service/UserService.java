package com.springbootproject.BookMyShow.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springbootproject.BookMyShow.dao.UserDao;
import com.springbootproject.BookMyShow.entity.User;
import com.springbootproject.BookMyShow.util.ResponseStructure;

public class UserService
{
	@Autowired
	UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage(" User object saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(userDao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int userId)
	{
		User user=userDao.findUser(userId);
		if(user!=null)
		{
	    ResponseStructure<User> structure=new ResponseStructure<User>();
	    structure.setMessage("Found User");
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setData(user);
		return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		  return null;
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId)
	{
		User user=userDao.findUser(userId);
		if(user!=null)
		{
			userDao.deleteUser(userId);
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("user deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(user);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		   return null;
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user,int userId)
	{
		User exUser=userDao.findUser(userId);
		if(exUser!=null) 
		{
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("user Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(userDao.updateUser(user, userId));
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
           return null;
    }
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		List<User> userList=userDao.findAllUsers();
		if(userList!=null) 
		{
		ResponseStructure<List<User>> structure= new ResponseStructure<List<User>>();
		structure.setMessage("list of all user");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(userList);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);

		}
		return null;
	}
}
