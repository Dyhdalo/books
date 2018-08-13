package dyhdalo.andriy.service;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dyhdalo.andriy.dao.BookDao;
import dyhdalo.andriy.entity.Book;
import dyhdalo.andriy.entity.BooksByGenre;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getBooks();
	}

	@Override
	public Map<Long, String> getAllBookNames() {
		
		List<Book> books = bookDao.getBooks();
		Map<Long, String> bookNames = new HashMap<Long, String>();
		
		for(Book book: books)
			bookNames.put(book.getId(), book.getName());
		
		return bookNames;
	}
	
	@Override
	public Long addBook(Book book) throws SQLException {
		
		return bookDao.save(book);
	}

	@Override
	public Long updateBook(Book book) throws SQLException {
		
		return bookDao.save(book);
	}

	@Override
	public int deleteBook(Long id) throws SQLException {
		
		Book book = new Book(id);
		
		return bookDao.delete(book);
	}

	@Override
	public Book findById(Long id) {
		
		return bookDao.findById(id);
	}

	@Override
	public List<Book> getBooksOfAuthorsWithMoreOneBook() {
		
		return bookDao.getBooksOfAuthorsWithMoreOneBook();
	}

	@Override
	public List<BooksByGenre> getNumberOfBooksByGenre() {
		
		List<Object[]> queryResult = bookDao.getNumberOfBooksByGenre();
				
		List<BooksByGenre> result = new LinkedList<BooksByGenre>();
		
		for (Object[] row : queryResult){
			
			String genre = (String) row[0];
			BigInteger numberOfBooks = (BigInteger) row[1];
			
			result.add(new BooksByGenre(genre, numberOfBooks));
		}
		
		return result;
	}

}
