package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs=0;
	public DigitalVideoDisc(String title) {
		super(nbDigitalVideoDiscs, title, "", 0); 
		nbDigitalVideoDiscs+=1;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(nbDigitalVideoDiscs,title,category,cost);
		nbDigitalVideoDiscs+=1;
		
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(nbDigitalVideoDiscs,title,category,cost,director,0);
		nbDigitalVideoDiscs+=1;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs,title,category,cost,director, length);
		nbDigitalVideoDiscs+=1;
	}
	public void setTitle(String newTitle) {
		// TODO Auto-generated method stub
		super.setTitle(newTitle);
		
	}
	
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + getDirector() + " - " + getLength() + ": " + this.getCost() + " $";
    }
    @Override
    public void play() {
    	if (getLength()>0) {
    		System.out.println("Playing DVD: " + getTitle());
    		System.out.println("DVD length: " + getLength());
    		
    	} else {
    		System.out.println("ERROR: DVD length is 0.");
    	}
    }
    
    
}
