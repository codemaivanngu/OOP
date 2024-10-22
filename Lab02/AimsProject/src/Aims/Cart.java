package Aims;

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
}
