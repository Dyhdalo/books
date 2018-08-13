package dyhdalo.andriy.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import dyhdalo.andriy.utils.DataBaseTables;

@Entity
@Table(name = DataBaseTables.BookTable.TABLE_NAME)
@NamedQueries({ @NamedQuery(name = "Book.getAll", query = "SELECT b FROM Book b ")
})
@SqlResultSetMapping(name = "GenreMapping", columns={
		@ColumnResult(name="genre"),
		@ColumnResult(name="numberOfBooks")
})
public class Book implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DataBaseTables.BookTable.ID, nullable = false)
	private Long id;
	
	@Column(name = DataBaseTables.BookTable.NAME, nullable = false)
	private String name;
	
	@Column(name = DataBaseTables.BookTable.PUBLISHED)
	private Date published;
	
	@Column(name = DataBaseTables.BookTable.GENRE, nullable = false)
	private String genre;
	
	@Column(name = DataBaseTables.BookTable.RATING, nullable = false)
	private char rating;
	
	public Book(){
	}

	public Book(Long id) {
		this.id = id;
	}
	
	public Book(String id) {
		this.id = Long.parseLong(id);
	}

	public Book(String name, Date published, String genre, char rating) {
		this.name = name;
		this.published = published;
		this.genre = genre;
		this.rating = rating;
	}

	public Book(Long id, String name, Date published, String genre, char rating) {
		this.id = id;
		this.name = name;
		this.published = published;
		this.genre = genre;
		this.rating = rating;
	}
	
	public static String getBooksOfAuthorsWithMoreOneBook(){
		
		String sqlQueryString = "SELECT *"
				+ " FROM books"
				+ " WHERE id IN (SELECT books.id"
				+ " FROM (authors a INNER JOIN author_book on a.id=author_book.author_id)"
				+ " INNER JOIN books ON books.id=author_book.book_id"
				+ " WHERE (SELECT count(author_book.id)"
				+ " FROM author_book"
				+ " WHERE a.id = author_book.author_id) > 1)";
		
		return sqlQueryString;
	}
	
	public static String getNumberOfBooksByGenre(){
		
		String sqlQueryString = "SELECT genre, count(id) AS numberOfBooks"
				+ " FROM books"
				+ " GROUP BY genre";
		
		return sqlQueryString;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public char getRating() {
		return rating;
	}

	public void setRating(char rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", published=" + published + ", genre="
				+ genre + ", rating=" + rating + "]";
	}
}
