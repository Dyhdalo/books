package dyhdalo.andriy.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dyhdalo.andriy.entity.Book;

@Repository
public class JPABookDao implements BookDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Long save(Book book) throws SQLException {
		
		if (book.getId() != null) {
            entityManager.merge(book);
        } else {
            entityManager.persist(book);
        }
        return book.getId();
	}

	@Override
	@Transactional
	public int delete(Book book) throws SQLException {
		
		Query query = entityManager.createQuery("DELETE FROM Book b WHERE b.id = :currentId");
		 query.setParameter("currentId", book.getId());
		 
		 int deletedCount = query.executeUpdate();
		 
		 return deletedCount;
	}

	@Override
	public List<Book> getBooks() {
		
		TypedQuery<Book> query = entityManager.createNamedQuery("Book.getAll", Book.class);
		
		return query.getResultList();
	}

	@Override
	public Book findById(Long id) {
		
		return entityManager.find(Book.class, id);
	}

	@Override
	public List<Book> getBooksOfAuthorsWithMoreOneBook() {
		
		Query query = entityManager.createNativeQuery(Book.getBooksOfAuthorsWithMoreOneBook(), Book.class);
		
		@SuppressWarnings("unchecked")
		List<Book> values = query.getResultList();		
		return values;
	}

	@Override
	public List<Object[]> getNumberOfBooksByGenre() {
		
		Query query = entityManager.createNativeQuery(Book.getNumberOfBooksByGenre(), "GenreMapping");
		
		@SuppressWarnings("unchecked")
		List<Object[]> values = query.getResultList();		
		return values;
	}
}
