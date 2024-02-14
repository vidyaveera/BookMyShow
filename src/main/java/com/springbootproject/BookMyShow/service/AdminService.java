package com.springbootproject.BookMyShow.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.BookMyShow.dao.AdminDao;
import com.springbootproject.BookMyShow.entity.Admin;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@Service
public class AdminService
{
    @Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		structure.setMessage("admin saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(int adminId)
	{
		Admin admin=adminDao.findAdmin(adminId);
		if(admin!=null)
		{
	    ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
	    structure.setMessage("admin found");
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setData(admin);
		return  new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.FOUND);
		}
		return null;
	
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int adminId)
	{
		Admin admin=adminDao.findAdmin(adminId);
		if(admin!=null)
		{
			adminDao.deleteAdmin(adminId);
			ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
			structure.setMessage("admin deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(admin);
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		return null;
		
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin,int adminId)
	{
		Admin exadmin=adminDao.findAdmin(adminId);
		if(exadmin!=null) 
		{
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		structure.setMessage("admin updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(adminDao.updateAdmin(admin, adminId));
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
           return null;	
     }
	
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmins()
	{
		List<Admin> admins = adminDao.findAllAdmins();
		if(admins != null) 
		{
		ResponseStructure<List<Admin>> structure=new ResponseStructure<List<Admin>>();
		structure.setMessage("List of admins");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(adminDao.findAllAdmins());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.OK);
		}
           return null;	
     }
	
}
