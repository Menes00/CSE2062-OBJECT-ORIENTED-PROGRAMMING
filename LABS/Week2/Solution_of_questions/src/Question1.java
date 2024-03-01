import java.util.Scanner;
public class Question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double PI = 3.14159;

        double radius = input.nextDouble();
        double length = input.nextDouble();

        System.out.println("Enter the radius and length of a cylinder: " + radius + " " + length);

        double area = radius*radius*PI;
        double volume = area*length;

        System.out.println("The area is "+area);
        System.out.println("The volume of the cylinder is "+volume);
    }
}