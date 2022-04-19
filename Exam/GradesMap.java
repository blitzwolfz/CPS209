import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
 * 
 * This class contains a map that maps a string key representing letter grades ("A", "B", "C", "D", "F") to
 * a value that is an array list of strings (i.e. the value is not just a single string). 
 * Each string in the array list represents a student's name
 * 
 * For example, if students "Ali", "John", "Harriet" all scored a grade of "A", then the map would map the
 * key "A" to an array list where element 0 in the list is "Ali", element 1 is "John" and element 2 is "Harriet"
 * 
 * In other words, with this map we can keep track of the distribution of grades as well as the individual students
 * who achieved a specific grade
 */
public class GradesMap
{
	//-----------Start below here. To do: approximate lines of code = 1
	// Declare a map called grades that maps a String representing a letter grade ("A", "B", "C", "D", "F")
	// to a value that is an ArrayList of Strings. The array list of strings holds all the students who 
	// achieved that grade
	Map<String, ArrayList<String>> grades;
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
	public GradesMap()
	{
		//-----------Start below here. To do: approximate lines of code = 1
		// create an empty tree map and assign to grades
		this.grades = new TreeMap<String, ArrayList<String>>();
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	/*
	 * Establishes a mapping between the given grade to the name
	 */
	public void add(String grade, String name)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		// map the grade to an array list and then add the name to that list
		// Hint: if this is the first mapping for the grade, create an empty array list,
		// add the name to it then create the mapping from the grade key to the array list in the tree map
		
		if (this.grades.containsKey(grade)) {
			ArrayList<String> list = this.grades.get(grade);

			list.add(name);

			this.grades.put(grade, list);
		}
		
		else {
			ArrayList<String> list = new ArrayList<String>();

			list.add(name);

			this.grades.put(grade, list);
		}
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	/*
	 * Prints the grade distribution
	 */
	public void printGradeDistribution()
	{
		//-----------Start below here. To do: approximate lines of code = 10
		// Prints all the keys and associated lists 
		// Each line that is printed should print the grade followed by ": " followed by the size of the
		// array list for that key, followed by " - " followed by a each of the names in the list separated by a ", "
		// Ensure the last name in a list has no following ", "
		
		
		for (String key: this.grades.keySet()) {
			System.out
			.println(key + ": " + this.grades.get(key).size() + " - " + String.join(", ", this.grades.get(key)));
		}
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}
