package algorithms_and_programming.exercise2.PrimeNumbers2;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        for(int i = 2; i < prime.length; i++){
            if(prime[i]){
                if(i*i <= n){
                    for(int j = i*i; j <= n; j+=i){
                        prime[j] = false;
                    }
                }
            }
        }

        for(int i = m; i <= n; i++){
            if(prime[i]){
                System.out.print(i + " ");
            }
        }
    }
}
