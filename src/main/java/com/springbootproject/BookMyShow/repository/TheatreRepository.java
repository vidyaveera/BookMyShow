package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>
{

}
