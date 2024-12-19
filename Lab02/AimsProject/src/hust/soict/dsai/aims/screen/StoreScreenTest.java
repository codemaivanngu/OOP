package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.cart.Cart;

public class StoreScreenTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Adding sample media items to the store
        store.addMedia(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f));
        store.addMedia(new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 24.99f));
        store.addMedia(new CompactDisc(1, "Thriller", "Pop", 15.99f, "Michael Jackson", 42, "Michael Jackson"));

        // Launch the Store Screen
//        new StoreScreen(store);
    }
}
