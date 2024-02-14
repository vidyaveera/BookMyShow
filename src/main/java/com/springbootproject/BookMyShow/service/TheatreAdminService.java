package com.springbootproject.BookMyShow.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.BookMyShow.dao.TheatreAdminDao;
import com.springbootproject.BookMyShow.entity.TheatreAdmin;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@Service
public class TheatreAdminService
{
    @Autowired
	TheatreAdminDao theatreAdminDao;
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> saveTheatreAdmin(TheatreAdmin theatreAdmin)
	{
		ResponseStructure<TheatreAdmin> structure=new ResponseStructure<TheatreAdmin>();
		structure.setMessage(" theatreAdmin object saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(theatreAdminDao.saveTheatreAdmin(theatreAdmin));
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> findTheatreAdmin(int theatreAdminId)
	{
		TheatreAdmin theatreAdmin=theatreAdminDao.findTheatreAdmin(theatreAdminId);
		if(theatreAdmin!=null)
		{
	    ResponseStructure<TheatreAdmin> structure=new ResponseStructure<TheatreAdmin>();
	    structure.setMessage("Found theatreAdmin");
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setData(theatreAdmin);
		return  new ResponseEntity<ResponseStructure<TheatreAdmin>>(structure,HttpStatus.FOUND);
		}
           return null;
     }
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> deleteTheatreAdmin(int theatreAdminId)
	{
		TheatreAdmin theatreAdmin=theatreAdminDao.findTheatreAdmin(theatreAdminId);
		if(theatreAdmin!=null)
		{
			theatreAdminDao.deleteTheatreAdmin(theatreAdminId);
			ResponseStructure<TheatreAdmin> structure=new ResponseStructure<TheatreAdmin>();
			structure.setMessage("theatreAdmin deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(theatreAdmin);
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> updateTheatreAdmin(TheatreAdmin theatreAdmin,int theatreAdminId)
	{
		TheatreAdmin extheatreAdmin=theatreAdminDao.findTheatreAdmin(theatreAdminId);
		if(extheatreAdmin!=null) 
		{
		ResponseStructure<TheatreAdmin> structure=new ResponseStructure<TheatreAdmin>();
		structure.setMessage("theatreAdmin Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(theatreAdminDao.updateTheatreAdmin(theatreAdmin, theatreAdminId));
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<TheatreAdmin>>> findAllTheatreAdmins()
	{
		List<TheatreAdmin> theatreAdminList=theatreAdminDao.findAllTheatreAdmins();
		if(theatreAdminList!=null) 
		{
		ResponseStructure<List<TheatreAdmin>> structure= new ResponseStructure<List<TheatreAdmin>>();
		structure.setMessage("list of all theatreAdmin");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(theatreAdminList);
		return new ResponseEntity<ResponseStructure<List<TheatreAdmin>>>(structure,HttpStatus.OK);
		}
          return null;
	}
}
