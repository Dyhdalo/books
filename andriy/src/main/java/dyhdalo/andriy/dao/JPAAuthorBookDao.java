package dyhdalo.andriy.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dyhdalo.andriy.entity.AuthorBook;

@Repository
public class JPAAuthorBookDao implements AuthorBookDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Long save(AuthorBook author) throws SQLException {
		
		if (author.getId() != null) {
            entityManager.merge(author);
        } else {
            entityManager.persist(author);
        }
        return author.getId();
	}

	@Override
	@Transactional
	public int delete(AuthorBook author) throws SQLException {
		
		Query query = entityManager.createQuery("DELETE FROM AuthorBook ab WHERE ab.id = :currentId");
		 query.setParameter("currentId", author.getId());
		 
		 int deletedCount = query.executeUpdate();
		 
		 return deletedCount;
	}

	@Override
	public List<AuthorBook> getAuthorWithBooks() {
		
		TypedQuery<AuthorBook> query = entityManager.createNamedQuery("AuthorBook.getAll", AuthorBook.class);
		
		return query.getResultList();
	}

	@Override
	public AuthorBook findById(Long id) {
		
		return entityManager.find(AuthorBook.class, id);
	}
}
