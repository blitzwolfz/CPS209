import java.util.ArrayList;

/** Represents a person and their list of friends
 */
public class Person
{
    private String name;
    private ArrayList<Person> friends;
        
    /** 
     * Initializes name and friends variables
     */
    public Person(String nm)
    {
    	  //-----------Start below here. To do: approximate lines of code = 2
    	  // initialize instance variable name to nm, initialize friends to an empty array list
    	  name = nm;
          friends = new ArrayList<Person>();    	  
    	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /** Retrieves the name of the Person.
     * @return a string containing the person's name
     */
    public String getName()
    {
        return name;
    }
    
    /** Adds a person to the list of friends of this person.
     * @param friend the Person to be added to the friend list
     */
    public void addFriend(Person friend)
    {
    	  //-----------Start below here. To do: approximate lines of code = 1
    	  // add Person friend to the friends array list 
    	  friends.add(friend);
    	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /** Removes a friend from the list of friends of this person.
     * @param friend the Person to be removed from the friends list
     */
    public void delFriend(Person friend)
    {
    	  //-----------Start below here. To do: approximate lines of code = 1
    	  // removes the friend from the friends list. 
    	  friends.remove(friend);
    	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /** 
     * Returns the array list of Person representing the friends
     * 
     */
    public ArrayList<Person> getFriends()
    {
        return friends;
    }
    /*
     * Searches the friends list of this person and the friends list of the other person
     * to see if they have friends in common.   
     * @return a string containing the names of common friends where the names are separated by " ". 
     * Ensure there is no space character after the last friend name
     * return the empty string "" if there are no friends in common
     */
    public String friendsInCommon(Person other)
    {
    	//-----------Start below here. To do: approximate lines of code = 10
    	// Hint: friends in common should not contain this person name or other person name 
    	
    	String s = "";

        for (Person f:friends) {
            if (other.friends.contains(f)) {
                s += f.name.strip() + " ";
            }
        }

        return s.strip();
    	//Hint: remove any space characters at the end of the string. Make sure the string is not "" before removing
    	
    	
    	
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
}
