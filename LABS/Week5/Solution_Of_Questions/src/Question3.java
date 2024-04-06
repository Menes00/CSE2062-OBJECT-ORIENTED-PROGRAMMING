import java.util.Scanner;

public class Question3 {
    public static double max(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println("Enter number of students: " + num);

        double[] arr = new double[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextDouble();
        }
        System.out.printf("Enter %d scores:",num);
        for (double i: arr) {
            System.out.print(" " + i);
        }
        System.out.println();
        double bestScore = max(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= bestScore - 10)
                System.out.printf("Student %d score is %.1f and grade is A\n", i, arr[i]);
            else if (arr[i] >= bestScore - 20)
                System.out.printf("Student %d score is %.1f and grade is B\n", i, arr[i]);
            else if (arr[i] >= bestScore - 30)
                System.out.printf("Student %d score is %.1f and grade is C\n", i, arr[i]);
            else if (arr[i] >= bestScore - 40)
                System.out.printf("Student %d score is %.1f and grade is D\n", i, arr[i]);
            else
                System.out.printf("Student %d score is %.1f and grade is F\n", i, arr[i]);
        }
    }
}
