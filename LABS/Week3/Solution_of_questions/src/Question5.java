import java.util.Scanner;

public class Question5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int userNumber = input.nextInt();
        System.out.println("scissor (0), rock (1), paper (2): " + userNumber);

        int computerNumber = (int)(Math.random() * 3);
        System.out.println(computerNumber);
        switch (userNumber) {
            case 0:
                if (computerNumber == 0)
                    System.out.println("The computer is scissor. You are scissor too. It is a draw");
                else if (computerNumber == 1)
                    System.out.println("The computer is rock. You are scissor. You lost");
                else if (computerNumber == 2)
                    System.out.println("The computer is paper. You are scissor. You won");
                break;

            case 1:
                if (computerNumber == 0)
                    System.out.println("The computer is scissor. You are rock. You won");
                else if (computerNumber == 1)
                    System.out.println("The computer is rock. You are rock too. It is a draw");
                else if (computerNumber == 2)
                    System.out.println("The computer is paper. You are rock. You lost");
                break;
            case 2:
                if (computerNumber == 0)
                    System.out.println("The computer is scissor. You are paper. You lost");
                else if (computerNumber == 1)
                    System.out.println("The computer is rock. You are paper. You won");
                else if (computerNumber == 2)
                    System.out.println("The computer is paper. You are paper too. It is a draw");
                break;
        }
    }
}
