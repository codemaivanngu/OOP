package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	public Book() {
		
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public Book(int id, String title, String catetgory, float cost) {
		this.id = id;
		this.title = title;
	    this.category = category;
	    this.cost = cost;
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
}
