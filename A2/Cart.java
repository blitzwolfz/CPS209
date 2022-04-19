import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> items = new ArrayList<CartItem>();
    

    public Cart()
	{
		
	}

    public void addItem(Product prod, String options) {
        this.items.add(new CartItem(prod, options));
    }

    public void removeItem(String id) {
        this.items.removeIf(c -> (c.getProductID().equals(id)));
    }

    public void print() {
        for (CartItem i:items) i.print();
    }

    public ArrayList<CartItem> getItems() {
        ArrayList<CartItem> itemsCopy = new ArrayList<>(items);

        items.clear();

        return itemsCopy;
    }

}
