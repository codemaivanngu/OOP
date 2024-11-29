package hust.soict.dsai.aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class main {
	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Rogger Allers",87,19.95f);
		anOrder.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas",87,24.95f);
		anOrder.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation",18.99f);
		anOrder.addMedia(dvd3);
		// print all cost of the items in the cart
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeMedia(dvd2);
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
//		System.out.print("number of movie is: ");
//		System.out.println(anOrder.());
		Media dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 89, 19.95f);
        Media book = new Book(2, "Effective Java", "Programming", 45.00f);
        Media cd = new CompactDisc(3, "Thriller", "Pop", 15.00f, "Quincy Jones", 42, "Michael Jackson");
        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        // Iterate over the collection and print each media item
        System.out.println("--- Media List ---");
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
        System.out.println("\n--- Items in Cart Before Sorting ---");
        anOrder.print();

        // Sort items by title and print
        anOrder.sortByTitle();
        System.out.println("\n--- Items in Cart Sorted by Title ---");
        anOrder.print();

        // Sort items by cost and print
        anOrder.sortByCost();
        System.out.println("\n--- Items in Cart Sorted by Cost (Descending) ---");
        anOrder.print();
        
	}
	
}
