import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
/**
   Testing the Person class with two Comparators - one for sorting by name and for sorting by age

 */
public class PersonSorter
{
	public static void main(String[] args) 
	{
		Person[] persons = {
				new Person("Elvis", "Goodyear", 56),
				new Person("Stanley", "Clark", 8),
				new Person("Jane", "Graff", 16),
				new Person("Nancy", "Goodyear", 69),
				new Person("Alice", "Goodyear", 100)
		} ;
		System.out.println("Initial Order:");

		for (int i=0; i<4; i++) {
			Person person = persons[i];
			String lastName = person.getLastName();
			String firstName = person.getFirstName();
			int age = person.getAge();
			System.out.println(lastName + ", " + firstName + ". Age:" + age);
		}
		System.out.println();
		System.out.println("Sorted by name (alphabetically):");

		//-----------Start below here. To do: approximate lines of code = 6
		// ToDo create a simple (inner) class that implements the Comparator interface
		// to sort two person objects by name 
		// compare last name alphabetically. If they are equal then compare first names
		// Hint: make use of the class String compareTo() method to compare name strings

		Comparator<Person> a = new PersonSorter().new SortName();

		Arrays.sort(persons, a);
		
		// call Array.sort with two parameters - one passing in the array of persons
		// and one passing in an object of the inner class
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		for (int i=0; i<4; i++) {
			Person person = persons[i];
			String lastName = person.getLastName();
			String firstName = person.getFirstName();
			int age = person.getAge();
			System.out.println(lastName + ", " + firstName + ". Age:" + age);
		}		
		System.out.println("Expected:\nClark, Stanley. Age:8\nGoodyear, Alice. Age:100\nGoodyear, Elvis. Age:56\nGoodyear, Nancy. Age:69");

		System.out.println();
		System.out.println("Sorted by age (youngest to oldest):");

		//-----------Start below here. To do: approximate lines of code = 4
		// ToDo create a simple (inner) class that implements the Comparator interface
		// to sort two person objects by age (youngest to oldest)


		Comparator<Person> e = new PersonSorter().new SortAge();

		Arrays.sort(persons, e);
		
		// call Array.sort with two parameters - one passing in the array of persons
		// and one passing in an object of the inner class
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		for (int i=0; i<4; i++) {
			Person person = persons[i];
			String lastName = person.getLastName();
			String firstName = person.getFirstName();
			int age = person.getAge();
			System.out.println(lastName + ", " + firstName + ". Age:" + age);
		}
		System.out.println("Expected:\nClark, Stanley. Age:8\nGraff, Jane. Age:16\nGoodyear, Elvis. Age:56\nGoodyear, Nancy. Age:69");
	}

	class SortName implements Comparator<Person> {
		public int compare(Person a, Person b)
		{
			return (a.getLastName().equalsIgnoreCase(b.getLastName()) ? a.getFirstName().compareTo(b.getFirstName()) : a.getLastName().compareTo(b.getLastName()));
		}
	}

	class SortAge implements Comparator<Person> {
		public int compare(Person a, Person b)
		{
			return a.getAge() - b.getAge();
		}
	}

}
/**
   This class Person models a person object that has a name and age.
   Notice there is no constructor other than the default one.
   You are setting up the Comparable<Person> interface so that the 
   sorting will be from young to old (ascending).
 */

class Person
{
	private String firstName;
	private String lastName;
	private int age;
	/**
       Initializes firstName, lastName and age
       @param first the first name
       @param last the last name
       @param years the age in years
	 */
	public Person(String first, String last, int years)
	{
		firstName = first ; lastName = last ; age = years ;
	}
	/**
       Accesses the first name
       @return firstName
	 */    
	public String getFirstName() {
		return firstName;
	}
	/**
       Sets the first name
       @param firstName the new first name
	 */    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
       Accesses the last name
       @return lastName
	 */    
	public String getLastName() {
		return lastName;
	}
	/**
       Sets the last name
       @param lastName the new value.
	 */    
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
       Accesses the first age
       @return age
	 */    
	public int getAge() {
		return age;
	}
	/**
       Sets the age
       @param age the new age
	 */    
	public void setAge(int age) {
		this.age = age;
	}
}
