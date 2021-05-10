package ch24;

import java.util.ArrayList;

public class Student {

    private static int serial = 1000;

    private int studentId;
    private String studentName;
    ArrayList<Subject> subjectList;

    public Student(String studentName) {
        serial++;
        studentId = serial;
        this.studentName = studentName;
        subjectList = new ArrayList<Subject>();

    }

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public void addSubject(String name, int score){
        Subject subject = new Subject();
        subject.setSubjectName(name);
        subject.setSubjectScore(score);
        subjectList.add(subject);
    }
    public void showStudentInfo(){
        int total = 0;

        for (Subject sb: subjectList
             ) {
            total += sb.getSubjectScore();
            System.out.println("학생" + studentName + "의 " +sb.getSubjectName()+" 점수는" + sb.getSubjectScore()+"점 입니다.");
        }
        System.out.println("학생" + studentName + "의 총점은 " +total + "점 입니다.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
