package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.ObservableListBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private Media itemsOrdered[] = new Media[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public String addMedia(Media media) {
		for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(media)) {
                return "This media is already in the cart.";
            }
        }
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = media;
			qtyOrdered += 1;
			return "The media has been added" ;
		}
		return "The cart is almost full";
	}
	public String addMedia(Media[] medias) {
		if (qtyOrdered + medias.length <= MAX_NUMBERS_ORDERED) {
			for(int i=0;i<medias.length;i++){
				itemsOrdered[qtyOrdered] = medias[i];
				qtyOrdered += 1;
			}
			return "The media has been added" ;
		}
		return "The cart is almost full";
	}
	public String addMedia(Media media1, Media media2) {
		if (qtyOrdered +2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = media1;
			qtyOrdered += 1;
			itemsOrdered[qtyOrdered] = media2;
			qtyOrdered += 1;
			return "The media has been added" ;
		}
		return "The cart is almost full";
	}
	
	public String removeMedia(Media media) {
		int p=-1;
		for (int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i]==media) {
				p=i;
			}
		}
		if (p==-1) {
			return "The media is not in the cart";
		}
		for(int i=p;i<qtyOrdered;i++) {
			itemsOrdered[i]=itemsOrdered[i+1];
		}
		qtyOrdered -= 1;
		return "The media has been removed";
	}
	public void removeMedia(int id) {
		int p=-1;
		for (int i=id;i<qtyOrdered;i++) {
			itemsOrdered[i]=itemsOrdered[i+1];
			}
		qtyOrdered-=1;
		
	}
	public void clear() {
		qtyOrdered=0;
		
	}
	public float totalCost() {
		float res=0;
		for (int i=0;i<qtyOrdered;i++)res+=itemsOrdered[i].getCost();
		return res;
	}
	public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items: ");
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            totalCost += itemsOrdered[i].getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
	public void sortByTitle() {
        Arrays.sort(itemsOrdered, 0, qtyOrdered, Comparator.comparing(Media::getTitle));
        System.out.println("Items have been sorted by title.");
    }
	public void sortByCost() {
        Arrays.sort(itemsOrdered, 0, qtyOrdered, Comparator.comparing(Media::getCost).reversed());
        System.out.println("Items have been sorted by cost in descending order.");
    }
	// Method to search for media by title
    public Media searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                return itemsOrdered[i];
            }
        }
        return null; // If not found
    }

    // Method to search for media by ID
    public Media searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        return null; // If not found
    }
    public ArrayList<Media> getItemsOrdered() {
        ArrayList<Media> mediaArray = new ArrayList<>(qtyOrdered);
        for (int i = 0; i < qtyOrdered; i++) {
            mediaArray.add(itemsOrdered[i]);
        }
        return mediaArray;
    }
    public ObservableList<Media> getItemsOrdered(int u) {
        ObservableList<Media> mediaArray = FXCollections.observableArrayList();
        for (int i = 0; i < qtyOrdered; i++) {
            mediaArray.add(itemsOrdered[i]);
        }
        return mediaArray;
    }
}
