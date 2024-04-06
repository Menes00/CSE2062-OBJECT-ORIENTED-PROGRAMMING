import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2;
        num1 = input.nextInt();
        num2 = input.nextInt();

        System.out.println("Enter the first number: " + num1);
        System.out.println("Enter the second number: " + num2);

        int gcd = 1;
        int i = 2;
        while (i <= num1 && i <= num2) {
            if ((num1 % i == 0) && (num2 % i == 0))
                gcd = i;
            i++;
        }
        System.out.printf("GCD of %d and %d is %d",num1, num2, gcd);
    }
}
