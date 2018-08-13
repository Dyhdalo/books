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

import dyhdalo.andriy.entity.Author;
import dyhdalo.andriy.service.AuthorService;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	/**
	 * @return page for view all authors
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public String getAuthors(Model model){
		
		List<Author> authors = authorService.getAllAuthors();
		
		model.addAttribute("authors", authors);
		
		return "authors";
	}
	
	/**
	 * @return current book
	 * */
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
	public String getAuthor(Model model,  @PathVariable long id){
		
		Author author = authorService.findById(id);
		
		model.addAttribute("author", author);
		
		return "currentAuthor";
	}
	
	/**
	 * @return page for add new author
	 * */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newAuthorPage(Model model){
		
		model.addAttribute("author", new Author());
		
		return "authorPage";
	}
	
	/**
	 * add new author
	 * */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addAuthor(Model model, @ModelAttribute("author") Author author){
		
		try {
			authorService.addAuthor(author);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to add author, please try again later");
			return "message";
		}
		
		return "redirect:../authors";
	}
	
	/**
	 * @return page for update current author
	 * */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public String updateAuthor(Model model, @PathVariable long id){
		
		Author author = authorService.findById(id);
		
		model.addAttribute("author", author);
		model.addAttribute("update", "update");
		
		return "authorPage";
	}
	
	/**
	 * update current author
	 * */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.POST)
	public String updateAuthor(Model model, @ModelAttribute("author") Author author, @PathVariable long id){
		
		try {
			authorService.updateAuthor(author);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to update author, please try again later");
			return "message";
		}
		
		return "redirect:..";
	}
	
	/**
	 * delete current author
	 * */
	@RequestMapping(value = "/id/{id}/delete", method = RequestMethod.GET)
	public String deleteAuthor(Model model, @PathVariable long id){
		
		try {
			authorService.deleteAuthor(id);
		} catch (SQLException e) {
			model.addAttribute("title", "Oooops!");
			model.addAttribute("head", "500 Server Error");
			model.addAttribute(
					"description",
					"Error, enable to delete author, please try again later");
			return "message";
		}
		
		return "redirect:../..";
	}
	
	/**
	 * @return authors which are older 55 years old and sort them by 'born' column
	 * */
	@RequestMapping(value = "/older55", method = RequestMethod.GET)
	public String older55Author(Model model){
		
		List<Author> authorsOlder55 = authorService.getOlderThan55();
		
		model.addAttribute("authors", authorsOlder55);
		
		return "olderAuthors";
	}
	
	/**
	 * @return author which has moset books
	 * */
	@RequestMapping(value = "/greatestAuthor", method = RequestMethod.GET)
	public String greatestAuthor(Model model){
		
		Author author = authorService.getGreatestAuthor();
		
		model.addAttribute("author", author);
		
		return "greatestAuthor";
	}
}
