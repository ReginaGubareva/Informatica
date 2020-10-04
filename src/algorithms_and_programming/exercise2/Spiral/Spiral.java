package algorithms_and_programming.exercise2.Spiral;

import algorithms_and_programming.FastScanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Spiral {
    private static final String fileIn = "C:\\Users\\rengu\\IdeaProjects\\Informatica\\src\\algorithms_and_programming\\exercise2\\Spiral\\in.txt";
    private static final String fileOut = "C:\\Users\\rengu\\IdeaProjects\\Informatica\\src\\algorithms_and_programming\\exercise2\\Spiral\\out.txt";

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(new File(fileIn));
        PrintWriter out = new PrintWriter(new File(fileOut));
        int n = in.nextInt();

        int[][] a = new int[n + 2][n + 2];

        //Построим так называемый барьер, для этого сначала заполним массив единицами,
        //потом заполним внутренний квадрат нулями
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                a[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = 0;
            }
        }

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        //Теперь будем двигаться по матрице и изменять направление движения
        //когда наткнемся на ненулевой элемент

        //Для движения по внутренней матрцы
        int m = 1;
        int k = 1;

        //Для изменения направления
        int dm = 0;
        int dk = 1;

        int num = 1;
        while (num != n * n +1) {

            if (a[m + dm][k + dk] != 0) {
                if( dm == 0 & dk == 1) {
                    dm = 1;
                    dk = 0;
                } else if(dm == 1 & dk == 0){
                    dm = 0;
                    dk = -1;
                } else if(dm == 0 & dk == -1){
                    dm = -1;
                    dk = 0;
                } else if(dm == -1 & dk == 0){
                    dm = 0;
                    dk = 1;
                }
            }

            a[m][k] = num;
            m = m + dm;
            k = k + dk;
            num++;
        }

        System.out.println();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        out.close();
    }

    private static void changeDirection(int x, int y) {

    }
}
