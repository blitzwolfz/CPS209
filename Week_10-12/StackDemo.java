import java.util.Stack;

/**
   This program simulates an undo stack. Note that operations
   must be undone in the opposite order in which they are first
   issued.
*/
public class StackDemo
{
   public static void main(String[] args)
   {
      Stack<String> commands = new Stack<String>();
      commands.push("Insert 'Hello'");
      System.out.println(commands.peek() + " ");
      commands.push("Insert ','");
      System.out.println(commands.peek() + " ");
      commands.push("Insert ' '");
      System.out.println(commands.peek() + " ");
      commands.push("Insert 'World'");
      System.out.println(commands.peek() + " ");
      commands.push("Insert '?'");
      System.out.println(commands.peek() + " ");
      commands.push("Delete '?'");
      System.out.println(commands.peek() + " ");
      commands.push("Insert '!'");
      System.out.println(commands.peek() + " ");

      System.out.println("!!Undo last 4 commands");
      
      // Now we undo the last four commands
      for (int i = 1; i <= 4; i++)
      {
         String command = commands.pop();
         System.out.println("Undo " + command);
      }
   }
}
