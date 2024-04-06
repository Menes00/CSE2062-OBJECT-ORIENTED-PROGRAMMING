import java.util.Scanner;

public class Question4 {
    public static double min(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] arr = new double[7];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextDouble();
        }

        System.out.print("Enter seven double numbers:");
        for (double i: arr)
            System.out.print(" " + i);
        System.out.println();

        double minValue = min(arr);
        System.out.println("The minimal value is " + minValue);

    }
}
