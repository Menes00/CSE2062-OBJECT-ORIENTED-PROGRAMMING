import java.util.Scanner;
public class Question4 {
    public static void main(String[] args){
        double amountOfWater, initialTemperature, finalTemperature, result;
        Scanner input = new Scanner(System.in);

        amountOfWater = input.nextDouble();
        initialTemperature = input.nextDouble();
        finalTemperature = input.nextDouble();

        result = amountOfWater*(finalTemperature - initialTemperature) * 4184;

        System.out.println("Enter the amount of water in kilograms: "+amountOfWater);
        System.out.println("Enter the initial temperature: "+initialTemperature);
        System.out.println("Enter the final temperature: "+finalTemperature);
        System.out.println("The energy needed is "+result);

    }
}
