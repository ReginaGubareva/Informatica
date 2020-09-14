package algorithms_and_programming;

import java.util.Scanner;

public class Power {
    private static int n = 1;
    private static int[] d = new int[10000];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        power(a, b);

        for (int j = n-1; j >= 0; j--){
            System.out.print(d[j]);
        }
    }

    public static void power(int a, int n) {
        d[0] = a;

        for (int i = 2; i <= n; i++) {
            multiplyArray(a);
        }
    }

    public static void multiplyArray(int a) {
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry = carry + d[i]*a;
            d[i] = carry % 10;
            carry = carry / 10;
        }
        if (carry > 0) {
            d[n] = carry;
            n += 1;
        }
    }
}
