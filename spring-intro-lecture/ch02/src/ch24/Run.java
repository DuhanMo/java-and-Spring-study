package ch24;

public class Run {
    public static void main(String[] args) {
        Student mo = new Student("모두한");

        mo.addSubject("국어" , 100);
        mo.addSubject("수학" , 100);
        mo.addSubject("영어" , 100);
        System.out.println(mo.toString());

        Student lee =  new Student("이동국");
        lee.addSubject("국어", 80);
        lee.addSubject("수학", 80);
        lee.addSubject("영어", 50);

        mo.showStudentInfo();
        System.out.println("================");
        lee.showStudentInfo();
    }
}
