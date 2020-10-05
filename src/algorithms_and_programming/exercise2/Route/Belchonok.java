package algorithms_and_programming.exercise2.Route;

import algorithms_and_programming.FastScanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Belchonok {
    private static final String fileIn = "C:\\Users\\rengu\\IdeaProjects\\Informatica\\src" +
            "\\algorithms_and_programming\\exercise2\\Route\\in.txt";
    private static final String fileOut = "C:\\Users\\rengu\\IdeaProjects\\Informatica\\src" +
            "\\algorithms_and_programming\\exercise2\\Route\\out.txt";

    public static void main(String[] args) throws IOException {
        //Для того, чтобы записывать в файл, мы создаем объект FastScanner
        FastScanner in = new FastScanner(new File(fileIn));
        PrintWriter out = new PrintWriter(new File(fileOut));
        int n = in.nextInt();
        //Создадим двумерный массив, для хранения исхо дного массива
        int[][] T = new int[n][n];

        for(int i = 0; i < n; i++){
            String buffer = in.next();
            for(int j = 0; j < n; j++){
                T[i][j] = Integer.parseInt(String.valueOf(buffer.charAt(j)));
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }



        int result = 0;
        int i = 1;
        int j = 1;
        for(int k = 0; k < 10; k++){
            while (i < n-1 & j < n-1){
                T[i][j]= 0;
                int indexI = 0;
                int indexJ = 0;
                int max = 0;
                if(T[i+1][j] > T[i][j+1] & T[i+1][j] > T[i-1][j] & T[i+1][j] > T[i][j-1]) {
                    max =T[i+1][j];
                    indexI = i+1;
                    indexJ = j;
                }else if(T[i][j+1] > T[i+1][j] & T[i][j+1] > T[i-1][j] & T[i][j+1] > T[i][j-1]) {
                    max =T[i][j+1];
                    indexI = i;
                    indexJ = j+1;
                } else if(T[i][j-1] > T[i+1][j] & T[i][j-1]> T[i][j+1] & T[i][j-1] > T[i-1][j]){
                    max =T[i][j-1];
                    indexI = i;
                    indexJ = j-1;
                } else {
                    max =T[i-1][j];
                    indexI = i-1;
                    indexJ = j;
                }
                result += max;
                i = indexI;
                j = indexJ;
            }
        }
        System.out.print(result);
        out.close();
    }

}
