import java.util.Scanner;

public class Question6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double edge1, edge2, edge3;
        edge1 = input.nextDouble();
        edge2 = input.nextDouble();
        edge3 = input.nextDouble();
        System.out.println("Enter three edges (length in double): "+edge1+" , "+edge2+" , "+edge3);

        if (((edge1 + edge2) > edge3) && ((edge1 + edge3) > edge2) && ((edge2 + edge3) > edge1))
            System.out.println("The perimeter is " + (edge1 + edge2 + edge3));
        else
            System.out.println("Input is invalid");
    }
}