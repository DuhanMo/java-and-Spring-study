package ch11;

public class Run {
    public static void main(String[] args) {
        Calc cal = new CompleteCalc();
        System.out.println(cal.add(1, 2));
        System.out.println(cal.times(3, 4));
    }
}
