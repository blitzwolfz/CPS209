import java.util.*;

/**
   A program that demonstrates the LinkedList class
*/
public class ListTester
{  
   public static void main(String[] args)
   {  
      LinkedList<String> staff = new LinkedList<String>();
      staff.addFirst("Tom");
      staff.addFirst("Romeo");
      staff.addFirst("Harry");
      staff.addFirst("Dave");
     
      
      //Collections.sort(staff);
	
      ListIterator<String> iterator = staff.listIterator();
	  while (iterator.hasNext())
		System.out.println(iterator.next());
	  
	  // Note: can use shortcut
      for (String name: staff)
      {
    	  System.out.println(name);
      }
      
      
      // The symbol | in the comments indicates the list iterator "position"

      iterator = staff.listIterator(); // |DHRT
      String s = iterator.next(); // D|HRT
      System.out.println(s);  // Prints Dave
      s = iterator.next(); // DH|RT
      System.out.println(s); // Prints H (Harry)
      // Add more elements after second element
      
      iterator.add("Juliet"); // DHJ|RT
      iterator.add("Nina"); // DHJN|RT
      iterator.next(); // DHJNR|T
      iterator.remove(); // DHJN|T
      
      // Remove last traversed element 

      
      // iterator.remove(); // If you uncomment this line and rerun, an exception
                            // will be thrown
      
      System.out.println("reset iterator");
      iterator = staff.listIterator(); // |DHJNT
      
      // Print all elements
      while (iterator.hasNext())
      {
    	  String n = iterator.next();
    	  System.out.println(n);
      }
      System.out.println("reverse list");
      LinkedList<String> reversedList = reverse(staff);
      iterator = reversedList.listIterator(); 
      
      // Print all elements
      while (iterator.hasNext())
      {
    	  String n = iterator.next();
    	  System.out.println(n);
      }
      
      
      LinkedList<String> letters   = new LinkedList<String>();

      iterator = letters.listIterator();
      iterator.add("A");
      iterator.add("B");
      iterator.add("C");
      iterator.add("D");
      iterator.add("F");

      iterator = letters.listIterator();
      iterator.next();
      iterator.next();
      iterator.remove();
      iterator.next();
      iterator.add("G");
      iterator.next();
      iterator.add("H");
      iterator.next();
      iterator.previous();
      iterator.remove();
      iterator = letters.listIterator();

      while (iterator.hasNext())
      {
    	  String n = iterator.next();
    	  System.out.println(n);
      }

   }
   
   public static LinkedList<String> reverse(LinkedList<String> employees)
   {
	   ListIterator<String> iterator = employees.listIterator();
	   LinkedList<String>       temp = new LinkedList<String>();

	   while (iterator.hasNext())
	   {
	     String s = iterator.next();
	     temp.addFirst(s);
	   }
	  return temp;
   }
}
