import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Decryption {
    private int width;
    private int height;
    private int[][][] RGBArray;
    private List<String> logMessages;
    private DateTimeFormatter dtf;

    public Decryption(int[][][] RGBArray) {
        this.RGBArray = RGBArray;
        this.height = RGBArray.length;
        this.width = RGBArray[0].length;
        this.logMessages = new ArrayList<>(); // Initialize log messages list
        this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // Initialize DateTimeFormatter

        addLogMessage("Decryption instance created.");
    }

    public String decryptMessage() {
        addLogMessage("Decryption started.");
        int messageLength = getMessageLength();
        int targetBlue = getTargetBlue();

        int[] randomArray = extractRandomArray(messageLength, targetBlue);
        int[] asciiArray = extractAsciiArray(messageLength, targetBlue);

        // Sıralama işlemi
        sortArrays(randomArray, asciiArray);

        StringBuilder decryptedMessage = new StringBuilder();
        for (int ascii : asciiArray) {
            decryptedMessage.append((char) ascii);
        }

        addLogMessage("Decryption completed successfully.");
        return decryptedMessage.toString();
    }

    // Mesaj uzunluğunu al
    public int getMessageLength() {
        int messageLength = RGBArray[0][0][0];
        addLogMessage("Message length extracted: " + messageLength);
        return messageLength;
    }

    // Hedef maviyi al
    public int getTargetBlue() {
        int targetBlue = RGBArray[0][0][1];
        addLogMessage("Target blue value extracted: " + targetBlue);
        return targetBlue;
    }

    // Random Array'i çıkar
    public int[] extractRandomArray(int messageLength, int targetBlue) {
        int[] randomArray = new int[messageLength];
        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (RGBArray[i][j][2] == targetBlue) {
                    randomArray[count] = RGBArray[i][j][0];
                    count++;
                }
            }
        }

        addLogMessage("Random array extracted: " + Arrays.toString(Arrays.copyOf(randomArray, Math.min(10, randomArray.length))));
        return randomArray;
    }

    // ASCII Array'ini çıkar
    public int[] extractAsciiArray(int messageLength, int targetBlue) {
        int[] asciiArray = new int[messageLength];
        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (RGBArray[i][j][2] == targetBlue) {
                    asciiArray[count] = RGBArray[i][j][1];
                    count++;
                }
            }
        }

        addLogMessage("ASCII array extracted: " + Arrays.toString(Arrays.copyOf(asciiArray, Math.min(10, asciiArray.length))));
        return asciiArray;
    }

    // randomArray ve asciiArray'i sıralama
    private void sortArrays(int[] randomArray, int[] asciiArray) {
        for (int i = 0; i < randomArray.length - 1; i++) {
            for (int j = 0; j < randomArray.length - 1 - i; j++) {
                if (randomArray[j] > randomArray[j + 1]) {
                    // randomArray'de swap
                    int tempRandom = randomArray[j];
                    randomArray[j] = randomArray[j + 1];
                    randomArray[j + 1] = tempRandom;

                    // asciiArray'de swap
                    int tempAscii = asciiArray[j];
                    asciiArray[j] = asciiArray[j + 1];
                    asciiArray[j + 1] = tempAscii;
                }
            }
        }

        addLogMessage("Arrays sorted.");
    }

    // Add log message with timestamp
    private void addLogMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        logMessages.add(dtf.format(now) + " - " + message);
    }

    // Print log messages
    public void printLogMessages() {
        System.out.println("Log Messages:");
        for (String log : logMessages) {
            System.out.println(log);
        }
    }
}
