package com.springbootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootproject.BookMyShow.entity.Movie;
import com.springbootproject.BookMyShow.repository.MovieRepository;

@Repository
public class MovieDao 
{
    @Autowired
	MovieRepository movieRepository;
	
   public Movie saveMovie(Movie movie)
   {
	   return movieRepository.save(movie);
   }
   
   public Movie findMovie(int movieId)
   {
	  Optional<Movie> optional = movieRepository.findById(movieId);
	  
	  if(optional.isPresent())
	  {
		  return optional.get();
	  }
	  
	  return null;
   }
   
   public Movie deleteMovie(int movieId)
   {
	   Movie exMovie = findMovie(movieId);
	   
	   if(exMovie != null)
	   {
		   movieRepository.deleteById(movieId);
		   return exMovie;
	   }
	   
	   return null;
   }
   
   public Movie updateMovie(Movie movie, int movieId)
   {
	   Movie exMovie = findMovie(movieId); 
 
	   if(exMovie != null)
	   {
		   movie.setMovieId(movieId);
		   return movieRepository.save(movie);
	   }
	   
	   return null;
   }
	
   public List<Movie> findAllMovies()
	{
		return movieRepository.findAll();
	}
}
