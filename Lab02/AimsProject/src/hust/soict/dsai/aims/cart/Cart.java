package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private Media itemsOrdered[] = new Media[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public String addMedia(Media media) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = media;
			qtyOrdered += 1;
			return "The media has been added" ;
		}
		return "The cart is almost full";
	}
	public String addDigitalVideoDisc(Media[] medias) {
		if (qtyOrdered + medias.length <= MAX_NUMBERS_ORDERED) {
			for(int i=0;i<medias.length;i++){
				itemsOrdered[qtyOrdered] = medias[i];
				qtyOrdered += 1;
			}
			return "The media has been added" ;
		}
		return "The cart is almost full";
	}
	public String addDigitalVideoDisc(Media media1, Media media2) {
		if (qtyOrdered +2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = media1;
			qtyOrdered += 1;
			itemsOrdered[qtyOrdered] = media2;
			qtyOrdered += 1;
			return "The media has been added" ;
		}
		return "The cart is almost full";
	}
	
	public String removeDigitalVideoDisc(Media media) {
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
}
