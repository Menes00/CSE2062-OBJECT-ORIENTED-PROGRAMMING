import java.util.Scanner;

public class Question5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num, sum = 0;
        do{
            num = input.nextInt();
        }while(num < 0 && num > 1000);

        System.out.println("Enter an integer between 0 and 1000: "+num);

        int num1 = num;

        while(num > 0){
            sum += (num%10);
            num /=10;
        }
        System.out.println("The sum of all digits in " + num1 + " is " + sum);
    }
}
