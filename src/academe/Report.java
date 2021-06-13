package academe;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

import grad.BasicEvaluation;
import grad.GradeEvaluation;
import grad.MajorEvaluation;
import util.Define;

public class Report {
	Academe academe =  Academe.getInstance();
	public static final String TITLE=" ������ ���� \t\t\n";
	public static final String HEADER="�̸�  :  �й�  : �ʼ�����  :   ����   :    ������ \n";
	public static final String LINE = "_________________________________________________\n";
	public static final String LINE2 ="=================================================\n";
	
	DecimalFormat df1 = new DecimalFormat("#,##0");
	
	
	private StringBuffer buffer = new StringBuffer();
	int num, sumPoint, totalPrice;//���� �л���, �����հ�,�������հ�
	public String getReport() {
		ArrayList<Subject> subjectList=academe.getSubjectList();
		
		for (Subject subject : subjectList) {
			num=0;//���� �л��� �ʱ�ȭ
			sumPoint=0;//���� ���� �հ� �ʱ�ȭ
			totalPrice=0;//���� �����ݾ� �հ� �ʱ�ȭ
			makeHeader(subject);
			num = makeBody(subject);
			makeFooter();
			
			
		}
		return buffer.toString();
		
	}
		
	public void makeHeader(Subject subject) {
		buffer.append(Report.LINE);
		buffer.append("\t\t" + subject.getSubjectName());
		buffer.append(Report.TITLE);
		buffer.append(Report.HEADER);
		buffer.append(Report.LINE);
	}

	public int makeBody(Subject subject) {
		ArrayList<Student> studentList=subject.getStudentList();
		int point=0;
		
		for(int i=0; i<studentList.size();i++) {
			Student student=studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append(" :  ");
			buffer.append(student.getStudentId());
			buffer.append(" : ");
			buffer.append(student.getStudentSubject().getSubjectName());
			buffer.append(" : ");
			point= getScoreGrade(student, subject);
			sumPoint += point;
			buffer.append(" : ");
			buffer.append(df1.format(subject.getPrice()));
			
			totalPrice += subject.getPrice();
			buffer.append("\n");
			buffer.append(LINE);
						
		}
		return studentList.size();
		
	}
	
	public int getScoreGrade(Student student, Subject subject) {
		ArrayList<Score> scoreList=student.getScoreList();
		int majorSubjectId=student.getStudentSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation= {new BasicEvaluation(), new MajorEvaluation()};
		int point=0;
		
		for(int i=0; i<scoreList.size(); i++) {
			Score score=scoreList.get(i);
			if(score.getScoresubject().getSubjectId()==subject.getSubjectId()) {//�л��� ����� �������� ��ġ�ϰ�
				String grade;
				
				
				if(score.getScoresubject().getSubjectId()==majorSubjectId)//�ʼ������� ���
				grade=gradeEvaluation[Define.SAB_TYPE].getGrade(score.point);
			else                             //�Ϲݰ����� ���
				grade=gradeEvaluation[Define.AB_TYPE].getGrade(score.point);
				
			buffer.append(score.getPoint());
			buffer.append(" : ");
			buffer.append(grade);
			point = score.getPoint();
			}
		}
		return point;
	}
	public void makeFooter() {
		buffer.append("�Ѽ����л���:"+num+","+"�����հ�:"+sumPoint+","+"���:"+sumPoint/num+
				","+"�Ѽ�����:"+df1.format(totalPrice));
		buffer.append("\n");
		buffer.append(LINE2);
		buffer.append("\n");
		
		
	}
}
