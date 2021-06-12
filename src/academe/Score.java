package academe;

public class Score {
	int studentId;
	Subject scoresubject;
	int point;
	
	
	public Score(int studentId, Subject subject, int point ) {
		this.studentId=studentId;
		this.scoresubject=subject;
		this.point=point;
	}
	
	public String toString() {
		return "ÇÐ¹ø:"+studentId+","+scoresubject.getSubjectName()+":"
		+point+","+scoresubject.getPrice();
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Subject getScoresubject() {
		return scoresubject;
	}
	public void setScoresubject(Subject scoresubject) {
		this.scoresubject = scoresubject;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	

}
