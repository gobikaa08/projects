package mynewproject;

class Shape {
    public void area() {
        System.out.println("Default area");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    public void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Circle Area: " + result);
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public void area() {
        double result = length * width;
        System.out.println("Rectangle Area: " + result);
    }
}

public class main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);       // TC1
        Shape s2 = new Rectangle(10, 5); // TC2
        Shape s3 = new Shape();         // TC3
        Shape s4 = new Circle(0);       // TC4
        Shape s5 = new Rectangle(10, 0); // TC5

        s1.area();
        s2.area();
        s3.area();
        s4.area();
        s5.area();
    }
}