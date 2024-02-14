package com.springbootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.BookMyShow.entity.Booking;
import com.springbootproject.BookMyShow.service.BookingService;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("booking")
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking) 
	{
		return bookingService.saveBooking(booking);	
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> findBooking(@RequestParam int bookingId) 
	{
		return bookingService.findBooking(bookingId);	
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bookingId) 
	{
		return bookingService.deleteBooking(bookingId);	
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,@RequestParam int bookingId) 
	{
		return bookingService.updateBooking(booking,bookingId);	
	}
	
	@GetMapping("allbookings")
	public List<Booking> findAllbooking()
	{
		return (List<Booking>) bookingService.findAllBookings();
	}
}
