import java.util.Scanner;

public class Question6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double investAmount, annualInterestRate, futureInvestValue;
        int numOfYears;

        investAmount = input.nextDouble();
        annualInterestRate = input.nextDouble();
        numOfYears = input.nextInt();

        System.out.println("Enter the investment amount: "+investAmount);
        System.out.println("Enter annual interest rate: "+annualInterestRate);
        System.out.println("Enter number of years as an integer: "+numOfYears);

        double monthlyInterestRate = annualInterestRate / 1200;
        futureInvestValue = investAmount * Math.pow(1 + monthlyInterestRate, numOfYears*12);
        System.out.println("Future value is $" + (int)(futureInvestValue * 100) / 100.0);


    }
}
