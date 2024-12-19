// Store.java
package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private int STORE_CAPACITY = 100;
    private Media[] itemsInStore = new Media[STORE_CAPACITY];
    private int qtyStore = 0;
    public Store() {
        
    }

    public void addMedia(Media media) {
        if (qtyStore <STORE_CAPACITY) {
        	itemsInStore[qtyStore] = media;
        	qtyStore+=1;
        	System.out.println("This media has been added to the store: " + media.getTitle());
        }
        else {
        	System.out.println("The store is full. Cannot add " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
    	for (int i = 0; i < qtyStore; i++)
    	{
    		if (itemsInStore[i].equals(media)) {
                itemsInStore[i] = itemsInStore[qtyStore-1];
                qtyStore -=1;
                itemsInStore[qtyStore] = null;
                System.out.println("The item has been removed from the store: " + media.getTitle());
                return;
            }
    	}
    	System.out.println("Media not found in the store:"+ media.getTitle());
    }

    public void displayStoreItems() {
        System.out.println("Items in Store:");
        for (int i = 0; i < qtyStore; i++)
        {
        	System.out.println( itemsInStore[i].toString());
        }
    }
 // Method to search for a media item by title
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ObservableList<Media> getItemsInStore() {
        ObservableList<Media> mediaInStore = FXCollections.observableArrayList();
        for (int i = 0; i < qtyStore; i++) {
            mediaInStore.add(itemsInStore[i]);
        }
        return mediaInStore;
    }
}