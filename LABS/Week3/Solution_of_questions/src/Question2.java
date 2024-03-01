import java.util.Scanner;

public class Question2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double weight, height;

        weight = input.nextDouble();
        height = input.nextDouble();

        System.out.println("Enter weight in pounds: " + weight);
        System.out.println("Enter height in inches: " + height);

        weight *= 0.45359237;
        height *= 0.0254;

        double BMI = weight / (Math.pow(height,2));
        System.out.println("BMI is " + BMI);

        if (BMI < 18.5)
            System.out.println("Underweight");
        else if (BMI >= 18.5 && BMI < 25.0)
            System.out.println("Normal");
        else if (BMI >= 25.0 && BMI < 30.0)
            System.out.println("Overweight");
        else
            System.out.println("Obese");

    }
}
