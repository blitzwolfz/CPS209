/*
 * Tests the GradesMap class
 */
public class GradesMapTester
{
	public static void main(String[] args)
	{
		GradesMap map = new GradesMap();
		
		String[] letterGrades = {"A", "B", "A", "D", "F", "A", "B", "C", "C", "A", "B", "D", "C", "B"};
		String[] names = {"Cate", "Russell", "Hugh", "Heath", "Nicole", "Toni", "Guy", "Rose", "Naomi", "Chris", "Liam","Margot", "Sam"};
		
		for (int i = 0; i < names.length; i++)
		{
			map.add(letterGrades[i], names[i]);
		}
		map.printGradeDistribution();
		System.out.println("Expected:\nA: 4 - Cate, Hugh, Toni, Chris\nB: 3 - Russell, Guy, Liam\nC: 3 - Rose, Naomi, Sam\n" 
				                        + "D: 2 - Heath, Margot\nF: 1 - Nicole");
	}
}
