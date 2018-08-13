package dyhdalo.andriy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dyhdalo.andriy.entity.Book;
import dyhdalo.andriy.entity.BooksByGenre;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public Map<Long, String> getAllBookNames();
	
	public Long addBook(Book book) throws SQLException;
	
	public Long updateBook(Book book) throws SQLException;
	
	public int deleteBook(Long id) throws SQLException;
	
	public Book findById(Long id);
	
	public List<Book> getBooksOfAuthorsWithMoreOneBook();
	
	public List<BooksByGenre> getNumberOfBooksByGenre();
}
