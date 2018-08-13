package dyhdalo.andriy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dyhdalo.andriy.entity.Author;

public interface AuthorService {

	public List<Author> getAllAuthors();
	
	public Map<Long, String> getAllAuthorNames();
	
	public Long addAuthor(Author author) throws SQLException;
	
	public Long updateAuthor(Author author) throws SQLException;
	
	public int deleteAuthor(Long id) throws SQLException;
	
	public Author findById(Long id);
	
	public List<Author> getOlderThan55();
	
	public Author getGreatestAuthor();
}
