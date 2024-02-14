package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{

}
