// Name: Samin Qureshi
// Student ID: 501098462

import java.util.Arrays;

/* A book IS A product that has additional information - size, colour
The format is specified as a specific "stock type" in get/set/reduce stockCount methods.
*/

public class Shoes extends Product{    
    // Stock related information NOTE: inherited stockCount variable is used for total amount of Black shoes
    int[] brownShoes;
    int[] blackShoes;
    final String[] sizes = {"six", "seven", "eight", "nine", "ten"};
    
    public Shoes(String name, String id, double price, 
    int blackSix, int blackSeven, int blackEight, int blackNine, int blackTen,
    int brownSix, int brownSeven, int brownEight, int brownNine, int brownTen)
    {
        // Arrays.stream(this.blackShoes).sum()
        super(name, id, price, blackSix+blackSeven+blackEight+blackNine+blackTen, Product.Category.SHOES);
        this.blackShoes = new int[]{blackSix, blackSeven, blackEight, blackNine, blackTen};
        this.blackShoes = new int[]{brownSix, brownSeven, brownEight, brownNine, brownTen};
    }
      
    // Check if a valid format  
    @Override
    public boolean validOptions(String productOptions)
    {
        // check productOptions for sizes and "Black" or "Brown"
        // if it is one of these, return true, else return false

  
      return Arrays.asList(sizes).contains(productOptions.split(" ")[0])
      || "black".equalsIgnoreCase(productOptions.split(" ")[1]) 
      || "brown".equalsIgnoreCase(productOptions.split(" ")[1]);
    }
    
    // Override getStockCount() in super class.
    @Override
    public int getStockCount(String productOptions)
      {
        // Use the productOptions to check for (and return) the number of stock for "Paperback" etc
        // Use the variables paperbackStock and hardcoverStock at the top. 
        // For "EBook", use the inherited stockCount variable.
        if ("brown".equalsIgnoreCase(productOptions.split(" ")[1])) {
            switch (productOptions.split(" ")[0]) {
                case "7": return this.brownShoes[1];
                
                case "8": return this.brownShoes[2];
                
                case "9": return this.brownShoes[3];
                
                case "10": return this.brownShoes[4];
                
                default: return this.brownShoes[0];
            }
        }

        else {
            switch (productOptions.split(" ")[0]) {
                case "7": return this.blackShoes[1];
                
                case "8": return this.blackShoes[2];
                
                case "9": return this.blackShoes[3];
                
                case "10": return this.blackShoes[4];
                
                default: return this.blackShoes[0];
            }
        }
      }
    
    @Override
    public void setStockCount(int stockCount, String productOptions)
      {
      // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
         // Use the variables paperbackStock and hardcoverStock at the top. 
         // For "EBook", set the inherited stockCount variable.
        if ("brown".equalsIgnoreCase(productOptions.split(" ")[1])) {
            switch (productOptions.split(" ")[0]) {
                case "7": this.brownShoes[1] = stockCount; break;
                
                case "8": this.brownShoes[2] = stockCount; break;
                
                case "9": this.brownShoes[3] = stockCount; break;
                
                case "10": this.brownShoes[4] = stockCount; break;
                
                default: this.brownShoes[0] = stockCount; break;
            }
        }

        if ("black".equalsIgnoreCase(productOptions.split(" ")[1])) {
            switch (productOptions.split(" ")[0]) {
                case "7": this.blackShoes[1] = stockCount; break;
                
                case "8": this.blackShoes[2] = stockCount; break;
                
                case "9": this.blackShoes[3] = stockCount; break;
                
                case "10": this.blackShoes[4] = stockCount; break;
                
                default: this.blackShoes[0] = stockCount; break;
            }
        }
      }
    
    /*
     * When a shoe is ordered, reduce the stock count for the specific stock type
     */
    @Override
    public void reduceStockCount(String productOptions)
      {
        // Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
         // Use the variables paperbackStock and hardcoverStock at the top. 
         // For "EBook", set the inherited stockCount variable.
        if ("brown".equalsIgnoreCase(productOptions.split(" ")[1])) {
            switch (productOptions.split(" ")[0]) {
                case "7": this.brownShoes[1]--; break;
                
                case "8": this.brownShoes[2]--; break;
                
                case "9": this.brownShoes[3]--; break;
                
                case "10": this.brownShoes[4]--; break;
                
                default: this.brownShoes[0]--; break;
            }
        }

        if ("black".equalsIgnoreCase(productOptions.split(" ")[1])) {
            switch (productOptions.split(" ")[0]) {
                case "7": this.blackShoes[1]--; break;
                
                case "8": this.blackShoes[2]--; break;
                
                case "9": this.blackShoes[3]--; break;
                
                case "10": this.blackShoes[4]--; break;
                
                default: this.blackShoes[0]--; break;
            }
        }
      }
    /*
     * Print product information in super class and append Book specific information title and author
     */
    @Override
    public void print()
    {
        super.print();
    }
}
