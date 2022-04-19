import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.*;

public class StudentGradeManager 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
      Scanner input = new Scanner(System.in);
	  Map<String,String> studentGrades = new TreeMap<String,String>();
		  
	  while (input.hasNext())
	  {
	    String command = input.next();
		if (command.equals("Q")) break;
		
		else if (command.equals("A"))
		{
			String name = input.next();
			String grade = input.next();
			studentGrades.put(name,grade);
		}
		else if (command.equals("R"))
		{
		   String name = input.next();
		   studentGrades.remove(name);
    	}
		else if (command.equals("M"))
		{
		   String name = input.next();
		   String grade = input.next();
		   studentGrades.put(name,grade);
    	}
		else if (command.equals("P"))
		{
			Set<String> keys = studentGrades.keySet();
            Iterator<String> keyI = keys.iterator();
            
            while (keyI.hasNext())
            {
            	String name = keyI.next();
               	System.out.println(name + ": " + studentGrades.get(name));
            }
            
		}
	  }
	}
}
