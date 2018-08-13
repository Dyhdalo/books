package dyhdalo.andriy.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dyhdalo.andriy.dao.AuthorBookDao;
import dyhdalo.andriy.entity.AuthorBook;

@Service
public class AuthorBookServiceImpl implements AuthorBookService{

	@Autowired
	private AuthorBookDao authorBookDao;
	
	@Override
	public List<AuthorBook> getAllAuthorsWithBooks() {
		
		return authorBookDao.getAuthorWithBooks();
	}

	@Override
	public Long addAuthorWithBooks(AuthorBook authorBook) throws SQLException {
		
		return authorBookDao.save(authorBook);
	}

	@Override
	public Long updateAuthorWithBooks(AuthorBook authorBook)
			throws SQLException {
		
		return authorBookDao.save(authorBook);
	}

	@Override
	public int deleteAuthorWithBooks(Long id) throws SQLException {
		
		AuthorBook ab = new AuthorBook(id);
		
		return authorBookDao.delete(ab);
	}

	@Override
	public AuthorBook findById(Long id) {
		
		return authorBookDao.findById(id);
	}

}
