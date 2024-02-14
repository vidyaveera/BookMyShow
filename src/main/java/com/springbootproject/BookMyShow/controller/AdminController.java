package com.springbootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.BookMyShow.entity.Admin;
import com.springbootproject.BookMyShow.service.AdminService;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("admin")
public class AdminController 
{
	@Autowired
	AdminService adminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) 
	{
		return adminService.saveAdmin(admin);	
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(@RequestParam  int adminId) 
	{
		return adminService.findAdmin(adminId);	
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int adminId) 
	{
		return adminService.deleteAdmin(adminId);	
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin,@RequestParam int adminId) 
	{
		return adminService.updateAdmin(admin,adminId);	
	}
	
	@GetMapping("alladmins")
	public List<Admin> findAllAdmins()
	{
		return (List<Admin>) adminService.findAllAdmins();
	}
}
