import java.util.ArrayList;

public class RyCourse
{
	private String code;
	private String name;
	private String professor;
	private ArrayList<Integer> numStudents;
	private ArrayList<String> sections;
	
	public void print()
	{
		System.out.printf("%-6s %-20s Prof: %-10s Sections:", code, name, professor);
		for (int i = 0; i < sections.size(); i++)
		{
			System.out.printf(" %-2s: %-2d", sections.get(i), numStudents.get(i));
		}
		System.out.println();
	}
	
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getProfessor()
	{
		return professor;
	}
	public void setProfessor(String professor)
	{
		this.professor = professor;
	}
	public ArrayList<Integer> getNumStudents()
	{
		return numStudents;
	}
	
	public void setNumStudents(ArrayList<Integer> numStudents)
	{
		this.numStudents = numStudents;
	}
	public ArrayList<String> getSections()
	{
		return sections;
	}
	
	public void setSections(ArrayList<String> sections)
	{
		this.sections = sections;
	}

}
