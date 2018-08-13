package dyhdalo.andriy.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Class-Helper for view number off books by genre
 * */
public class BooksByGenre implements Serializable{

	private String genre;
	
	private BigInteger numberOfBooks;

	public BooksByGenre(){
	}
	
	public BooksByGenre(String genre, BigInteger numberOfBooks) {
		this.genre = genre;
		this.numberOfBooks = numberOfBooks;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public BigInteger getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(BigInteger numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	@Override
	public String toString() {
		return "BooksByGenre [genre=" + genre + ", numberOfBooks="
				+ numberOfBooks + "]";
	}
}
