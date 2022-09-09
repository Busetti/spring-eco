package com.guru.crud.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BookReviewDto {

	
	private Long id;
	
    /**
     * title of the book
     */

    private String title;

    /**
     * author of the book
     */

    private String author;

    /**
     * category of the book
     * Eg: Novel, Fiction, etc
     */

    private CategoryEnum category;

    /**
     * price of the book
     */

    @Min(value = 0, message = "Price should be positive value.")
    private float price;

    /**
     * Amount of book available
     */

    @Min(value = 0, message = "Total Count should be positive value.")
    private int totalCount;
    
    @Max(value = 5)
    private int review;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public float getPrice() {
		return price;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	
	public BookReviewDto(Long id, String title, String author, CategoryEnum category,
			@Min(value = 0, message = "Price should be positive value.") float price,
			@Min(value = 0, message = "Total Count should be positive value.") int totalCount, @Max(5) int review) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.totalCount = totalCount;
		this.review = review;
	}

	public BookReviewDto() {
	}

    

}