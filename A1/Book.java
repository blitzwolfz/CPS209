// Name: Samin Qureshi
// Student ID: 501098462

/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

*/
public class Book extends Product 
{
  private String author;
  private String title;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author)
  {
  	 // Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	 // Set category to BOOKS
      super(name, id, price, 100000, Product.Category.BOOKS);
      this.title = title;
      this.author = author;
      this.paperbackStock = paperbackStock;
      this.hardcoverStock = hardcoverStock;
  }
    
  // Check if a valid format  
  @Override
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
  	// if it is one of these, return true, else return false

    return "Paperback".equalsIgnoreCase(productOptions) 
    || "Hardcover".equalsIgnoreCase(productOptions) 
    || "EBook".equalsIgnoreCase(productOptions);
  }
  
  // Override getStockCount() in super class.
  @Override
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.
    if ("Paperback".equalsIgnoreCase(productOptions)) return this.paperbackStock;
    if ("Hardcover".equalsIgnoreCase(productOptions)) return this.hardcoverStock;
    return super.getStockCount(productOptions);
  	// return 1;
	}
  
  @Override
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
    if ("Paperback".equalsIgnoreCase(productOptions)) this.paperbackStock = stockCount;
    if ("Hardcover".equalsIgnoreCase(productOptions)) this.hardcoverStock = stockCount;
    if ("EBook".equalsIgnoreCase(productOptions)) super.setStockCount(stockCount, productOptions);
	}
  
  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  @Override
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.

    if ("Paperback".equalsIgnoreCase(productOptions)) this.paperbackStock--;
    if ("Hardcover".equalsIgnoreCase(productOptions)) this.hardcoverStock--;
    if ("EBook".equalsIgnoreCase(productOptions)) super.reduceStockCount(productOptions);
	}
  /*
   * Print product information in super class and append Book specific information title and author
   */
  @Override
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video
  	super.print();
    System.out.printf(" Book Title: %5s Author: %5s", this.title, this.author);
  }
}
