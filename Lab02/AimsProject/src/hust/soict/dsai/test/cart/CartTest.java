package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Rogger Allers",87,19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas",87,24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation",18.99f);
		cart.addDigitalVideoDisc(dvd3);
		//test the print method
		cart.print();
	}

}
