package com.springbootproject.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.BookMyShow.dao.MovieDao;
import com.springbootproject.BookMyShow.entity.Movie;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@Service
public class MovieService 
{
	@Autowired
	MovieDao movieDao;
	
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie)
	{
		ResponseStructure<Movie> structure=new ResponseStructure<Movie>();
		structure.setMessage(" movie object saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(movieDao.saveMovie(movie));
		return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Movie>> findMovie(int movieId)
	{
		Movie movie=movieDao.findMovie(movieId);
		if(movie!=null)
		{
	    ResponseStructure<Movie> structure=new ResponseStructure<Movie>();
	    structure.setMessage("Found movie");
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setData(movie);
		return  new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int movieId)
	{
		Movie movie=movieDao.findMovie(movieId);
		if(movie!=null)
		{
			movieDao.deleteMovie(movieId);
			ResponseStructure<Movie> structure=new ResponseStructure<Movie>();
			structure.setMessage("movie deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(movie);
		return new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(Movie movie,int movieId)
	{
		Movie exmovie=movieDao.findMovie(movieId);
		if(exmovie!=null) 
		{
		ResponseStructure<Movie> structure=new ResponseStructure<Movie>();
		structure.setMessage("movie Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(movieDao.updateMovie(movie, movieId));
		return new ResponseEntity<ResponseStructure<Movie>>(structure,HttpStatus.OK);
		}
          return null;
    }
	
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovies()
	{
		List<Movie> movieList=movieDao.findAllMovies();
		if(movieList!=null) 
		{
			ResponseStructure<List<Movie>> structure= new ResponseStructure<List<Movie>>();
			structure.setMessage("list of all movie");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(movieList);
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure,HttpStatus.OK);
		}
		return null;
	}
}
