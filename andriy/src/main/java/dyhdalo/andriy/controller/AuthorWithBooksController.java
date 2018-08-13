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

import dyhdalo.andriy.entity.AuthorBook;
import dyhdalo.andriy.service.AuthorBookService;
import dyhdalo.andriy.service.AuthorService;
import dyhdalo.andriy.service.BookService;

@Controller
@RequestMapping(value = "/authors/books")
public class AuthorWithBooksController {

	@Autowired
	private AuthorBookService authorBookService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	/**
	 * @return page for view all authors with their books
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public String getAuthorsWithBooks(Model model){
		
		List<AuthorBook> authorsWithBooks = authorBookService.getAllAuthorsWithBooks();
		
		model.addAttribute("authorsWithBooks", authorsWithBooks);
		
		return "authorsWithBooks";
	}
	
	/**
	 * @return current book with author
	 * */
	@RequestMapping(value = "/author/book/{id}", method = RequestMethod.GET)
	public String getAuthor(Model model,  @PathVariable long id){
		
		AuthorBook authorBook = authorBookService.findById(id);
		
		model.addAttribute("authorBook", authorBook);
		
		return "currentAuthorWithBook";
	}
	
	/**
	 * @return page for add book for author
	 * */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newAuthorBookPage(Model model){
		
		model.addAttribute("authorWithBook", new AuthorBook());
		
		model.addAttribute("books", bookService.getAllBookNames());
		model.addAttribute("authors", authorService.getAllAuthorNames());
		
		return "authorBookPage";
	}
	
	/**
	 * add book for author
	 * */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addAuthorBook(Model model, @ModelAttribute("authorWithBook") AuthorBook authorBook){
		
		try {
			authorBookService.addAuthorWithBooks(authorBook);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to add book for author, please try again later");
			return "message";
		}
		
		return "redirect:../books";
	}
	
	/**
	 * @return page for update book for author or author for book
	 * */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public String updateAuthorBook(Model model, @PathVariable long id){
		
		AuthorBook authorWithBook = authorBookService.findById(id);
		
		model.addAttribute("authorWithBook", authorWithBook);
		model.addAttribute("update", "update");
		
		model.addAttribute("books", bookService.getAllBookNames());
		model.addAttribute("authors", authorService.getAllAuthorNames());
		
		return "authorBookPage";
	}
	
	/**
	 * update book for author or author for book
	 * */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.POST)
	public String updateAuthorBook(Model model, @ModelAttribute("authorWithBook") AuthorBook authorBook, @PathVariable long id){
		
		try {
			authorBookService.updateAuthorWithBooks(authorBook);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to update book for author, please try again later");
			return "message";
		}
		
		return "redirect:..";
	}
	
	/**
	 * delete current book with author
	 * */
	@RequestMapping(value = "/id/{id}/delete", method = RequestMethod.GET)
	public String deleteAuthorBook(Model model, @PathVariable long id){
		
		try {
			authorBookService.deleteAuthorWithBooks(id);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to delete book with author, please try again later");
			return "message";
		}
		
		return "redirect:../..";
	}
}
