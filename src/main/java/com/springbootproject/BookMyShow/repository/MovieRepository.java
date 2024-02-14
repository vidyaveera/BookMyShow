package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>
{

}
