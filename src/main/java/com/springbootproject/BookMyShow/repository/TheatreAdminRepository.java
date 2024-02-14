package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.TheatreAdmin;

public interface TheatreAdminRepository extends JpaRepository<TheatreAdmin, Integer>
{

}
