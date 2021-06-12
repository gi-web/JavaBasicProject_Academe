package test;

import academe.Academe;
import academe.Report;
import academe.Score;
import academe.Student;
import academe.Subject;
import util.Define;

public class TestMain {
	
	
	
	Academe goodAcademe =  Academe.getInstance();
	Subject korean;
	Subject math1;
	Subject music;
	
	Report report = new Report();
	

	
	

	public static void main(String[] args) {
		
		
		TestMain test=new TestMain();
		
		test.createSubject();
		test.createStudent();
		
		
		
		String resultReport=test.report.getReport();//���� ��� ����
		System.out.println(resultReport);
		
		

	}
	public void createSubject() {//�׽�Ʈ���� ����
		korean=new Subject("����", Define.KOREAN, 20000);
		math1 = new Subject("����",Define.MATH, 30000);
		music = new Subject("����",Define.MUSIC, 10000);
		
		goodAcademe.addSubject(korean);
		goodAcademe.addSubject(math1);
		goodAcademe.addSubject(music);
		
		
	}
	public void createStudent() {//�׽�Ʈ�л� ����
		Student student1=new Student(1111,"�̼���", korean);
		Student student2=new Student(2222,"������", math1);
		Student student3=new Student(3333,"������", music);
		Student student4=new Student(4444,"ȫ�浿", korean);
		Student student5=new Student(5555,"�ڹ���", math1);
		Student student6=new Student(6666,"��ҿ�", music);
		
		
		//goodAcademe�� �л��߰�
		goodAcademe.addStudent(student1);
		goodAcademe.addStudent(student2);
		goodAcademe.addStudent(student3);
		goodAcademe.addStudent(student4);
		goodAcademe.addStudent(student5);
		goodAcademe.addStudent(student6);
		
		//���� �����ϴ� �л� ���
		korean.addStudent(student1);
		korean.addStudent(student2);
		korean.addStudent(student3);
		korean.addStudent(student4);
		korean.addStudent(student5);
		korean.addStudent(student6);
		
		
		math1.addStudent(student1);
		math1.addStudent(student2);
		math1.addStudent(student3);
		math1.addStudent(student4);
		math1.addStudent(student5);
		math1.addStudent(student6);
		
		music.addStudent(student1);
		music.addStudent(student2);
		music.addStudent(student3);
		music.addStudent(student4);
		music.addStudent(student5);
		music.addStudent(student6);
		
		addScoreForStudent(student1, korean, 100);
		addScoreForStudent(student1, math1, 90);
		addScoreForStudent(student1, music, 55);
		
		addScoreForStudent(student2, korean, 100);
		addScoreForStudent(student2, math1, 90);
		addScoreForStudent(student2, music, 55);
		
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math1, 90);
		addScoreForStudent(student3, music, 55);
		
		addScoreForStudent(student4, korean, 100);
		addScoreForStudent(student4, math1, 90);
		addScoreForStudent(student4, music, 55);
		
		addScoreForStudent(student5, korean, 100);
		addScoreForStudent(student5, math1, 90);
		addScoreForStudent(student5, music, 55);
		
		addScoreForStudent(student6, korean, 100);
		addScoreForStudent(student6, math1, 90);
		addScoreForStudent(student6, music, 55);
		
		
		}
	public void addScoreForStudent(Student student,Subject subject, int point) {
		Score score1=new Score(student.getStudentId(),subject,point);
		student.addSubjectScore(score1);
		}

}
