package algorithms_and_programming.exercise1;

import java.util.*;

public class IncreaseSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        //Исходная последовательность
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //Массив, в котором будем хранить позиции предыдущего выбранного элемента
        //нужен для того, чтобы восстановить нужную нам подпоследовательность
        int[] d = new int[n];

        //Массив, в котором будем хранить длины максимальной подпоследовательности для
        //каждого элемента исходной последовательности
        int[] prev = new int[n];

//        for (int i=0; i<n; ++i) {
//            d[i] = 1;
//            prev[i] = -1;
//            for (int j=0; j<i; ++j)
//                if (a[j] < a[i])
//                    if (1 + d[j] > d[i]) {
//                        d[i] = 1 + d[j];
//                        prev[i] = j;
//                    }
//        }

        for (int i=0;i<n;i++) {
            int maxLen = 0;
            prev[0] = -1;
            for (int j=i-1;j>=0;j--)
                if (a[j] < a[i] && d[j]>maxLen) {
                    maxLen = d[j];
                    prev[i] = j;
                }
            d[i] = maxLen + 1;
        }

//        for(int i = 0; i < n-1; i++){
//            d[i] = 1;
//            prev[i] = -1;
//            for(int j = 0; j < i - 1; j++) {
//                if (a[j] < a[i] & d[j]+1 > d[i]) {
//                    d[i] = d[j] + 1;
//                    prev[i] = j;
//                }
//            }
//        }

        int pos = 0;
        int length = d[0];
        for(int i = 0; i<n - 1; i++) {
            if(d[i] > length) {
                pos = i;
                length = d[i];
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(pos != -1) {
            answer.add(a[pos]);
            pos = prev[pos];
        }
        Collections.reverse(answer);

        System.out.print("L: ");
        for (int i : d) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("N: ");
        for (int i : prev) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i=0; i<answer.size(); ++i)
            System.out.print(answer.get(i) + " ");
    }
}
