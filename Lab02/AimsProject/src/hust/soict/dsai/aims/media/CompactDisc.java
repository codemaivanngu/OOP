package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	String artist;
	ArrayList<Track> tracks;
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title, String category, float cost, String directory, int length) {
		super(id, title, category, cost, directory, length);
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(int id, String title, String category, float cost, String directory, int length, String artist) {
		super(id, title, category, cost, directory, length);
		// TODO Auto-generated constructor stub
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	public int getLength() {
		int totalLength = 0;
		for(Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	@Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - Length: " + getLength() + ": " + getCost() + " $";
	}
	@Override 
	public void play() {
		System.out.println("Playing CD: " + getTitle() + " - Artist: " + artist + " - Length: " + getLength());
		for (Track track : tracks) {
			track.play();
		}
	}
	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("The track has been added to the CD: " + track.getTitle());
        }
    }


}
