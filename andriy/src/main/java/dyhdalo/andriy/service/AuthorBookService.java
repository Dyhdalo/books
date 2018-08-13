package dyhdalo.andriy.service;

import java.sql.SQLException;
import java.util.List;

import dyhdalo.andriy.entity.AuthorBook;

public interface AuthorBookService {

	public List<AuthorBook> getAllAuthorsWithBooks();
	
	public Long addAuthorWithBooks(AuthorBook authorBook) throws SQLException;
	
	public Long updateAuthorWithBooks(AuthorBook authorBook) throws SQLException;
	
	public int deleteAuthorWithBooks(Long id) throws SQLException;
	
	public AuthorBook findById(Long id);
}
