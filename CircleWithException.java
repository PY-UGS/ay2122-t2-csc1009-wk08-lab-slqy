import java.util.InputMismatchException;
import java.util.Scanner;

public class CircleWithException {

    private double radius;

    public CircleWithException(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        // returns the radius
        return radius;
    }

    public void setRadius(double radius){
        // sets a new radius
        this.radius = radius;
    }

    public double getArea(){
        // returns the area of the circle
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    public double getDiameter(){
        // returns the diameter of the circle
        double diameter = 2 * radius;
        return diameter;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        try{
            // ask for user input
            System.out.print("Enter a radius for circle: ");
            double input = sc.nextDouble();

            // if input is not a positive number, catch invalid input
            if (input < 0)
                throw new IllegalArgumentException("Input must be a positive number");

            // if valid input
            CircleWithException cwe = new CircleWithException(input);
            System.out.println("The radius is " + cwe.getRadius());
            System.out.println("The diameter is " + cwe.getDiameter());

            // if area bigger than 1000
            if (cwe.getArea() > 1000)
                throw new Exception("Area is bigger than 1000");
            else
                System.out.println("The area is " + cwe.getArea());

        } catch (InputMismatchException e) {
            // if input is not a number, catch invalid input
            System.out.println("Input must be a number");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
