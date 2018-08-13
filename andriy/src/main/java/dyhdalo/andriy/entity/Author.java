package dyhdalo.andriy.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import dyhdalo.andriy.utils.DataBaseTables;

@Entity
@Table(name = DataBaseTables.AuthorTable.TABLE_NAME)
@NamedQueries({ @NamedQuery(name = "Author.getAll", query = "SELECT a FROM Author a ")
})
public class Author implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DataBaseTables.AuthorTable.ID, nullable = false)
	private Long id;
	
	@Column(name = DataBaseTables.AuthorTable.NAME, nullable = false)
	private String name;
	

	@Column(name = DataBaseTables.AuthorTable.GENDER, nullable = false)
	private String gender;
	

	@Column(name = DataBaseTables.AuthorTable.BORN)
	private Date born;
	
	public Author(){	
	}
	
	public Author(Long id) {
		this.id = id;
	}
	
	public Author(String id) {
		this.id = Long.parseLong(id);
	}

	public Author(String name, String gender, Date born) {
		this.name = name;
		this.gender = gender;
		this.born = born;
	}
	
	public Author(Long id, String name, String gender, Date born) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.born = born;
	}

	public static String getAuthorsOlderThan55(){
		
		String sqlQueryString = "SELECT *"
				+ " FROM authors"
				+ " WHERE NOW() - INTERVAL '55 years' > authors.born"
				+ " ORDER BY authors.born";
		
		return sqlQueryString;
	}
	
	public static String getGreatestAuthor(){
		
		String sqlQueryString = "SELECT *"
				+ " FROM authors"
				+ " WHERE id IN (SELECT author_id"
				+ " FROM author_book"
				+ " GROUP BY author_id"
				+ " ORDER BY count(book_id) DESC LIMIT 1)";
		
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", gender=" + gender + ", born=" + born
				+ "]";
	}
}
