import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        System.out.println("Enter a string: " + s1);

        String reversedString = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            reversedString += s1.charAt(i);
        }
        System.out.println("The reversed string is " + reversedString);
    }
}
