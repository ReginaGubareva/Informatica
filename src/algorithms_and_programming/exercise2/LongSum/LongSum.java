package algorithms_and_programming.exercise2.LongSum;

import algorithms_and_programming.FastScanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class LongSum {

    private final static String fileIn = "C:\\Users\\rengu\\IdeaProjects\\Informatica\\src\\algorithms_and_programming\\exercise2\\LongSum\\in.txt";
    private final static String fileOut = "C:\\Users\\rengu\\IdeaProjects\\Informatica\\src\\algorithms_and_programming\\exercise2\\LongSum\\out.txt";

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(new File(fileIn));
        PrintWriter out = new PrintWriter(new File(fileOut));

        String num1 = in.next();
        String num2 = in.next();
        if(num1.length() < num2.length()){
            StringBuilder s1 = new StringBuilder(num1);
            s1.reverse();
            while (s1.length() != num2.length()){
                s1.append('0');
            }
            num1 = s1.reverse().toString();
        }

        if(num2.length() < num1.length()){
            StringBuilder s2 = new StringBuilder(num2);
            s2.reverse();
            while (s2.length() != num1.length()){
                s2.append('0');
            }
            num2 = s2.reverse().toString();
        }

        System.out.println(num1);
        System.out.println(num2);

        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--){
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int n2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        System.out.println(sb.reverse().toString());
        out.close();

    }
}
