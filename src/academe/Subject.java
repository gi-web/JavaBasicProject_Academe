package academe;

import java.util.ArrayList;

public class Subject {
	private String subjectName;
	private int subjectId;
	private int gradeType;
	private int price;
	
	private ArrayList<Student> studentList= new ArrayList<Student>();
	
	public Subject(String subjectName, int subjectId,int price) {
		this.subjectName=subjectName;
		this.subjectId=subjectId;
		this.gradeType=gradeType;
		this.price=price;
	}
	
	//수강신청 메소드
	public void addStudent(Student student) {
		studentList.add(student);
	}
	

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
