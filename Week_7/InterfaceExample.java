import java.util.ArrayList;
import java.util.Collections;

// The "Interface5" class.
public class InterfaceExample
{
    public static void main (String[] args)
    {
	Student s1 = new Student ("Joe", 11, 3.5);
	Student s2 = new Student ("Bob", 12, 3.7);
    ArrayList s = new ArrayList();
    s.add(s1);
    s.add(s2);
    Collections.sort(s);
	System.out.println ("Compare to Returns : " + s1.compareTo (s2));
	int result = s1.compareTo (s2);

	if (result < 0)
	    System.out.println (s1.getName () + " comes before " + s2.getName ());
	else if (result > 0)
	    System.out.println (s2.getName () + " comes before " + s1.getName ());
	else
	    System.out.println (s1.getName () + " is equal to " + s2.getName ());
    } // main method
} // Interface5 class

class Student //implements Comparable
{
    private String name;
    private int grade;
    private double gpa;

    public Student (String n, int gr, double g)
    {
	name = n;
	grade = gr;
	gpa = g;
    }


    public String getName () {return name;}
    public int getGrade () {return grade;}
    public double getGPA () {return gpa;}

    public int compareTo (Object temp)
    {
	Student other = (Student) temp;

	if (getGrade () > other.getGrade ())
	{
	    return 1;
	}
	else if (getGrade () < other.getGrade ())
	{
	    return -1;
	}
	else 
	    return 0;
    }

}

