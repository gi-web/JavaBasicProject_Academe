package academe;

import java.util.ArrayList;

import test.TestMain;

public class Student {
	private int studentId;
	private String studentName;
	private Subject studentSubject;
	
	private ArrayList<Score> scoreList = new ArrayList<Score>();
	
	public Student(int studentId, String studentName, Subject subject ) {
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentSubject=subject;//필수과목
	}
	
	

	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}
	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(Subject studentSubject) {
		this.studentSubject = studentSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	
	
}
