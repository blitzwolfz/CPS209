import java.util.ArrayList;


public class ArrayListEquals
{
	public static void main(String[] args)
	{
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("Canada");
		countries.add("Australia");
		countries.add("Finland");
		countries.add("United States");
		
		ArrayList<String> otherCountries = new ArrayList<String>();
		otherCountries.add("Canada");
		otherCountries.add("Australia");
		otherCountries.add("Finland");
		otherCountries.add("United States");
		
		
		// We can loop through the arraylist (as long as they are the same size)
		// and see if they contain the same country names
		if (countries.size() != otherCountries.size())
			System.out.println("countries and otherCountries are not equal");
		
		for (int i = 0; i < countries.size(); i++)
		{
			String s1 = countries.get(i);
			String s2 = otherCountries.get(i);
			if (!s1.equals(s2))
			{
				System.out.println("countries and otherCountries are not equal");
				break;
			}
		}
		System.out.println("countries and other countries are equal");
		
		
		// OR!! Look at this, we can just have java go through the 
		// arraylist objects one by one and automatically call the equals
		// method of class String and compare the string in position 0 of 
		// countries against the string in position 0 of otherCountries,
		// then compare the string in position 1 of countries and otherCountries
		// and so on. We can do this with a single line of code!!!!
		if (countries.equals(otherCountries))
			System.out.println("countries and other countries are equal");
		else
			System.out.println("countries and other countries are not equal");
	}
}
