package algorithms_and_programming.exercise2.Route;

import algorithms_and_programming.FastScanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Route {

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


        //Теперь нам нужно построить таблицу, которая будет хранить вес маршрута
        //из ячейки [0,0] в ячейку [i,j]. Для этого будем находить маршрут
        // и записывать его вес в другой массив, назовем его M. Тогда мнимальная сумма
        // цифр маршрута из ячейки [0,0] в ячейку [i,j] будет храниться в M[i, j];
        int[][] M = new int[n][n];
        char[][] F = new char[n][n];
        char[][] R = new char[n][n];

        //В ячейку [0,0] можно прийти одним путем, остаться в ней
        M[0][0] = 1;
        F[0][0] = 'i';

        //Идем в клетки первого столбца, в эти клетки можно прийти одним путем
        //всегда идти вниз,тогда:
        for(int i = 1; i < n; i++){
            //то есть берем вышестоящую клетку и прибавляем туда значение текущей
            M[i][0] = M[i-1][0] + T[i][0];
            F[i][0] = 'u';
        }

        //Для ячеек первой строки аналогично, можно прийти только дивигаясь вправо
        for(int i = 1; i < n; i++){
            //то есть берем вышестоящую клетку и прибавляем туда значение текущей
            M[0][i] = M[0][i-1] + T[0][i];
            F[0][i] = 'l';
        }

        //Теперь сделаем общий случай, нужно прийти в клетку [i,j].
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++) {
                // В клетку [i,j] можно прийти двумя путями: сверху из [i-1, j], либо слева [i, j-1].
                // Следовательно, нужно выбрать минимальный из этих путей
                if(M[i - 1][j] <= M[i][j - 1]) {
                    M[i][j] = M[i - 1][j] + T[i][j];
                    F[i][j] = 'u';
                } else {
                    M[i][j] = M[i][j - 1] + T[i][j];
                    F[i][j] = 'l';
                }
            }
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                R[i][j] = '-';
            }
        }

        // После построения матрицы F, по ней будем строить матрицу результат
        // Для этого будем двигаться, начиная с клетки [n,n], если в ячейки 'u',
        // то двигаемся вверх, если 'l', то влево. Заканчиваем движение, когда
        // придем в i. Клетки, которые прошли помечаем #.
        int raw = n - 1;
        int col = n - 1;
        while( F[raw][col] != 'i' ) {
            R[raw][col] = '#';
            if(F[raw][col] == 'l'){
                col--;
            } else {
                raw--;
            }
        }
        R[raw][col] = '#';

        System.out.println();
        System.out.println("M: ");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println("F: ");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("R: ");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(R[i][j] + " ");
            }
            System.out.println();
        }

        out.close();
    }
}
