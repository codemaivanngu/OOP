// Store.java
package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private int STORE_CAPACITY = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[STORE_CAPACITY];
    private int qtyStore = 0;
    public Store() {
        
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyStore <STORE_CAPACITY) {
        	itemsInStore[qtyStore] = disc;
        	qtyStore+=1;
        	System.out.println("This DVD has been added to the store: " + disc.getTitle());
        }
        else {
        	System.out.println("The store is full. Cannot add " + disc.getTitle());
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
    	for (int i = 0; i < qtyStore; i++)
    	{
    		if (itemsInStore[i].equals(disc)) {
                itemsInStore[i] = itemsInStore[qtyStore-1];
                qtyStore -=1;
                itemsInStore[qtyStore] = null;
                System.out.println("The item has been removed from the store: " + disc.getTitle());
                return;
            }
    	}
    	System.out.println("DVD not found in the store:"+ disc.getTitle());
    }

    public void displayStoreItems() {
        System.out.println("Items in Store:");
        for (int i = 0; i < qtyStore; i++)
        {
        	System.out.println( itemsInStore[i].toString());
        }
    }
}