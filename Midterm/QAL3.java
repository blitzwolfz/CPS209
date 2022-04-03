import java.util.ArrayList;

public class QAL3
{
	public static void main(String[] args)
  {  
     ArrayList<RyStudent> students = new ArrayList<RyStudent>();
     
     students.add(new RyStudent("Jerry", "Seinfeld", "1234"));      
     students.add(new RyStudent("Kosmo", "Kramer", "4567"));    
     students.add(new RyStudent("Elaine", "Benes", "7890"));    
     students.add(new RyStudent("George", "Costanza", "1357"));    
     students.add(new RyStudent("Monica", "Geller", "2468"));    
     students.add(new RyStudent("Chandler", "Bing", "0198"));    
     students.add(new RyStudent("Rachel", "Greene", "8348"));    
     students.add(new RyStudent("Chandler", "Bing", "0188"));   
     
     //  Check if students contains a RyStudent with first name "Chandler",
	 //  last name "Bing", and id: "0198". If so, print the array index  
     //  where it occurs. Hint: make use of the equals method in class RyStudent and its constructor method
     //  Note: there are no getter and setter methods in class RyStudent. You do not need them to write the solution.
     //-----------Start below here. To do: approximate lines of code = 4
     //
     
     for (int i = 0; i < students.size(); i++) {
        if (students.get(i).equals("Chandler", "Bing", "0198")) {
          System.out.println("Index: "+i);
        }
     }
     
     
     //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
     System.out.println("Expected:\nIndex: 5");
  }
}
