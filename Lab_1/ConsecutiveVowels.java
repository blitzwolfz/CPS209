import java.util.Scanner;
/*
 * This program determines whether a word contains more than 1 vowel in a row
 * If it does, it prints the word 
 * For example, 
 * if the word = "field" then "field" is printed ("ie")
 *             = "queue" then "queue" is printed ("ueue")
 */
public class ConsecutiveVowels 
{
   public static void main(String[] args) 
   {
  	  String  words = "field quick abdicate mood about cattle"; 
      Scanner in = new Scanner(words);
     
      while (in.hasNext())
  	  {
  	  	String word = in.next();
        
        //-----------Start below here. To do: approximate lines of code = 9
        // Use a for loop and go through each character of the strong word 
        // check if the character is one of 'a' 'e' 'i' 'o' 'u' 
        // if it is, record (in a variable) the index where this occurred
  	  	// if another vowel is encountered, check to see if the index is one more
  	  	// if so, print the word. If not, update the index 
        
        
        
          	//Check each letter of word to see if a vowel, 
            // when comparing characters don't forget to use ==  
        	  // Hint: use class String method charAt() to get the next character
        	  // e.g. word.charAt(3) returns a char at position 3
        
        
        
        for(int charIndex = 0; charIndex < word.length(); charIndex++)
        {
           int index = 0;

           if (word.charAt(charIndex) == 'a' || word.charAt(charIndex) == 'e' || word.charAt(charIndex) == 'i' || 
           word.charAt(charIndex) == 'o' || word.charAt(charIndex) == 'u')
           {
             if (word.charAt(charIndex) == 'a' || word.charAt(charIndex) == 'e' || word.charAt(charIndex) == 'i' || 
             word.charAt(charIndex) == 'o' || word.charAt(charIndex) == 'u'
             && word.charAt(index) == 'a' || word.charAt(index) == 'e' || word.charAt(index) == 'i' || 
             word.charAt(index) == 'o' || word.charAt(index) == 'u' && charIndex-1 == index)
             {
                System.out.println(word);
                System.out.println(charIndex);
                System.out.println(index);
                break;
             }

             else
             {
                index = charIndex;
             }
           }
        }    
        
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
  	  }
      System.out.println("Expected:\nfield\nquick\nmood\nabout");
   }
}