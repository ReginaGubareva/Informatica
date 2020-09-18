package algorithms_and_programming.exercise1;

import java.util.Scanner;

public class ExpressionIterative {
    public static int n, s, ss;
    public static int[] a, b;

    public static boolean solution;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); //вводим N
        s = scanner.nextInt(); //вводим S
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt(); //вводим числа (x1,x2,x3...)
        }

        while (b[n - 1] == 0) {
            b[0] = b[0] + 1;
            for (int i = 0; i < n - 1; i++) {
                if (b[i] > 1) {
                    b[i] = b[i] - 2;
                    b[i + 1] = b[+1] + 1;
                }
            }
            /*Сгенерировали знаки*/
            ss = a[0];
            for (int i = 0; i < n - 1; i++) { //вычисляем последовательность с текущими знаками
                switch (b[i]) {
                    case 0:
                        ss = ss - a[i + 1]; //ноль это минус
                        break;
                    case 1:
                        ss = ss + a[i + 1]; //еденица это плюс
                        break;
                }
            }

            if (ss == s) { //Если получится нужное число, то выводим всю последовательность со знаками
                solution = true;
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(a[i]);
                    switch (b[i]) {
                        case 0:
                            System.out.print("-");
                            break;
                        case 1:
                            System.out.print("+");
                            break;
                    }
                }
                System.out.print(a[n - 1] + "=" + s);
            }

        }

        if (!solution) {
            System.out.println("No solution");
        }
    }
}
