package dyhdalo.andriy.utils;

/**
 * Name of all tables and columns of data base
 * */
public class DataBaseTables {

	public static class AuthorTable{
		public static final String TABLE_NAME = "authors";
		public static final String ID = "id";
		public static final String NAME = "name";
		public static final String GENDER = "gender";
		public static final String BORN = "born";
	}
	
	public static class BookTable {
		public static final String TABLE_NAME = "books";
		public static final String ID = "id";
		public static final String NAME = "name";
		public static final String PUBLISHED = "published";
		public static final String GENRE = "genre";
		public static final String RATING = "rating";
	}
	
	public static class AuthorBookTable{
		public static final String TABLE_NAME = "author_book";
		public static final String ID = "id";
		public static final String AUTHOR = "author_id";
		public static final String BOOK = "book_id";
	}
}
