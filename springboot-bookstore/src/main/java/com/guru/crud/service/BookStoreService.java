package com.guru.crud.service;

import java.util.List;

import com.guru.crud.entity.BookDto;
import com.guru.crud.entity.BookReviewDto;
import com.guru.crud.entity.CategoryEnum;

public interface BookStoreService {

	void addNewBook(BookDto bookDto);

	void addBook(Long id, int quantityToAdd);

	BookDto getBookById(Long id);

	List<BookReviewDto> getAllBooks();

	int getNumberOfBooksById(Long id);

	void updateBook(Long id, BookDto bookDto);

	List<BookDto> getBookByCategoryKeyWord(String keyword, CategoryEnum category);

	int getNumberOfBooksSoldByCategoryAndKeyword(String keyword, CategoryEnum category);

}