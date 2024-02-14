package com.springbootproject.BookMyShow.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.BookMyShow.dao.BookingDao;
import com.springbootproject.BookMyShow.entity.Booking;
import com.springbootproject.BookMyShow.util.ResponseStructure;

@Service
public class BookingService
{
    @Autowired
	BookingDao bookingDao;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking)
	{
		ResponseStructure<Booking> structure=new ResponseStructure<Booking>();
		structure.setMessage(" booking object saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
	    structure.setData(bookingDao.saveBooking(booking));
		return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> findBooking(int bookingId)
	{
		Booking booking = bookingDao.findBooking(bookingId);
		if(booking!=null)
		{
	    ResponseStructure<Booking> structure=new ResponseStructure<Booking>();
	    structure.setMessage("Found booking");
	    structure.setStatus(HttpStatus.FOUND.value());
	    structure.setData(booking);
		return  new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.FOUND);
		}
           return null;
   }
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bookingId)
	{
		Booking booking = bookingDao.findBooking(bookingId);
		if(booking!=null)
		{
			bookingDao.deleteBooking(bookingId);
			ResponseStructure<Booking> structure=new ResponseStructure<Booking>();
			structure.setMessage("booking deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(booking);
		return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
		}
			return null;
	 }
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking,int bookingId)
	{
		Booking exbooking = bookingDao.findBooking(bookingId);
		if(exbooking!=null) 
		{
		ResponseStructure<Booking> structure=new ResponseStructure<Booking>();
		structure.setMessage("booking Updated");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(bookingDao.updateBooking(booking, bookingId));
		return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
		}
			return null;
     }
	
	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBookings()
	{
		List<Booking> bookingList=bookingDao.findAllBookings();
		if(bookingList!=null) 
		{
		ResponseStructure<List<Booking>> structure= new ResponseStructure<List<Booking>>();
		structure.setMessage("list of all booking");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(bookingList);
		return new ResponseEntity<ResponseStructure<List<Booking>>>(structure,HttpStatus.OK);

		}
			return null;
	}
	
}
