package com.guru.crud.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.crud.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	
	private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Autowired
	ReviewRepository reviewRepo;

	@Override
	public Review addReview(Review review) {
		log.info("Save review with Book Id %s", review.getBookId());
		return reviewRepo.save(review);
	}

	@Override
	public List<Review> findReviewsById(Long id) {
		return reviewRepo.findByBookId(id);
	}

}
