package pl.coderslab.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/hello")
	public String getBook() {
		return "{\"hello\": \"World\"}";
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public Map<Long, Book> getBooks() {
		return bookService.getBooks();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Book getBook(@PathVariable("id") long id) {
		return bookService.getBook(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/")
	public void addBook(@RequestParam(name = "isbn", required = false) String isbn,
			@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "author", required = false) String author,
			@RequestParam(name = "publisher", required = false) String publisher,
			@RequestParam(name = "type", required = false) String type) {
		bookService.addBook(isbn, title, author, publisher, type);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path="/", consumes = "application/json")
	public void updateBook(@RequestBody(required=true) Book book) {
		bookService.updateBook(book);

	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/")
	public void deleteBook(@RequestParam("id") long id) {
		bookService.deleteBook(id);
	}

}
