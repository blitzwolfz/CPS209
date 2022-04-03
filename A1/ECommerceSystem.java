// Name: Samin Qureshi
// Student ID: 501098462

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
    	products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
    	products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
    	products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
    	
    	// Create some customers. Notice how generateCustomerId() method is used
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
    	for (Product p : products)
    		p.print();
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
      for (Product prod:products) {
        if (prod.getCategory() == Product.Category.BOOKS) {
          prod.print();
        }
      }
    }
    
    // Print all current orders
    public void printAllOrders()
    {
      for (ProductOrder order: orders) {
        order.print();
      }
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
      for (ProductOrder order: shippedOrders) {
        order.print();
      }
    }
    
    // Print all customers
    public void printCustomers()
    {
    	for (Customer cust:customers) {
        System.out.printf("Name: %-20s ID: %-4s Address: %s %n", cust.getName(), cust.getId(), cust.getShippingAddress());
      }
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
      Customer cust = null;
      for (Customer c: customers) {
        if (c.getId().equalsIgnoreCase(customerId)) cust = c;
      }
      
      if (cust == null) {
        this.errMsg = "Customer " + customerId + " Not Found";
        return false;
      }
    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
    	
      for (ProductOrder c: orders) {
        if (c.getCustomer().getId().equals(customerId)) 
          // System.out.printf("%nOrder # %s Customer ID: %s Product ID: %s Options: %s", 
          // c.getOrderNumber(), c.getCustomer().getId(), c.getProduct().getId(), c.getProduct().getName());
          c.print();
      }

    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here

      for (ProductOrder c: shippedOrders) {
        if (c.getCustomer().getId().equals(customerId)) 
          c.print();
      }
    	
    	return true;
    }
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
      
      Customer cust = null;
      for (Customer c: customers) {
        if (c.getId().equalsIgnoreCase(customerId)) cust = c;
      }
      
      if (cust == null) {
        this.errMsg = "Customer " + customerId + " Not Found";
        return null;
      }
    	
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 

      Product prod = null;
      
      for (Product p: products) {
        if (p.getId().equalsIgnoreCase(productId)) prod = p;
      }
      
      if (prod == null) {
        this.errMsg = "Product " + productId + " Not Found";
        return null;
      }
    	
    	
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    	
      if (!prod.validOptions(productOptions)) {
        this.errMsg = "Product " + prod.getName() + " ProductID " + prod.getId() + " Invalid Options: " + productOptions;
        return null;
      }
    	
      // Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
    	
      if (prod.getStockCount(productOptions) == 0) {
        this.errMsg = "Product " + prod.getName() + " ProductID " + prod.getId() + " Out Of Stock";
        return null;
      }
      

      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
      
      ProductOrder ord = new ProductOrder(generateOrderNumber(), prod, cust, productOptions);
      this.orders.add(ord);
    	    	
    	return ord.getOrderNumber();
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public boolean createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter

    	if(name == null || name.trim().isEmpty()) {
        this.errMsg = "Invalid Customer Name";
        return false;
      }

      if(address == null || address.trim().isEmpty()) {
        this.errMsg = "Invalid Customer Address";
        return false;
      }

      this.customers.add(new Customer(generateCustomerId(), name, address));
    	// Create a Customer object and add to array list
    	return true;
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
      ProductOrder ord = null;

      for (int i = 0; i < this.orders.size(); i++) {
        if (this.orders.get(i).getOrderNumber().equals(orderNumber)) {
          ord = this.orders.get(i);
          this.orders.remove(i);
          break;
        }
      }

      if (ord == null) {
        this.errMsg = "Order " + orderNumber + "Not Found";
        return null;
      }

      this.shippedOrders.add(ord);

      return ord;

    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false

      boolean exists = false;

      for (int i = 0; i < this.orders.size(); i++) {
        if (orders.get(i).getOrderNumber().equals(orderNumber)) {
          exists = !exists;
          this.orders.remove(i);
          break;
        }
      }

      if(!exists) {
        this.errMsg = "Order " + orderNumber + " Not Found";
        return false;
      }
    	
    	return true;
    }
    
    // Sort products by increasing price
    public void sortByPrice()
    {
  	  products.sort((s1, s2) -> (int)s1.getPrice() - (int)s2.getPrice());
    }
    
    
    // Sort products alphabetically by product name
    public void sortByName() {
      Collections.sort(products, new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
          // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
          return p1.getName().compareTo(p2.getName());
        }
      });
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName() {
      Collections.sort(customers, new Comparator<Customer>() {
        @Override
        public int compare(Customer p1, Customer p2) {
          // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
          return p1.getName().compareTo(p2.getName());
        }
      });
    }
}
