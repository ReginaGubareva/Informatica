package algorithms_and_programming.exercise2.SegmentsIntersection;

import algorithms_and_programming.FastScanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SegmentsIntersection {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(new File("C:\\Users\\rengu\\IdeaProjects\\Informatica\\src\\algorithms_and_programming\\exercise2\\SegmentsIntersection\\in.txt"));
//        PrintWriter out = new PrintWriter(new File(fileOut));
//        out.close();

        Point p1 = new Point(in.nextDouble(), in.nextDouble());
        Point p2 = new Point(in.nextDouble(), in.nextDouble());
        Point p3 = new Point(in.nextDouble(), in.nextDouble());
        Point p4 = new Point(in.nextDouble(), in.nextDouble());

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);

        //Отрезки лежат на одной прямой, тогда отрезки будут иметь общую точку,
        //если конец одного отрезка принадлежит другому отрезку. Проверка этого
        //сводится к проверке принадлежности точки прямоугольнику, для которого
        //прямая является диагональю.

        int sign1 = line1.getSign(p3)*line1.getSign(p4);
        int sign2 = line2.getSign(p1)*line2.getSign(p2);

        if( sign1 == 0 & sign2 == 0){
            if(InRectangle(p1, p3, p4) | InRectangle(p2, p3, p4) |
                    InRectangle(p3, p1, p2) | InRectangle(p4, p1, p2)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else if(sign1 <= 0 | sign2 <= 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }


    public static boolean InRectangle(Point p, Point p1, Point p2){
        return p1.x <= p.x & p.x <= p2.x & p1.y <= p.y & p.y <= p2.y |
                p2.x <= p.x & p.x <= p1.x & p2.y <= p.y & p.y <= p1.y;
    }
}

class Point{
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Line{
    public double a, b, c;

    Line(Point p1, Point p2){
        this.a = p2.y - p1.y;
        this.b = p1.x - p2.x;
        this.c = - a * p1.x - b * p1.y;
    }

    public int getSign(Point p){
        double value = a*p.x + b*p.y + c;
        if(value == 0.0){
            return 0;
        } else if(value < 0.0){
            return -1;
        } else {
            return 1;
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
