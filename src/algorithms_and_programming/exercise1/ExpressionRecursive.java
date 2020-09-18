package algorithms_and_programming.exercise1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ExpressionRecursive {
    public static int N, S;
    public static boolean solution;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); //вводим N
        S = scanner.nextInt(); //вводим S
        int[] x = new int[N];
        char[] sign = new char[N];

        //Считываем числа
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
        }

        Long sum = procedure(N-1, 0L, sign, x);

        if(sum == S){
            solution = true;
            for(int i = 1; i < N; i++){
                System.out.print(x[i-1] + sign[i]);
            }
            System.out.print("=" + sum);

        }

        if (!solution) {
            System.out.println("No solution");
        }
    }

    public static Long procedure(int k, Long sum, char[] sign, int[] x){
        System.out.println("sum " + sum);
        System.out.println("k " + k);
        if(k == 0) {
            return sum;
        }

        if (k > 0){
            sum = Long.valueOf(String.valueOf(x[0]));
            if (sign[k] == '-') {

                for (int i = 0; i < N - 1; i++) { //вычисляем последовательность с текущими знаками
                    switch (sign[i]) {
                        case '-':
                            sum = Math.subtractExact(sum, x[i + 1]);
                            break;
                        case '+':
                            sum = Long.sum(sum, x[i + 1]);
                            break;
                    }
                }
                sum = procedure(k - 1, sum, sign, x);
            }

            if (sign[k] == '+') {
                for (int i = 0; i < N - 1; i++) { //вычисляем последовательность с текущими знаками
                    switch (sign[i]) {
                        case '-':
                            sum = Math.subtractExact(sum, x[i + 1]);
                            break;
                        case '+':
                            sum = Long.sum(sum, x[i + 1]);
                            break;
                    }
                }
                sum = procedure(k - 1, sum, sign, x);
            }
        }
        return sum;
    }
}
