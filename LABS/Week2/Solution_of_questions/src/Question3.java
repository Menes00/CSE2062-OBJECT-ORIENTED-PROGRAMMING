import java.util.Scanner;
public class Question3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        long minutes = input.nextLong();

        System.out.println("Enter the number of minutes: "+minutes);

        long days = minutes / (24*60);
        long years = days / 365;
        days %=365;

        System.out.println(minutes+" minutes is approximately "+years+" years and "+days+" days");


    }
}
