package com.springbootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootproject.BookMyShow.entity.Review;
import com.springbootproject.BookMyShow.repository.ReviewRepository;

@Repository
public class ReviewDao 
{
	@Autowired
	ReviewRepository reviewRepository;
	
	public Review saveReview(Review review)
	{
		return reviewRepository.save(review);
	}
	
	public Review findReview(int reviewId)
	{
		Optional<Review> optional= reviewRepository.findById(reviewId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Review deleteReview(int reviewId)
	{
		Review exReview=findReview(reviewId);
		if(exReview!=null)
		{
		reviewRepository.deleteById(reviewId);
		return exReview;
		}
	
		return null;
	}

	public Review updatereview(Review review,int reviewId)
	{
		Review exReview=findReview(reviewId);
		
		if(exReview!=null)
		{
			review.setReviewId(reviewId);
			return reviewRepository.save(review);
		}
		return null;
	}
	
	public List<Review> findAllReviews()
	{
		return reviewRepository.findAll();
	}
}
