package algorithms_and_programming.exercise2.PrimeNumbers2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> primes= new ArrayList<>();
        int sqrtM = (int) Math.ceil(Math.sqrt(m));


        for(int i = 2; i <= 1010; i++){
            if((sqrtM*sqrtM) == i){
                sqrtM++;
            }
            if(isPrime(i, sqrtM)) {
                primes.add(i);

            }
        }

        sqrtM = (int) Math.ceil(Math.sqrt(m));
        for(int i = m; i <= n; i++){
            if((sqrtM*sqrtM) == i){
                sqrtM++;
            }
            if(isPrimeFast(i, sqrtM, primes)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrimeFast(int x, int sqrtM, List<Integer> primes){
        for(int j = 0; primes.get(j) <= sqrtM; j++){
            if(x % primes.get(j) == 0 & primes.get(j) != x){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int x, int sqrtM){
        for(int j = 2; j <= sqrtM; j++){
            if(x % j == 0 & j != x){
                return false;
            }
        }
        return true;
    }
}
