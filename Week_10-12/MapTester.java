import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
   This program tests a map that maps names to colors.
*/
public class MapTester
{
   public static void main(String[] args)
   {      
      Map<String, Color> favoriteColors  = new HashMap<String, Color>();
      
      favoriteColors.put("Juliet", Color.PINK);
      favoriteColors.put("Romeo", Color.GREEN);
      favoriteColors.put("Adam", Color.BLUE);
      favoriteColors.put("Eve", Color.PINK);
      favoriteColors.remove("Juliet");
      favoriteColors.remove("Adam");
      
      Set<String> keySet = favoriteColors.keySet();
      
      Iterator<String>  iterator = keySet.iterator();
      while (iterator.hasNext())
      {
    	  String key = iterator.next();
    	  Color value = favoriteColors.get(key);
    	  System.out.println(key + "->" + value);
      }
   }
}
