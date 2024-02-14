package com.springbootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootproject.BookMyShow.entity.Theatre;
import com.springbootproject.BookMyShow.repository.TheatreRepository;

@Repository
public class TheatreDao
{
	@Autowired
	TheatreRepository theatreRepository;
	
	public Theatre saveTheatre(Theatre theatre)
	{
		return theatreRepository.save(theatre);
	}
	
	public Theatre findTheatre(int theatreId)
	{
		Optional<Theatre> optional= theatreRepository.findById(theatreId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Theatre deleteTheatre(int theatreId)
	{
		Theatre exTheatre = findTheatre(theatreId);
		if(exTheatre!=null)
		{
			theatreRepository.deleteById(theatreId);
		    return exTheatre;
		}
	
		return null; 
	}

	public Theatre updateTheatre(Theatre theatre,int theatreId)
	{
		Theatre exTheatre = findTheatre(theatreId);
		
		if(exTheatre!=null)
		{
			theatre.setTheatreId(theatreId);
			return theatreRepository.save(theatre);
		}
		return null;
	}
	
	public List<Theatre> findAllTheatres()
	{
		return theatreRepository.findAll();
	}
}
