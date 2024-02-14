package com.springbootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootproject.BookMyShow.entity.TheatreAdmin;
import com.springbootproject.BookMyShow.repository.TheatreAdminRepository;

@Repository
public class TheatreAdminDao
{
	@Autowired
	TheatreAdminRepository theatreAdminRepository;
	
	public TheatreAdmin saveTheatreAdmin(TheatreAdmin theatreAdmin)
	{
		return theatreAdminRepository.save(theatreAdmin);
	}
	
	public TheatreAdmin findTheatreAdmin(int theatreAdminId)
	{
		Optional<TheatreAdmin> optional= theatreAdminRepository.findById(theatreAdminId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public TheatreAdmin deleteTheatreAdmin(int theatreAdminId)
	{
		TheatreAdmin exTheatreAdmin=findTheatreAdmin(theatreAdminId);
		if(exTheatreAdmin!=null)
		{
			theatreAdminRepository.deleteById(theatreAdminId);
		return exTheatreAdmin;
		}
	
		return null;
	}

	public TheatreAdmin updateTheatreAdmin(TheatreAdmin theatreAdmin,int theatreAdminId)
	{
		TheatreAdmin exTheatreAdmin=findTheatreAdmin(theatreAdminId);
		
		if(exTheatreAdmin!=null)
		{
			theatreAdmin.setTheatreAdminId(theatreAdminId);
			return theatreAdminRepository.save(theatreAdmin);
		}
		return null; 
	}
	
	public List<TheatreAdmin> findAllTheatreAdmins()
	{
		return theatreAdminRepository.findAll();
	}
}
