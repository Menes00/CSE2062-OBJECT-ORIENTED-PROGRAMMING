import java.util.Scanner;
public class Main {
    public static long reverseNumber(int num) {
        int remainder = 0, reverseNumber = 0;

        while(num > 0){
            remainder = num % 10;
            reverseNumber = reverseNumber*10 + remainder;
            num /= 10;
        }
        return reverseNumber;
    }
    public static int getNumOfDigits(int num) {
        int numOfDigits = 0;

        while (num > 0) {
            num /= 10;
            numOfDigits++;
        }
        return numOfDigits;
    }
    public static int[] createArray(int num, int numOfDigits) {
        int[] arr = new int[numOfDigits];

        for (int i = 0; i < numOfDigits; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }
    public static void printArray(long[] arr, int counOfUMN) {
        for(int i = 0; i < counOfUMN; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 9 == 0)
                System.out.println();
        }
        System.out.println();
    }
    public static int countOfUMN(CreateUpperBound upperBound) {
        int temp = 100;
        int countOfUMN = 0;

        while (temp < upperBound.number) {
            long reverseNumber = reverseNumber(temp);
            int numOfDigits = getNumOfDigits(temp);

            int[] arr = createArray(temp, numOfDigits);
            if ((temp == reverseNumber) && (arr[0] != arr[1]))
                countOfUMN++;
            temp++;
        }
        return countOfUMN;
    }
    public static long[] findUMN(CreateUpperBound upperBound, int countOfUMN) {
        int temp = 100;
        int i = 0;
        long[] storeUMN = new long[countOfUMN];

        while (temp < upperBound.number) {
            long reverseNumber = reverseNumber(temp);
            int numOfDigits = getNumOfDigits(temp);

            int[] arr = createArray(temp, numOfDigits);
            if ((temp == reverseNumber) && (arr[0] != arr[1])) {
                storeUMN[i] = temp;
                i++;
            }
            temp++;
        }
        return storeUMN;
    }
    public static void main(String[] args) {
        CreateUpperBound upperBound = new CreateUpperBound();

        System.out.println("Please enter an upper bound: " + upperBound.number);

        boolean controlUpperBound = upperBound.checkUpperBound(upperBound.number);

        if(controlUpperBound) {
            int countOfUMN = countOfUMN(upperBound);
            long[] storeUMN = findUMN(upperBound, countOfUMN);;

            printArray(storeUMN, countOfUMN);
            System.out.printf("There are %d ultra magic numbers up to %d.",countOfUMN, upperBound.number);
        }
    }
}
class CreateUpperBound {
    long number;
    String message1 = "Upper bound cannot be negative.";
    String message2 = "Upper bound must have more than or equal to three digits.";
    CreateUpperBound(){
        Scanner input = new Scanner(System.in);
        this.number = input.nextLong();
    }
    CreateUpperBound(long newNumber) {
        this.number = newNumber;
    }
    void setUpperBound(long newNumber) {
        this.number = newNumber;
    }
    boolean checkUpperBound(long number) {
        if (number < 0) {
            System.out.println(message1);
            return false;
        }
        else if (number >= 0 && number < 100) {
            System.out.println(message2);
            return false;
        }
        else
            return true;
    }
}