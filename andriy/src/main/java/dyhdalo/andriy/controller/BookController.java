package dyhdalo.andriy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dyhdalo.andriy.entity.Book;
import dyhdalo.andriy.entity.BooksByGenre;
import dyhdalo.andriy.service.BookService;

@Controller
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/**
	 * @return page for view all books
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public String getBooks(Model model){
		
		List<Book> books = bookService.getAllBooks();
		
		model.addAttribute("books", books);
		
		return "books";
	}
	
	/**
	 * @return current book
	 * */
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public String getBook(Model model,  @PathVariable long id){
		
		Book book = bookService.findById(id);
		
		model.addAttribute("book", book);
		
		return "currentBook";
	}
	
	/**
	 * @return page for add new book
	 * */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newBookPage(Model model){
		
		model.addAttribute("book", new Book());
		
		return "bookPage";
	}
	
	/**
	 * add new book
	 * */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addBook(Model model, @ModelAttribute("book") Book book){
		
		try {
			bookService.addBook(book);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to add book, please try again later");
			return "message";
		}
		
		return "redirect:../books";
	}
	
	/**
	 * @return page for update current book
	 * */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public String updateBook(Model model, @PathVariable long id){
		
		Book book = bookService.findById(id);
		
		model.addAttribute("book", book);
		model.addAttribute("update", "update");
		
		return "bookPage";
	}
	
	/**
	 * update current book
	 * */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.POST)
	public String updateBook(Model model, @ModelAttribute("book") Book book, @PathVariable long id){
		
		try {
			bookService.updateBook(book);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to update book, please try again later");
			return "message";
		}
		
		return "redirect:..";
	}
	
	/**
	 * delete current book
	 * */
	@RequestMapping(value = "/id/{id}/delete", method = RequestMethod.GET)
	public String deleteBook(Model model, @PathVariable long id){
		
		try {
			bookService.deleteBook(id);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to delete book, please try again later");
			return "message";
		}
		
		return "redirect:../..";
	}
	
	/**
	 * @return books whose author has more than 1 written books
	 * */
	@RequestMapping(value = "/niceAuthor", method = RequestMethod.GET)
	public String niceAuthor(Model model){
		
		List<Book> booksOfNiceAuthors = bookService.getBooksOfAuthorsWithMoreOneBook();
		
		model.addAttribute("books", booksOfNiceAuthors);
		
		return "booksOfNiceAuthors";
	}
	
	/**
	 * @return number of books by genre
	 * */
	@RequestMapping(value = "/genre", method = RequestMethod.GET)
	public String numberOfBooksByGenre(Model model){
		
		List<BooksByGenre> genre = bookService.getNumberOfBooksByGenre();
		
		model.addAttribute("booksByGenre", genre);
		
		return "booksByGenre";
	}
}
