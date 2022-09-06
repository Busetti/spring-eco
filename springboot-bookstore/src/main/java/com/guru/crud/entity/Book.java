package com.guru.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Book {
    /**
     * Unique Book Number given by company.
     * Eg: ISBN number
     */
    @Id
    private Long id;

    /**
     * title of the book
     */
    @NotNull
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

    /**
     * Total copies of book sold
     */
    @Min(value = 0, message = "Total sell should be positive value.")
    private int sold;

	public Long getId() {
		return id;
	}

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

	public int getSold() {
		return sold;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setSold(int sold) {
		this.sold = sold;
	}

	public Book(Long id, @NotNull String title, String author, CategoryEnum category,
			@Min(value = 0, message = "Price should be positive value.") float price,
			@Min(value = 0, message = "Total Count should be positive value.") int totalCount,
			@Min(value = 0, message = "Total sell should be positive value.") int sold) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.totalCount = totalCount;
		this.sold = sold;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", category=");
		builder.append(category);
		builder.append(", price=");
		builder.append(price);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", sold=");
		builder.append(sold);
		builder.append("]");
		return builder.toString();
	}
    
    
    
    
}