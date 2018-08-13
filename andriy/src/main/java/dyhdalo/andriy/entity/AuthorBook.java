package dyhdalo.andriy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import dyhdalo.andriy.utils.DataBaseTables;

@Entity
@Table(name = DataBaseTables.AuthorBookTable.TABLE_NAME)
@NamedQueries({ @NamedQuery(name = "AuthorBook.getAll", query = "SELECT ab FROM AuthorBook ab ")
})
public class AuthorBook implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DataBaseTables.AuthorBookTable.ID, nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = DataBaseTables.AuthorBookTable.AUTHOR)
	private Author author;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = DataBaseTables.AuthorBookTable.BOOK)
	private Book book;
	
	public AuthorBook(){
	}

	public AuthorBook(Long id) {
		this.id = id;
	}

	public AuthorBook(Author author, Book book) {
		this.author = author;
		this.book = book;
	}

	public AuthorBook(Long id, Author author, Book book) {
		this.id = id;
		this.author = author;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "AuthorBook [author=" + author + ", book=" + book + "]";
	}
	
}
