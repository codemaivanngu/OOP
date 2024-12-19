package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book() {
		
	}

	public List<String> getAuthors() {
		return authors;
	}
	public Book(int id, String title, String category, float cost) {
		super(id,title,category, cost);
	}
	public Book( String title, String category, float cost) {
		super(-1,title,category, cost);
	}
	public void addAuthor(String authorName) {
	    if (!authors.contains(authorName)) {
	        authors.add(authorName);
	    } else {
	        System.out.println("Author already exists in the list.");
	    }
	}

	public void removeAuthor(String authorName) {
	    if (authors.contains(authorName)) {
	        authors.remove(authorName);
	    } else {
	        System.out.println("Author not found in the list.");
	    }
	}
	@Override
	public String toString() {
	    return "Book - Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + " $, Authors: " + authors;
	}
}
