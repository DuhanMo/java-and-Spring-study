package ch20;

public class Run {
    public static void main(String[] args) {
        double[] dArr = new double[5];

        dArr[0] = 1.1;
        dArr[1] = 2.1;
        dArr[2] = 3.1;

        double mtotal = 1;
        for(int i = 0; i< dArr.length; i++) {
            mtotal *= dArr[i];
        }

        System.out.println(mtotal);

        char[] alphabets = new char[26];
        char ch = 'A';

        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = ch++;
        }
        for (char alpha: alphabets
             ) {
            System.out.println(alpha);
        }
        System.out.println(alphabets);

    }
}
