import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFileChooser;

public class ParensChecker
{
	public static void main(String[] args) throws FileNotFoundException 
	{        
	    String program = "";
	    JFileChooser chooser = new JFileChooser(); 
 	    File file = null; 
 	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
 	        file = chooser.getSelectedFile();
  	    
 	    Scanner in = new Scanner(file);
 	    
  	    while (in.hasNextLine())
        {
          program += in.nextLine();
        }
	    System.out.println(doParenthesesMatch(program));
	}	

	public static boolean doParenthesesMatch(String str) 
	{
		Stack<Character> stack = new Stack<Character>();

		char c;
		for(int i=0; i < str.length(); i++) 
		{
			c = str.charAt(i);

			if	(c == '{') 
			{
				stack.push(c);
			} 
			else if (c == '}')
			{
				if (stack.empty())
					return false;
                else 
                    stack.pop();
			}
        }
        return stack.empty();
	}


}
