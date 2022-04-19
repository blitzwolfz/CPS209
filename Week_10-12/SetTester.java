import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;


/**
   
*/
public class SetTester
{
   public static void main(String[] args)
   {
	   
      Set<Integer> primeNumbers = new HashSet<Integer>();
      String nPrimes = JOptionPane.showInputDialog("Enter a number");
      
      
      int n = Integer.parseInt(nPrimes);
      int sqrtN = (int) Math.sqrt(n);
      
      for (int i = 2; i <= n; i++)
      {
    	  primeNumbers.add(i);
      }
      for (int j = 2; j <= sqrtN; j++)
      {
    	if ((j % 2) == 0 && j != 2) continue;
    	
        for (int i = 2*j; i < n; i +=j)
        {
    	  primeNumbers.remove(i);
        }
      }
      System.out.print(primeNumbers); 
      
      for (Integer i : primeNumbers)
      {
    	System.out.print(i + " "); 
      }
   }
}



