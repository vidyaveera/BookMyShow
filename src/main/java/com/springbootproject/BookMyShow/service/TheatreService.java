package com.springbootproject.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.BookMyShow.dao.TheatreDao;
import com.springbootproject.BookMyShow.entity.Theatre;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@Service
public class TheatreService 
{
	@Autowired
	TheatreDao theatreDao;
	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre)
	{
		ResponseStructure<Theatre> structure=new ResponseStructure<Theatre>();
		structure.setMessage(" theatre object saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(theatreDao.saveTheatre(theatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId)
	{
		Theatre theatre=theatreDao.findTheatre(theatreId);
		if(theatre!=null)
		{
	    ResponseStructure<Theatre> structure=new ResponseStructure<Theatre>();
	    structure.setMessage("Found theatre");
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setData(theatre);
		return  new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.FOUND);
		}
         return null;
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreId)
	{
		Theatre theatre =theatreDao.findTheatre(theatreId);
		if(theatre!=null)
		{
			theatreDao.deleteTheatre(theatreId);
			ResponseStructure<Theatre> structure=new ResponseStructure<Theatre>();
			structure.setMessage("theatre deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(theatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(Theatre theatre,int theatreId)
	{
		Theatre extheatre=theatreDao.findTheatre(theatreId);
		if(extheatre!=null) 
		{
		ResponseStructure<Theatre> structure=new ResponseStructure<Theatre>();
		structure.setMessage("theatre Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(theatreDao.updateTheatre(theatre, theatreId));
		return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatres()
	{
		List<Theatre> theatreList=theatreDao.findAllTheatres();
		if(theatreList!=null) 
		{
		ResponseStructure<List<Theatre>> structure= new ResponseStructure<List<Theatre>>();
		structure.setMessage("list of all theatre");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(theatreList);
		return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure,HttpStatus.OK);
		}
		return null;
	}
}
