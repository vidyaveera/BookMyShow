package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{

}
