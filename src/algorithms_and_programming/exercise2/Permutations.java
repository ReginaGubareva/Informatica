package algorithms_and_programming.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Permutations {

    public static String str;
    public static char[] curPermutation;
    public static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        int n = str.length();
        char[] a = str.toCharArray();
        char[] currentRes = new char[n];
        boolean[] used = new boolean[n];
        curPermutation = new char[n];

//        rec(0);
//        procedureWork(n, a);
    }

//    public static void procedureWork(int n, char[] a){
//        if(n == 1){
//            System.out.println(new String(a));
//        } else {
//            for(int i = 0; i < n-1; i++){
//                procedureWork(n-1, a);
//                if(n%2 == 0){
//                    swap(a, i, n-1);
//                } else {
//                    swap(a, 0, n-1);
//                }
//            }
//            procedureWork(n-1, a);
//        }
//    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

//    public static void procedure(int current, int n, boolean[] used, char[] res){
//        if(current == n){
//            System.out.println(new String(res));
//        }
//            for(int i = 0; i < n; i++){
//                if(!used[i]){
//                    res[i] = str.charAt(i);
//                    used[i] = true;
//                    procedure(current+1, n, used, res);
//                    used[i] = false;
//                }
//            }
//    }
}
