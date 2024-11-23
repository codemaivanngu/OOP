package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public String addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			return "The disc has been added" ;
		}
		return "The cart is almost full";
	}
	public String addDigitalVideoDisc(DigitalVideoDisc[] discs) {
		if (qtyOrdered + discs.length <= MAX_NUMBERS_ORDERED) {
			for(int i=0;i<discs.length;i++){
				itemsOrdered[qtyOrdered] = discs[i];
				qtyOrdered += 1;
			}
			return "The disc has been added" ;
		}
		return "The cart is almost full";
	}
	public String addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered +2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc1;
			qtyOrdered += 1;
			itemsOrdered[qtyOrdered] = disc2;
			qtyOrdered += 1;
			return "The disc has been added" ;
		}
		return "The cart is almost full";
	}
	
	public String removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int p=-1;
		for (int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i]==disc) {
				p=i;
			}
		}
		if (p==-1) {
			return "The disc is not in the cart";
		}
		for(int i=p;i<qtyOrdered;i++) {
			itemsOrdered[i]=itemsOrdered[i+1];
		}
		qtyOrdered -= 1;
		return "The disc is removed";
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
//            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            totalCost += itemsOrdered[i].getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
}
