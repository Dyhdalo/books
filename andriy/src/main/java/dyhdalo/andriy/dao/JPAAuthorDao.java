package dyhdalo.andriy.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dyhdalo.andriy.entity.Author;

@Repository
public class JPAAuthorDao implements AuthorDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Long save(Author author) throws SQLException {
		
		if (author.getId() != null) {
            entityManager.merge(author);
        } else {
            entityManager.persist(author);
        }
        return author.getId();
	}

	@Override
	@Transactional
	public int delete(Author author) throws SQLException {
		
		Query query = entityManager.createQuery("DELETE FROM Author a WHERE a.id = :currentId");
		 query.setParameter("currentId", author.getId());
		 
		 int deletedCount = query.executeUpdate();
		 
		 return deletedCount;
	}

	@Override
	public List<Author> getAuthors() {
		
		TypedQuery<Author> query = entityManager.createNamedQuery("Author.getAll", Author.class);
		
		return query.getResultList();
	}

	@Override
	public List<Author> getOlderThan55() {
		
		Query query = entityManager.createNativeQuery(Author.getAuthorsOlderThan55(), Author.class);
		
		@SuppressWarnings("unchecked")
		List<Author> values = query.getResultList();		
		return values;
	}

	@Override
	public Author findById(Long id) {
		
		return entityManager.find(Author.class, id);
	}

	@Override
	public Author getGreatestAuthor() {
		
		Query query = entityManager.createNativeQuery(Author.getGreatestAuthor(), Author.class);
		
		try{
			return (Author) query.getSingleResult();
		} catch (NoResultException nre){
			return null;
		}
	}
}
