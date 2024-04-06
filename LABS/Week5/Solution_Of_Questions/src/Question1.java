import java.util.Scanner;
public class Question1 {
    public static int reverse(int num) {
        int remainder = 0, result = 0;
        while (num != 0) {
             remainder = num % 10;
             result = result * 10 + remainder;
             num /= 10;
        }
        return result;
    }
    public static boolean isPalindrome(int num) {
        int result = reverse(num);
        if (result == num)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.println("Enter a postive integer: " + number);
        if (isPalindrome(number))
            System.out.println(number + " is a palindrome");
        else
            System.out.println(number + " is not a palindrome");

    }
}
