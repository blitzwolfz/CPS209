public class CartItem {
    
    private Product product;
    private String productOptions;

    public CartItem(Product o, String options) {
		this.product = o;
        this.productOptions = options;
	}

    public Product getProduct() {
        return this.product;
    }

    public String getProductID() {
        return this.product.getId();
    }

    public String getProductOptions() {
        return this.productOptions;
    }

    public void print() {
        this.product.print();
    }
}
