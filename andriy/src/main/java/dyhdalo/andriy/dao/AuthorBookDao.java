package dyhdalo.andriy.dao;

import java.sql.SQLException;
import java.util.List;

import dyhdalo.andriy.entity.AuthorBook;

public interface AuthorBookDao {

	public Long save(AuthorBook author) throws SQLException;

	public int delete(AuthorBook author)throws SQLException;
	
	public List<AuthorBook> getAuthorWithBooks();
	
	public AuthorBook findById(Long id);
}
