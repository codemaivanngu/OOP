package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private String director;
	int length;
	
	public Disc() {
		// TODO Auto-generated constructor stub
	}

	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Disc(int id, String title, String category, float cost, String directory, int length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
}
