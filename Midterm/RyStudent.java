// A class to model a Ryerson Student

// Note: there are no getter and setter methods in class RyStudent. You do not need them to write the solution.
public class RyStudent
{
	private String firstName;
	private String lastName;
	private String id;
	
	public RyStudent(String firstName, String lastName, String id)
	{
		this.firstName = firstName;
		this.lastName  = lastName;
		this.id        = id;
	}
	
   //-----------Start below here. To do: approximate lines of code = 3
   // Write an equals method (i.e. override the equals method inherited from class Object)
	// that compares two RyStudent objects based on first name and last name and id 
   public boolean equals(String f, String l, String i) {
		return (f.equals(this.firstName)) && l.equals(this.lastName) && i.equals(this.id);
   }
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
