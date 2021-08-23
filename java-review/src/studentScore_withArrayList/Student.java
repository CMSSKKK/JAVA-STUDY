package studentScore_withArrayList;

import java.util.ArrayList;

public class Student {
	
	privateㄴ int studentNum;
	private String studentName;
	private ArrayList<Subject> subs;	
	
	Student() {}
	
	Student(int studentNum, String studentName) {
		this.studentNum = studentNum;
		this.studentName = studentName;
		
		subs = new ArrayList<>();
		
	}

	
	public void addSubject(String subjectName, int subjectScore) { 
		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		subject.setSubjectScore(subjectScore);
		subs.add(subject);
		
	}
	
	public void showStudentInfo() {
		int total = 0;
		
		for(Subject s : subs) {
			
			total += s.getSubjectScore();
			System.out.println("학생 " + studentName + "의 " + s.getSubjectName() + " 과목 성적은 " + 
			        s.getSubjectScore() + "입니다.");
		}
			
		System.out.println("학생 " + studentName + "의 총점은 " + total + "입니다.");
	}

}
