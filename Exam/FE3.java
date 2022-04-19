import java.io.File;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Reads a text file containing information about courses taught at Ryerson. 
// The first line of the file contains an integer number representing the number of course "records" stored
// in the file. A course record has the following format (demonstrated with an example):

//CPS209
//Computer Science II
//T. McInerney
//01;02;03;04;05;11;12
//32;34;37;36;38;35;38 


// That is, each record consists of 5 lines. Line 1: course number string Line 2: course name
// Line 3: professor name
// Line 4: a 2-character section number where each section is separated by ";". 
// These are the sections the professor is teaching
// Line 5: for each section, an integer representing the number of students, each number is separated by ";" 
// 
// The expected output is as follows:
// CPS209 Computer Science II  Prof: T. McInerney Sections: 01: 32 02: 34 03: 37 04: 36 05: 38 11: 35 12: 38
// CPS209 Computer Science II  Prof: R. Valenzano Sections: 06: 32 07: 41 08: 36 09: 32 10: 31 13: 27
// CPS511 Computer Graphics    Prof: T. McInerney Sections: 01: 119
// CPS643 Virtual Reality      Prof: T. McInerney Sections: 01: 10 02: 9  03: 17



public class FE3
{
	public static void main(String[] args)
	{
		ArrayList<RyCourse> courses = null;

		try
		{
			courses = loadCoursesFile();
			for (RyCourse course: courses)
				course.print();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("No file found " + e);  
		}
		catch (IOException exception)        
		{
			System.out.println("Input/output error " + exception); 
		}
		catch (NumberFormatException exception)
		{         
			System.out.println("Invalid Number" + exception);
		} 

		System.out.print("EXPECTED:\n");
		System.out.println("CPS209 Computer Science II  Prof: T. McInerney Sections: 01: 32 02: 34 03: 37 04: 36 05: 38 11: 35 12: 38\n"
				+ "CPS209 Computer Science II  Prof: R. Valenzano Sections: 06: 32 07: 41 08: 36 09: 32 10: 31 13: 27\n"
				+ "CPS511 Computer Graphics    Prof: T. McInerney Sections: 01: 119\n"
				+ "CPS643 Virtual Reality      Prof: T. McInerney Sections: 01: 10 02: 9  03: 17");
	}

	// Load the information for all courses from the courses.txt file 
	// into an array list of RyCourse objects. Return a reference to the array list.
	// This method should not catch any IO Exceptions. Modify the method signature line accordingly
    //-----------Start below here. To do: approximate lines of code = 1
    // the method should be called loadCoursesFile() and is static. It should return an
	// ArrayList of RyCourse objects
    public static ArrayList<RyCourse> loadCoursesFile() throws FileNotFoundException, IOException
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	{
		ArrayList<RyCourse> courses = new ArrayList<RyCourse>();
		Scanner in = new Scanner(new File("courses.txt"));
		int numCourses;

		//-----------Start below here. To do: approximate lines of code = 4
		// Read the first line of the file and convert to an integer and store in numCourses.
		// This represents the number of course records in the courses.txt file
		// Call the method readNextCourse() numCourses times (hand in the reference to the scanner)
		// Add each returned RyCourse object to the array list
		numCourses = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numCourses; i++) {
			courses.add(readNextCourse(in));
		}
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		return courses;
	}

	// Use a Scanner to read one RyCourse "record" from a file and create and return a RyCourse object
	// A RyCourse record takes up 5 lines. See the top of this file for the exact record format. 
	// This method should not catch any IO Exceptions. Modify the method signature line accordingly
	//-----------Start below here. To do: approximate lines of code = 1
	// public static RyCourse readNextCourse(Scanner sc)
	public static RyCourse readNextCourse(Scanner sc) throws IOException
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	{  
		//-----------Start below here. To do: approximate lines of code = 24
		//

		String code = sc.nextLine().trim();

		String name = sc.nextLine().trim();

		String prof = sc.nextLine().trim();

		String[] list = sc.nextLine().trim().replace(";", "-").split("-");
		ArrayList<String> sections = new ArrayList<String>();
		for (int i = 0; i < list.length; i++) {
			sections.add(list[i]);
		}
		
		String[] num = sc.nextLine().trim().replace(";", "-").split("-");		
		ArrayList<Integer> numS = new ArrayList<Integer>();

		for (int i = 0; i < num.length; i++) {
			numS.add(Integer.parseInt(num[i]));
		}


		RyCourse n = new RyCourse();

		n.setCode(code.trim());
		n.setName(name.trim());
		n.setProfessor(prof.trim());
		n.setSections(sections);
		n.setNumStudents(numS);

		return n;
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}

