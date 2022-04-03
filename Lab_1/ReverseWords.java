import java.util.Scanner;

// Use a scanner and read each word from a string that contains multiple words. 
// Print each word in reverse order 
// then reverse the reversed word to get back the original word, print it
// For Example: "hello my name is Inigo Montoya" would result in
// olleH
// Hello
// ym
// my
// eman
// name
// si
// is
// oginI
// Inigo
// ayotnoM
// Montoya

public class ReverseWords
{
   public static void main(String[] args)
   {
     String words = "A quick brown fox jumps over the lazy alligator"; 
     Scanner in = new Scanner(words);
      
     while (in.hasNext())
     {
    	 String word = in.next();
     	 
    	  //-----------Start below here. To do: approximate lines of code = 4
    	  // 1. You must use a for loop and the charAt() method of class String to 
    	  // store the reversed word into a string and then print the reversed word
    	  // Hint: count down rather than up in the for loop (i.e. start at the end of the word)
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) 
        {
          reverse = reverse + word.charAt(i);
        }
    	  
    	  System.out.println(reverse);
    	  
    	  
    	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
         //-----------Start below here. To do: approximate lines of code = 4
         // 2. now repeat the reversing loop but use the reversed word from above as input
         // print the word - it should now be back to its original order
         
         String reverseReverse = "";

         for (int i = 0; i < reverse.length(); i++) 
         {
            reverseReverse = reverseReverse + word.charAt(i);
         }
         
         System.out.println(reverseReverse);
         
         
         //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
     }
     System.out.println("Expected:\nA\nA\nkciuq\nquick\nnworb\nbrown\nxof\nfox\nspmuj\njumps\nrevo\nover\neht\nthe\nyzal\nlazy\nrotagilla\nalligator");
   }
}
