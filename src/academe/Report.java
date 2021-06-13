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
	public static final String TITLE=" 수강생 보고서 \t\t\n";
	public static final String HEADER="이름  :  학번  : 필수과목  :   점수   :    수강료 \n";
	public static final String LINE = "_________________________________________________\n";
	public static final String LINE2 ="=================================================\n";
	
	DecimalFormat df1 = new DecimalFormat("#,##0");
	
	
	private StringBuffer buffer = new StringBuffer();
	int num, sumPoint, totalPrice;//과목별 학생수, 점수합계,수강료합계
	public String getReport() {
		ArrayList<Subject> subjectList=academe.getSubjectList();
		
		for (Subject subject : subjectList) {
			num=0;//과목별 학생수 초기화
			sumPoint=0;//과목별 점수 합계 초기화
			totalPrice=0;//과목별 수강금액 합계 초기화
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
			if(score.getScoresubject().getSubjectId()==subject.getSubjectId()) {//학생의 과목과 점수과목에 일치하고
				String grade;
				
				
				if(score.getScoresubject().getSubjectId()==majorSubjectId)//필수과목인 경우
				grade=gradeEvaluation[Define.SAB_TYPE].getGrade(score.point);
			else                             //일반과목인 경우
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
		buffer.append("총수강학생수:"+num+","+"점수합계:"+sumPoint+","+"평균:"+sumPoint/num+
				","+"총수강료:"+df1.format(totalPrice));
		buffer.append("\n");
		buffer.append(LINE2);
		buffer.append("\n");
		
		
	}
}
