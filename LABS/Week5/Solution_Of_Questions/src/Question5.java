import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        char[][] Students = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
        };
        char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        for(int row = 0; row < Students.length; row++) {
            int count = 0;
            for(int column = 0; column < Students[row].length; column++) {
                if (Students[row][column] == key[column])
                    count++;
            }
            System.out.printf("Student %d's correct count is %d\n", row, count);
        }
    }
}
