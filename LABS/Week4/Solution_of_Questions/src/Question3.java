import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String city1, city2, city3;
        city1 = input.nextLine();
        city2 = input.nextLine();
        city3 = input.nextLine();

        System.out.println("Enter the first city: " + city1);
        System.out.println("Enter the second city: " + city2);
        System.out.println("Enter the third city: " + city3);

        if (city1.compareTo(city2) > 0){
            String temp = city1;
            city1 = city2;
            city2 = temp;
        }
        if (city2.compareTo(city3) > 0) {
            String temp = city2;
            city2 = city3;
            city3 = temp;
        }
        if (city1.compareTo(city2) > 0){
            String temp = city1;
            city1 = city2;
            city2 = temp;
        }
        System.out.println("The three cities in alphabetical order are " +city1 +" " +city2 +" " +city3);
    }
}