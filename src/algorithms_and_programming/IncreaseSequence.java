package algorithms_and_programming;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class IncreaseSequence {
    static int[] a;
    static int startIndex;
    static int maxLength;

    static void findMaxIncrSubseq() {
        if (a.length==1) {
            startIndex = 0;
            maxLength = 1;
            return;
        }
        int start = startIndex = 0;
        int length = maxLength = 1;
        for (int i=1; i<a.length; i++) {
            if (a[i] > a[i-1]) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = start;
                }
                length = 1;
                start = i;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fstream = new FileInputStream("C:\\Users\\rengu\\IdeaProjects\\Informatica\\src\\algorithms_and_programming\\in.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        strLine = br.readLine();
        int size = Integer.parseInt(strLine);
        a = new int[size];
        int i=0;
        while ((strLine = br.readLine()) != null)   {
            a[i] = Integer.parseInt(strLine);
            i++;
        }
        in.close();
        findMaxIncrSubseq();
        System.out.println("Longest increasing contiguos subsequence starts from " + startIndex + " and is of length " + maxLength);
        System.out.println("Longest increasing contiguos subsequence:");
        for (i=startIndex; i<startIndex+maxLength; i++) {
            System.out.println(a[i]);
        }
    }
}
