package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.BookMyShow.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>
{

}
