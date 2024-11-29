package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Media;

public class DigitalVideoDisc extends Media{
	private static int nbDigitalVideoDiscs=0;
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
		super(nbDigitalVideoDiscs, title, "", 0); 
		nbDigitalVideoDiscs+=1;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(nbDigitalVideoDiscs,title,category,cost);
		nbDigitalVideoDiscs+=1;
		
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(nbDigitalVideoDiscs,title,category,cost);
		nbDigitalVideoDiscs+=1;
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs,title,category,cost);
		nbDigitalVideoDiscs+=1;
		this.director = director;
		this.length = length;
	}
	public void setTitle(String newTitle) {
		// TODO Auto-generated method stub
		super.setTitle(newTitle);
		
	}
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + director + " - " + length + ": " + this.getCost() + " $";
    }
    
    
}
