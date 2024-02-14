package com.springbootproject.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springbootproject.BookMyShow.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>
{

}
