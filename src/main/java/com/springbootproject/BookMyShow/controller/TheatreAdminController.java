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

import com.springbootproject.BookMyShow.entity.TheatreAdmin;
import com.springbootproject.BookMyShow.service.TheatreAdminService;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("theatreadmin")
public class TheatreAdminController
{
	@Autowired
	TheatreAdminService theatreAdminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> saveTheatreAdmin(@RequestBody TheatreAdmin theatreAdmin) 
	{
		return theatreAdminService.saveTheatreAdmin(theatreAdmin);	
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> findTheatreAdmin(@RequestParam int theatreAdminId) 
	{
		return theatreAdminService.findTheatreAdmin(theatreAdminId);	
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> deleteTheatreAdmin(@RequestParam int theatreAdminId) 
	{
		return theatreAdminService.deleteTheatreAdmin(theatreAdminId);	
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> updateTheatreAdmin(@RequestBody TheatreAdmin theatreAdmin,@RequestParam int theatreAdminId) 
	{
		return theatreAdminService.updateTheatreAdmin(theatreAdmin,theatreAdminId);	
	}
	
	@GetMapping("alltheatreadmins")
	public List<TheatreAdmin> findAllTheatreAdmin()
	{
		return (List<TheatreAdmin>) theatreAdminService.findAllTheatreAdmins();
	}
}
