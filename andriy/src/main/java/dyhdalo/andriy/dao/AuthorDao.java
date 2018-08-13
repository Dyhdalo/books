package dyhdalo.andriy.dao;

import java.sql.SQLException;
import java.util.List;

import dyhdalo.andriy.entity.Author;

public interface AuthorDao {

	public Long save(Author author) throws SQLException;

	public int delete(Author author)throws SQLException;
	
	public List<Author> getAuthors();
	
	public List<Author> getOlderThan55();
	
	public Author getGreatestAuthor();
	
	public Author findById(Long id);
}
