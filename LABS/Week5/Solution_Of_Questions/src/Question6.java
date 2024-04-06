import java.util.Scanner;

public class Question6 {
    public static double sum(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] arr = new double[3][4];
        System.out.println("Enter a 3 by 4 matrix row by row:");

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = input.nextDouble();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Sum of the elements at column " + i + " is " + sum(arr, i));
        }
    }
}
