import java.util.Scanner;
public class Question2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble();

        System.out.println("Enter subtotal and gratuity rate: "+subtotal + " " + gratuityRate);

        double gratuity = gratuityRate *subtotal / 100;
        double total = subtotal + gratuity;

        System.out.println("The gratuity is $"+gratuity+" total is $"+total);
    }
}
