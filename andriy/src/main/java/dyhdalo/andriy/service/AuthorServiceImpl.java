package dyhdalo.andriy.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dyhdalo.andriy.dao.AuthorDao;
import dyhdalo.andriy.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public List<Author> getAllAuthors() {
		
		return authorDao.getAuthors();
	}

	@Override
	public Map<Long, String> getAllAuthorNames() {
		
		List<Author> authors = authorDao.getAuthors();
		Map<Long, String> authorNames = new HashMap<Long, String>();
		
		for(Author author: authors)
			authorNames.put(author.getId(), author.getName());
		
		return authorNames;
	}
	
	@Override
	public Long addAuthor(Author author) throws SQLException {
		
		return authorDao.save(author);
	}

	@Override
	public Long updateAuthor(Author author) throws SQLException {
		
		return authorDao.save(author);
	}

	@Override
	public int deleteAuthor(Long id) throws SQLException {
		
		Author author = new Author(id);
		
		return authorDao.delete(author);
	}

	@Override
	public Author findById(Long id) {
		
		return authorDao.findById(id);
	}

	@Override
	public List<Author> getOlderThan55() {
		
		return authorDao.getOlderThan55();
	}

	@Override
	public Author getGreatestAuthor() {
		
		return authorDao.getGreatestAuthor();
	}

}
