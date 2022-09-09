package com.guru.crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.crud.entity.BookDto;
import com.guru.crud.entity.Review;
import com.guru.crud.service.BookStoreService;
import com.guru.crud.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	BookStoreService bookService;

	@Autowired
	ReviewService reviewService;

	@GetMapping("/authentication")
	public Object getAuthentication(
			@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		return authentication.getDetails();
	}

	@PostMapping("/review")
	public ResponseEntity<Review> addReview(@RequestBody Review review) {
		try {
			BookDto book = bookService.getBookById(review.getBookId());
			if (null != book) {
				return ResponseEntity.ok().body(reviewService.addReview(review));
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
