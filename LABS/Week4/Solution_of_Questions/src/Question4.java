import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number, count1 = 0, count2 = 0, sum = 0;
        System.out.print("Enter an integer, the input ends if it is 0:");

        while (true) {
            number = input.nextInt();

            System.out.print(" " +number);
            sum += number;

            if (number > 0)
                count1++;
            if (number < 0)
                count2++;
            if (number == 0)
                break;
        }
        System.out.println();
        double average = (double)sum / (count1 + count2);
        System.out.println("The number of positives is " + count1);
        System.out.println("The number of negatives is " + count2);
        System.out.println("The total is " + sum);
        System.out.println("The average is " + average);
    }
}