import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;


public class ReverseWordsStack 
{
	public static void main(String[] args)
	{
		Stack<String> stack = new Stack<String>();
		Queue<String> q = new LinkedList<String>();
		
		String s = JOptionPane.showInputDialog("Enter a string");	
		 
		Scanner scanner = new Scanner(s);
		
	    while (scanner.hasNext())
		{
	    	//stack.push(scanner.next());
			q.add(scanner.next());
	    }
	    
	    //while (!stack.isEmpty())
	    while (q.size() > 0)
	    {
	    	//System.out.print(stack.pop() + " ");
	    	System.out.print(q.remove() + " ");
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		while (scanner.hasNext())
		{
			stack.push(scanner.next());
		}
		while (stack.size() > 0)
		{
			System.out.print(stack.pop()+ " ");
		}
		*/
	}
}
