package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart, ControllerScreen u) {
        this.store = store;
        this.cart = new Cart();
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);
        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100,50));
        cartButton.setMaximumSize(new Dimension(100,50));
        cartButton.addActionListener(e -> {
            StringBuilder cartContents = new StringBuilder("Cart Contents:\n");
            float totalCost = 0;

            for (Media media : cart.getItemsOrdered()) {
                cartContents.append(media.toString()).append("\n");
                totalCost += media.getCost();
            }
            cartContents.append("\nTotal Cost: ").append(totalCost).append(" $");

            JOptionPane.showMessageDialog(
                null,
                cartContents.toString(),
                "Cart",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        return center;
    }
}
