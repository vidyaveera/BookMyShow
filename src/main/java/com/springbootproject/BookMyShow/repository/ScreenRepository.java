package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer> 
{

}
