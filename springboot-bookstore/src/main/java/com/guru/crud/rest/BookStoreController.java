package com.guru.crud.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guru.crud.entity.BookDto;
import com.guru.crud.entity.BookReviewDto;
import com.guru.crud.entity.CategoryEnum;
import com.guru.crud.service.BookStoreService;

/**
 * 1)Add a book
 * 2)get books by Id 
 * 3)get all books 
 * 4)get number of books available by Id
 * 5)update a book 
 * 6)get book(s) by category/keywords 
 * 7)get number of books sold
 * per category/keyword
 */
@RestController
@RequestMapping("/api")
public class BookStoreController {

	private final BookStoreService bookStoreService;

	@Autowired
	public BookStoreController(BookStoreService bookStoreService) {
		this.bookStoreService = bookStoreService;
	}

	/**
	 * AC: 1)Add a book This add new book with new Identifier.
	 *
	 * @param bookDto
	 */
	@PostMapping("/add-new-book")
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewBook(@Valid @RequestBody BookDto bookDto) {
		bookStoreService.addNewBook(bookDto);
	}

	/**
	 * AC: 1)Add a book This method add quantity of book to the books which are
	 * already registered.
	 *
	 * @param id
	 * @param quantityToAdd
	 */
	@PutMapping("/add-book/{id}/{quantityToAdd}")
	@ResponseStatus(HttpStatus.OK)
	public void addBook(@PathVariable Long id, @PathVariable int quantityToAdd) {
		bookStoreService.addBook(id, quantityToAdd);
	}

	/**
	 * AC: 2)get books by id
	 *
	 * @param id
	 * @return bookDto
	 */
	@GetMapping("/book/{id}")
	public BookDto getBookById(@PathVariable Long id) {
		return bookStoreService.getBookById(id);
	}

	/**
	 * AC: 3)Get All Books
	 *
	 * @return List<BookDto>
	 */
	@GetMapping("/book-list")
	public List<BookReviewDto> getAllBooks() {
		return bookStoreService.getAllBooks();
	}

	/**
	 * AC: 4) Get number of books available by id.
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/number-of-books/{id}")
	public int getNumberOfBooksById(@PathVariable Long id) {
		return bookStoreService.getNumberOfBooksById(id);
	}

	/**
	 * AC: 5) Update a book.
	 */
	@PutMapping("/books/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateBook(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
		bookStoreService.updateBook(id, bookDto);
	}

	/**
	 * AC:6 Get Books by category/keyword
	 *
	 * @param category Respresnts Different Category of book. EG: NONFICTION,
	 *                 ACTION, ETC. Check the category enum
	 * @param keyword  Assuming keyword to be any search value. This will be used to
	 *                 search on title, author or id of the book
	 * @return
	 */
	@GetMapping("/books")
	public List<BookDto> getBookByCategoryKeyWord(@RequestParam String keyword, @RequestParam CategoryEnum category) {
		return bookStoreService.getBookByCategoryKeyWord(keyword, category);
	}

	/**
	 * AC:7 Get Number of books sold per category/keyword
	 *
	 * @param keyword
	 * @param category
	 * @return
	 */
	@GetMapping("/number-of-books")
	public int getNumberOfBooksSoldByCategoryAndKeyword(@RequestParam String keyword,
			@RequestParam CategoryEnum category) {
		return bookStoreService.getNumberOfBooksSoldByCategoryAndKeyword(keyword, category);
	}

}