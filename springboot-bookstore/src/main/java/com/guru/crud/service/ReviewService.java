package com.guru.crud.service;

import java.util.List;

import com.guru.crud.entity.Review;

public interface ReviewService {

	Review addReview(Review review);

	List<Review> findReviewsById(Long id);

}
