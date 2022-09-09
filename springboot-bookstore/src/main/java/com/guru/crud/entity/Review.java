package com.guru.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
public class Review {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	private Long bookId;
	
	@Min(value = 0, message = "Negative values not allowed for review")
	@Max(value = 5, message = "Max 5 rating can give")
	private int review;

	public Long getId() {
		return id;
	}

	public Long getBookId() {
		return bookId;
	}

	public int getReview() {
		return review;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public Review(Long id, Long bookId,
			@Min(value = 0, message = "Negative values not allowed for review") @Max(value = 5, message = "Max 5 rating can give") int review) {
		this.id = id;
		this.bookId = bookId;
		this.review = review;
	}

	
	public Review(Long bookId,
			@Min(value = 0, message = "Negative values not allowed for review") @Max(value = 5, message = "Max 5 rating can give") int review) {
		this.bookId = bookId;
		this.review = review;
	}

	public Review() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=");
		builder.append(id);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", review=");
		builder.append(review);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
