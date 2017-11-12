package pl.coderslab.service;

import java.util.Map;

import pl.coderslab.entity.Book;

public interface BookService {
	Map<Long, Book> getBooks();

	Book getBook(long id);
	
	void addBook(String isbn, String title, String author, String publisher, String type);

	void updateBook(Book book);

	void deleteBook(long id);
}
