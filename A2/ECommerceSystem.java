import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem 
{
	Map<String, Object>  products = new TreeMap<>();
	ArrayList<Customer> customers = new ArrayList<Customer>();	
	Map<String, Integer> stats = new TreeMap<>();

	ArrayList<ProductOrder> orders   			= new ArrayList<ProductOrder>();
	ArrayList<ProductOrder> shippedOrders = new ArrayList<ProductOrder>();

	// These variables are used to generate order numbers, customer id's, product id's 
	int orderNumber = 500;
	int customerId = 900;
	int productId = 700;

	// General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
	String errMsg = null;

	// Random number generator
	Random random = new Random();

	public ECommerceSystem()
	{
		// NOTE: do not modify or add to these objects!! - the TAs will use for testing
		// If you do the class Shoes bonus, you may add shoe products

		// Create some products
		String id = generateProductId();
		products.put(id, new Product("Acer Laptop", id, 989.0, 99, Product.Category.COMPUTERS));

		id = generateProductId();
		products.put(id, new Product("Apex Desk", id, 1378.0, 12, Product.Category.FURNITURE));

		id = generateProductId();
		products.put(id, new Book("Book", id, 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney", 2021));
		
		id = generateProductId();
		products.put(id, new Product("DadBod Jeans", id, 24.0, 50, Product.Category.CLOTHING));

		id = generateProductId();
		products.put(id, new Product("Polo High Socks", id, 5.0, 199, Product.Category.CLOTHING));

		id = generateProductId();
		products.put(id, new Product("Tightie Whities", id, 15.0, 99, Product.Category.CLOTHING));

		id = generateProductId();
		products.put(id, new Book("Book", id, 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast", 1997));

		id = generateProductId();
		products.put(id, new Book("Book", id, 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive", 1963));

		id = generateProductId();
		products.put(id, new Book("Book", id, 45.0, 4, 2, "How to Teach Programming", "T. McInerney", 2001));

		id = generateProductId();
		products.put(id, new Product("Rock Hammer", id, 10.0, 22, Product.Category.GENERAL));

		id = generateProductId();
		products.put(id, new Book("Book", id, 45.0, 4, 2, "Ahm Gonna Make You Learn More", "T. McInerney", 2022));

		id = generateProductId();
		int[][] stockCounts = {{4, 2}, {3, 5}, {1, 4,}, {2, 3}, {4, 2}};
		products.put(id, new Shoes("Prada", id, 595.0, stockCounts));

		// try (Scanner in = new Scanner(new File("products.txt"))) {
		// 	while (in.hasNextLine()) {
		// 		String w = in.nextLine();
		// 		// System.out.println(w);

		// 		if (w.equals("BOOKS")) {
		// 			String name = in.next();
		// 			Double price = in.nextDouble();
		// 			int paperbackStock = in.nextInt();
		// 			int hardcoverStock = in.nextInt();
		// 			String title = in.next(":");
		// 			String author = in.next(":");
		// 			String year = in.next("\n");

		// 			this.products.put(new Book(name, generateProductId(), price, paperbackStock, hardcoverStock, title, author, Integer.parseInt(year)));
		// 		}

		// 		else if (w.equals("SHOES")) {
		// 			String name = in.next();
		// 			Double price = in.nextDouble();
		// 			int[][] stockCounts = {};
		// 			this.products.put(new Shoes(name, generateProductId(), price, stockCounts));
		// 		}

		// 		else if (w.equals("GENERAL") || w.equals("CLOTHING") 
		// 		|| w.equals("FURNITURE") || w.equals("COMPUTERS")) {
		// 			String name = in.next();
		// 			in.next();
		// 			Double price = in.nextDouble();
		// 			int stock = in.nextInt();
		// 			this.products.put(new Product(name, generateProductId(), price, stock, Product.Category.valueOf(w)));
		// 		}
		// 	}
		// } catch (FileNotFoundException e) {
		// 	// TODO Auto-generated catch block
		// 	e.getMessage();
		// }

		for (String keys: products.keySet()) {
			stats.put(keys, 0);
		}

		// Create some customers
		customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
		customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
		customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
		customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
	}

	private String generateOrderNumber()
	{
		return "" + orderNumber++;
	}

	private String generateCustomerId()
	{
		return "" + customerId++;
	}

	private String generateProductId()
	{
		return "" + productId++;
	}

	public String getErrorMessage()
	{
		return errMsg;
	}

	public void printAllProducts()
	{
		for (String s:products.keySet()) {
			((Product) products.get(s)).print();
		}
	}

	public void printAllBooks()
	{
		for (String s:products.keySet()) {
			Product p = ((Product) products.get(s));
			if (p.getCategory() == Product.Category.BOOKS)
				p.print();
		}
	}

	public ArrayList<Book> booksByAuthor(String author)
	{
		ArrayList<Book> books = new ArrayList<Book>();
		for (String s:products.keySet()) {
			Product p = ((Product) products.get(s));
			if (p.getCategory() == Product.Category.BOOKS) {
				Book book = (Book) p;
				if (book.getAuthor().equals(author))
					books.add(book);
			}
		}
		return books;
	}

	public void printAllOrders()
	{
		for (ProductOrder o : orders)
			o.print();
	}

	public void printAllShippedOrders()
	{
		for (ProductOrder o : shippedOrders)
			o.print();
	}

	public void printCustomers()
	{
		for (Customer c : customers)
			c.print();
	}
	/*
	 * Given a customer id, print all the current orders and shipped orders for them (if any)
	 */
	public void printOrderHistory(String customerId)
	{
		// Make sure customer exists
		int index = customers.indexOf(new Customer(customerId));
		if (index == -1)
		{
			throw new UnknownCustomerException("Customer " + customerId + " Not Found");
		}	
		System.out.println("Current Orders of Customer " + customerId);
		for (ProductOrder order: orders)
		{
			if (order.getCustomer().getId().equals(customerId))
				order.print();
		}
		System.out.println("\nShipped Orders of Customer " + customerId);
		for (ProductOrder order: shippedOrders)
		{
			if (order.getCustomer().getId().equals(customerId))
				order.print();
		}
	}

	public String orderProduct(String productId, String customerId, String productOptions)
	{
		// Get customer
		int index = customers.indexOf(new Customer(customerId));
		if (index == -1)
		{
			throw new UnknownCustomerException("Customer " + customerId + " Not Found");
		}
		Customer customer = customers.get(index);

		// Get product 
		Product index2 = (Product) products.get(productId);
		if (index2 == null)
		{
			throw new UnknownProductException("Product " + productId + " Not Found");
		}
		Product product = (Product) products.get(productId);

		// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
		if (!product.validOptions(productOptions))
		{
			throw new InvalidProductOptionsException("Product " + product.getName() + " ProductId " + productId + " Invalid Options: " + productOptions);
		}
		// Is it in stock?
		if (product.getStockCount(productOptions) == 0)
		{
			throw new ProductOutOfStockException("Product " + product.getName() + " ProductId " + productId + " Out of Stock");
		}
		// Create a ProductOrder
		ProductOrder order = new ProductOrder(generateOrderNumber(), product, customer, productOptions);
		product.reduceStockCount(productOptions);

		// Add to orders and return
		orders.add(order);

		int i = stats.get(productId);
		stats.put(productId, i++);

		return order.getOrderNumber();
	}

	/*
	 * Create a new Customer object and add it to the list of customers
	 */

	public void createCustomer(String name, String address)
	{
		// Check to ensure name is valid
		if (name == null || name.equals(""))
		{
			throw new InvalidCustomerNameException("Invalid Customer Name " + name);
		}
		// Check to ensure address is valid
		if (address == null || address.equals(""))
		{
			throw new InvalidCustomerAddressException("Invalid Customer Address " + address);
		}
		Customer customer = new Customer(generateCustomerId(), name, address);
		customers.add(customer);
	}

	public ProductOrder shipOrder(String orderNumber)
	{
		// Check if order number exists
		int index = orders.indexOf(new ProductOrder(orderNumber,null,null,""));
		if (index == -1)
		{
			throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");
		}
		ProductOrder order = orders.get(index);
		orders.remove(index);
		shippedOrders.add(order);
		return order;
	}

	/*
	 * Cancel a specific order based on order number
	 */
	public void cancelOrder(String orderNumber)
	{
		// Check if order number exists
		int index = orders.indexOf(new ProductOrder(orderNumber,null,null,""));
		if (index == -1)
		{
			throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");
		}
		// ProductOrder order = orders.get(index);
		orders.remove(index);
	}

	// Sort products by increasing price
	public void printByPrice()
	{
		for (String s:products.keySet()) {
			Product p = ((Product) products.get(s));
			p.print();
		}
	}

	private class PriceComparator implements Comparator<Product>
	{
		public int compare(Product a, Product b)
		{
			if (a.getPrice() > b.getPrice()) return 1;
			if (a.getPrice() < b.getPrice()) return -1;	
			return 0;
		}
	}

	// Sort products alphabetically by product name
	public void printByName()
	{
		for (String s:products.keySet()) {
			Product p = ((Product) products.get(s));
			p.print();
		}
	}

	private class NameComparator implements Comparator<Product>
	{
		public int compare(Product a, Product b)
		{
			return a.getName().compareTo(b.getName());
		}
	}

	// Sort products alphabetically by product name
	public void sortCustomersByName()
	{
		Collections.sort(customers);
	}

	public void orderCart(String customerId) {
		int index = customers.indexOf(new Customer(customerId));

		if (index == -1)
		{
			throw new UnknownCustomerException("Customer " + customerId + " Not Found");
		}

		Customer c = customers.get(index);

		ArrayList<CartItem> items = c.getCart().getItems();

		for (CartItem i: items) {
			ProductOrder o = new ProductOrder(generateOrderNumber(), i.getProduct(), c, i.getProductOptions());
			orders.add(o);
		}
	}

	public void printCart(String customerId) {
		int index = customers.indexOf(new Customer(customerId));

		if (index == -1)
		{
			throw new UnknownCustomerException("Customer " + customerId + " Not Found");
		}

		Customer c = customers.get(index);
		c.getCart().print();
	}

	public void addToCart(String productId, String customerId, String options) {
		int index = customers.indexOf(new Customer(customerId));

		if (index == -1)
		{
			throw new UnknownCustomerException("Customer " + customerId + " Not Found");
		}

		Product index2 = (Product) products.get((productId));

		if (index2 == null)
		{
			throw new UnknownProductException("Product " + customerId + " Not Found");
		}

		Customer c = customers.get(index);
		Product prod = (Product) products.get(productId);
		c.getCart().addItem(prod, options);
	}

	public void removeFromCart(String productId, String customerId) {
		int index = customers.indexOf(new Customer(customerId));

		if (index == -1)
		{
			throw new UnknownCustomerException("Customer " + customerId + " Not Found");
		}

		Customer c = customers.get(index);
		c.getCart().removeItem(productId);
	}

	public void stats() {
		for(String s: stats.keySet()) {
			System.out.println("Product: "+products.get(s)+" Amount: "+stats.get(s));
		}
	}
}

class UnknownCustomerException extends RuntimeException {
      // Parameterless Constructor
      public UnknownCustomerException() {}

      // Constructor that accepts a message
      public UnknownCustomerException(String message) {
         super(message);
      }
}

class UnknownProductException extends RuntimeException {
	// Parameterless Constructor
	public UnknownProductException() {}

	// Constructor that accepts a message
	public UnknownProductException(String message) {
	   super(message);
	}
}

class InvalidProductOptionsException extends RuntimeException {
	// Parameterless Constructor
	public InvalidProductOptionsException() {}

	// Constructor that accepts a message
	public InvalidProductOptionsException(String message) {
	   super(message);
	}
}

class ProductOutOfStockException extends RuntimeException {
	// Parameterless Constructor
	public ProductOutOfStockException() {}

	// Constructor that accepts a message
	public ProductOutOfStockException(String message) {
	   super(message);
	}
}

class InvalidCustomerNameException extends RuntimeException {
	// Parameterless Constructor
	public InvalidCustomerNameException() {}

	// Constructor that accepts a message
	public InvalidCustomerNameException(String message) {
	   super(message);
	}
}

class InvalidCustomerAddressException extends RuntimeException {
	// Parameterless Constructor
	public InvalidCustomerAddressException() {}

	// Constructor that accepts a message
	public InvalidCustomerAddressException(String message) {
	   super(message);
	}
}

class InvalidOrderNumberException extends RuntimeException {
	// Parameterless Constructor
	public InvalidOrderNumberException() {}

	// Constructor that accepts a message
	public InvalidOrderNumberException(String message) {
	   super(message);
	}
}