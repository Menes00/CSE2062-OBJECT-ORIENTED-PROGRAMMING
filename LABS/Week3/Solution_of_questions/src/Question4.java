import java.util.Scanner;

public class Question4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println("Enter a three-digit integer: " + num);
        int buffer1 = num;

        int buffer2 = num % 10;
        buffer2 *= 100;
        num = num / 10;
        buffer2 += (num%10)*10;
        num = num / 10;
        buffer2 += num;
        if (buffer1 >= 100 && buffer1 <= 999){
            if (buffer2 == buffer1){
                System.out.println(buffer1 + " is a palindrome");
            }
            else {
                System.out.println(buffer1 + " is not a palindrome");
            }
        }
        else {
            System.out.println("Invalid Entry");
        }
    }
}
