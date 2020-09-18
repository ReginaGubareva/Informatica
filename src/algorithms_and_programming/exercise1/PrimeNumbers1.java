package algorithms_and_programming.exercise1;

import java.util.Scanner;

public class PrimeNumbers1 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int sqrtN = 0;

        boolean isPrime = true;
        for(int i = m; i <= n; i++){
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int x){
        int sqrtN = (int) Math.ceil(Math.sqrt(x));
        for(int j = 2; j <= sqrtN; j++){
            if(x % j == 0 & j != x){
                return false;
            }
        }
        return true;
    }
}
