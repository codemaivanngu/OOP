package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class main {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    cartMenu(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Main Menu
    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Store Menu
    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // View Store Functionality
    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        int storeChoice;
        do {
            store.displayStoreItems();
            storeMenu();
            storeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (storeChoice) {
                case 1:
                    seeMediaDetails(store, cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (storeChoice != 0);
    }

    // Media Details Menu
    public static void mediaDetailsMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    // See Media Details
    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu();
            int mediaChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (mediaChoice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to the cart.");
                    break;
                case 2:
                    if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                        ((DigitalVideoDisc) media).play();
                    } else {
                        System.out.println("Cannot play this media.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to store menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    // Add Media to Cart
    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to the cart.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    // Play Media
    public static void playMedia(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            ((DigitalVideoDisc) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    // Update Store Functionality
    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("\nUpdate Store:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Enter your choice: ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (updateChoice) {
            case 1:
                addMediaToStore(store, scanner);
                break;
            case 2:
                removeMediaFromStore(store, scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Add Media to Store
    public static void addMediaToStore(Store store, Scanner scanner) {
        System.out.println("\nAdding media to store...");
        // You can replicate similar input collection as addMediaToCart to add media to the store.
    }

    // Remove Media from Store
    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to remove from store: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    // Cart Menu Functionality
    public static void cartMenu(Cart cart, Scanner scanner) {
        int cartChoice;
        do {
            System.out.println("\nOptions:");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            cartChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (cartChoice) {
                case 5:
                    System.out.println("Order placed successfully. The cart is now empty.");
                    cart.clear();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (cartChoice != 0);
    }
}
