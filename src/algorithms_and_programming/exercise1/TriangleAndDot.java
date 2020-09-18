package algorithms_and_programming.exercise1;

import java.util.Scanner;

public class TriangleAndDot {
    /**
     * считаются произведения (1,2,3 - вершины треугольника, 0 - точка):
     * (x1-x0)*(y2-y1)-(x2-x1)*(y1-y0)
     * (x2-x0)*(y3-y2)-(x3-x2)*(y2-y0)
     * (x3-x0)*(y1-y3)-(x1-x3)*(y3-y0)
     * Если они одинакового знака, то точка внутри треугольника,
     * если что-то из этого - ноль, то точка лежит на стороне,
     * иначе точка вне треугольника.
     */
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();


        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();

        int w1 = ((x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0));
        int w2 = ((x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0));
        int w3 = ((x3 - x0) * (y1 - y3) - (x1 - x3) * (y3 - y0));

        if ((w1 > 0 && w2 > 0 && w3 > 0) || (w1 < 0 && w2 < 0 && w3 < 0) || (w1 == 0 || w2 == 0 || w3 == 0)) {
            System.out.println("In");
        } else {
            System.out.println("Out");
        }
    }
}
