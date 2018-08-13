package dyhdalo.andriy.dao;

import java.sql.SQLException;
import java.util.List;

import dyhdalo.andriy.entity.Book;

public interface BookDao {

	public Long save(Book book) throws SQLException;

	public int delete(Book book)throws SQLException;
	
	public List<Book> getBooks();
	
	public Book findById(Long id);
	
	public List<Book> getBooksOfAuthorsWithMoreOneBook();
	
	public List<Object[]> getNumberOfBooksByGenre();
}
