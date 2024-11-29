package hust.soict.dsai.aims.media;

public class Track implements Playable{
	String title;
	int length;
	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track otherTrack = (Track)obj;
			return this.title.equals(otherTrack.title) && this.length == otherTrack.length;

		}
		return false;
	}
	@Override
	public String toString() {
		return "Track: " + title + " - Length: " + length;
	}
	@Override
	public void play() {
		if (length>0) {
			System.out.println("Playing track: " + title);
			System.out.println("Track length: " + length);
			
		}else {
			System.out.println("ERROR: Track length is 0.");
		}
	}
	
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + length;
        return result;
    }

}
