package academe;

import java.util.ArrayList;

public class Academe {
	
	private static Academe instance=new Academe();
	
	private static String ACADEMEL_NAME = "Good Academe";
	private ArrayList<Student> sudentList = new ArrayList<Student>();
	private ArrayList<Subject> subjectList=new ArrayList<Subject>();
	
	private Academe() {}
	
	public static Academe getInstance() {
		if(instance == null)
			instance = new Academe();
		return instance;
	}
	
	public void addStudent(Student student) {
		sudentList.add(student);
	}
	public void addSubject(Subject subject) {
		subjectList.add(subject);
		
		
	}
	
	public ArrayList<Student> getSudentList() {
		return sudentList;
	}
	public void setSudentList(ArrayList<Student> sudentList) {
		this.sudentList = sudentList;
	}
	public ArrayList<Subject> getSubjectList() {
				
		return subjectList;
	}
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
	
	
}
