import java.util.Scanner;

public class Question2 {
    public static boolean isValidPassword(String str){
        int count = 0;
        if (str.length() < 8)
            return false;
        for(int i = 0; i < str.length(); i++){
            if (!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i)) )
                return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                count++;
        }
        if ( count < 2 )
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("Enter a string for password: " + str);

        if (isValidPassword(str))
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");

    }
}
