import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ch = input.next().charAt(0);
        System.out.println("Enter a letter: " + ch);
        int flag = 0;
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            if (ch >= 'a' && ch <= 'z') {
                ch = Character.toUpperCase(ch);
                flag++;
            }
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                if (flag == 1){
                    ch = Character.toLowerCase(ch);
                    System.out.println(ch + " is a vowel");
                }
                else
                    System.out.println(ch + " is a vowel");
            else {
                if (flag == 1){
                    ch = Character.toLowerCase(ch);
                    System.out.println(ch + " is a consonant");
                }
                else
                    System.out.println(ch + " is a consonant");
            }
        }
        else {
            System.out.println(ch + " is an invalid input");
        }
    }
}