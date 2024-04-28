import java.util.Scanner;
public class Main {
    public static byte askFirstQuestion() {
        Scanner input = new Scanner(System.in);
        byte birthday;

        String message = "Please enter an appropriate day!";
        System.out.println("1) Please enter your birthday between 1 and 7(example Mon=1, Tue=2..):");

        while (true) {
            birthday = input.nextByte();
            if (birthday >= 1 && birthday <= 7) {
                System.out.println(birthday);
                return birthday;
            } else {
                System.out.println(birthday);
                System.out.println(message);
            }
        }
    }
    public static int initialLetter() {
        Scanner input = new Scanner(System.in);
        char ch;
        int asciiNumber;

        System.out.println("Enter initial letter of your name, (capital english letters only)");

        while (true) {
            ch = input.next().charAt(0);
            if (ch >= 'A' && ch <= 'Z') {
                asciiNumber = (ch) % 4; // it automaticaly gets an integer
                System.out.print(ch + " --> ");
                System.out.println(asciiNumber);
                return asciiNumber;
            }
        }
    }
    public static long askSecondQuestion(int birthday, int asciiNumber) {
        Scanner input = new Scanner(System.in);
        long powerNum = 1;
        long guess1User;

        String message = "It is not correct!";
        System.out.printf("2) What is the %dth power of %d?\n", birthday, asciiNumber);

        for (int i = 0; i < birthday; i++) {
            powerNum *= asciiNumber;
        }

        while (true) {
            guess1User = input.nextInt();
            if (guess1User == powerNum) {
                System.out.println(powerNum);
                return powerNum;
            } else {
                System.out.println(guess1User);
                System.out.println(message);
            }
        }
    }
    public static int askThirdQuestion(long powerNum){
        Scanner input = new Scanner(System.in);
        int flag = 0;
        int countOfPrime = 1; // we have accepted 2 as a prime, we will start with 3 in the for loop.
        int guess2User;

        String message = "It is not correct!";
        System.out.printf("3) How many prime numbers can you count until %d?\n", powerNum);

        if(powerNum == 0 || powerNum == 1){
            countOfPrime = 0;
        }
        else {
            for (int i = 3; i <= powerNum; i++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    } else {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    countOfPrime++;
                }
            }
        }
        while (true) {
            guess2User = input.nextInt();
            if (guess2User != countOfPrime) {
                System.out.println(guess2User);
                System.out.println(message);
            } else {
                System.out.println(countOfPrime);
                return countOfPrime;
            }
        }
    }
    public static int askFourthQuestion(long powerNum, int countOfPrime) {
        Scanner input = new Scanner(System.in);
        Fibonacci fibonacciNumber = new Fibonacci(countOfPrime);
        int[] fibonacciSeries = fibonacciNumber.createFibonacciSeries(countOfPrime);
        int guess3User;
        String message = "It is not correct!";
        System.out.printf("4) Enter %dth element of the Fibonacci series:\n", countOfPrime);


        while (true) {
            guess3User = input.nextInt();
            if (guess3User != fibonacciSeries[countOfPrime]) {
                System.out.println(guess3User);
                System.out.println(message);
            } else {
                System.out.println(fibonacciSeries[countOfPrime]);
                return fibonacciSeries[countOfPrime];
            }
        }
    }
    public static void askFifthQuestion(int fibonacciNumber) {
        Scanner input = new Scanner(System.in);
        long guess4User;
        byte age;

        String message = "It is not correct!";
        System.out.println("Enter your age(between 1-100):");
        while(true) {
            age = input.nextByte();
            if ((age < 1) || (age > 100)) {
                System.out.println(age);
                System.out.println(message);
            }
            else {
                System.out.println(age);
                break;
            }
        }

        System.out.printf("5) What is the result of %d * %d?\n", fibonacciNumber, age);
        while (true) {
            guess4User = input.nextLong();
            if (guess4User != fibonacciNumber * age) {
                System.out.println(guess4User);
                System.out.println(message);
            }
            else {
                System.out.println(fibonacciNumber * age);
                System.out.printf("Congratulations! You found the code! The code is %d\n", fibonacciNumber * age);
                break;
            }
        }
    }
    public static void main(String[] args){
        byte birthday;
        int asciiNumber;
        long  powerNum;
        int countOfPrime;
        int fibonacciNumber;

        birthday = askFirstQuestion();
        asciiNumber = initialLetter();
        powerNum = askSecondQuestion(birthday, asciiNumber);
        countOfPrime = askThirdQuestion(powerNum);
        fibonacciNumber = askFourthQuestion(powerNum, countOfPrime);
        askFifthQuestion(fibonacciNumber);
    }
}
class Fibonacci {
    int countOfPrime;
    Fibonacci() {
        this.countOfPrime = 100;
    }
    Fibonacci(int newCountOfPrime) {
        this.countOfPrime = newCountOfPrime;
    }
    void setFibonacciIndex(int newCountOfPrime) {
        this.countOfPrime = newCountOfPrime;
    }
    int[] createFibonacciSeries(int countOfPrime) {
        int[] fibonacciSeries = new int[countOfPrime + 2]; //countOfPrime 0 veya 1 olabilir arrayin boyutu istediğimiz gibi olmayacağı için 2 ekliyoruz.
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;

        for (int i = 2; i < countOfPrime + 2; i++) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }
        return fibonacciSeries;
    }
}
