import java.util.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Encryption {
    private BufferedImage image;
    private int width;
    private int height;
    private int[][][] RGBArray;
    private List<String> logMessages; // Log messages list
    private DateTimeFormatter dtf; // DateTimeFormatter instance

    public Encryption(String imagePath) throws IOException {
        // Initialize the DateTimeFormatter instance
        this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.logMessages = new ArrayList<>(); // Initialize log messages list

        // Resmi yükle ve RGBArray oluştur
        this.image = ImageIO.read(new File(imagePath));
        this.width = image.getWidth();
        this.height = image.getHeight();
        addLogMessage("Image loaded successfully.");

        this.RGBArray = createRGBArray();
        addLogMessage("RGB array created successfully.");
    }

    // RGB Array oluşturma
    private int[][][] createRGBArray() {
        int[][][] RGBArray = new int[height][width][3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixel = image.getRGB(j, i);
                Color color = new Color(pixel);
                RGBArray[i][j][0] = color.getRed();
                RGBArray[i][j][1] = color.getGreen();
                RGBArray[i][j][2] = color.getBlue();
            }
        }
        return RGBArray;
    }

    // Validate message length
    public String getMessage(Scanner scan) {
        String message = "";
        System.out.print("Enter the message you want to hide (Must be 1-255 characters long): ");
        message = scan.nextLine();
        addLogMessage("Message entered. Length: " + message.length());

        while (message.length() == 0 || message.length() > 255) {
            System.out.print("Enter a String with length 1-255!: ");
            message = scan.nextLine();
            addLogMessage("Message re-entered. Length: " + message.length());
        }
        return message;
    }

    // Rastgele targetBlue seç
    // Generate random target blue value
    public int getRandomTargetBlue(int messageLength) {
        Random rand = new Random();
        int targetBlue;
        do {
            targetBlue = rand.nextInt(255); // Generate a random number between 0-254
        } while (targetBlue == messageLength);
        addLogMessage("Random target blue value generated: " + targetBlue);
        return targetBlue;
    }

    // Generate a unique random array
    public int[] getUniqueRandomArray(int messageLength) {
        Random rand = new Random();
        int[] randomArray = new int[messageLength];
        int count = 0;
        while (count < messageLength) {
            int randomNumber = rand.nextInt(256); // Generate a number between 0-255
            if (!contains(randomArray, randomNumber, count)) {
                randomArray[count] = randomNumber;
                count++;
            }
        }
        Arrays.sort(randomArray);
        addLogMessage("Unique random array generated: " + Arrays.toString(Arrays.copyOf(randomArray, Math.min(10, randomArray.length))));
        return randomArray;
    }

    // Convert message to ASCII array
    public int[] getAsciiArray(String message) {
        int messageLength = message.length();
        int[] asciiArray = new int[messageLength];
        for (int i = 0; i < messageLength; i++) {
            asciiArray[i] = (int) message.charAt(i);
        }
        addLogMessage("Message converted to ASCII array: " + Arrays.toString(Arrays.copyOf(asciiArray, Math.min(10, asciiArray.length))));
        return asciiArray;
    }

    // Adjust target blue value in RGB array
    public void adjustTargetBlue(int targetBlue) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (RGBArray[i][j][2] == targetBlue) {
                    RGBArray[i][j][2] = (targetBlue + 1);
                }
            }
        }
        addLogMessage("Adjusted target blue value in RGB array.");
    }

    // Generate unique pixel array
    public int[][] getUniquePixelArray(int messageLength) {
        Random rand = new Random();
        int[][] pixelArray = new int[messageLength][2];
        int pixel1, pixel2, index = 0;
        while (index < messageLength) {
            pixel1 = rand.nextInt(height);
            pixel2 = rand.nextInt(width);

            if (!uniquePixels(pixelArray, pixel1, pixel2, index) && !(pixel1 == 0 && pixel2 == 0)) {
                pixelArray[index][0] = pixel1;
                pixelArray[index][1] = pixel2;
                index++;
            }
        }
        addLogMessage("Unique pixel array generated.");
        return pixelArray;
    }

    // Encrypt the message
    public void encryptMessage(String message) {
        int messageLength = message.length();
        int targetBlue = getRandomTargetBlue(messageLength);
        addLogMessage("Encryption started.");

        int[] randomArray = getUniqueRandomArray(messageLength);
        int[] asciiArray = getAsciiArray(message);

        adjustTargetBlue(targetBlue);

        RGBArray[0][0][0] = messageLength;
        RGBArray[0][0][1] = targetBlue;

        int[][] pixelArray = getUniquePixelArray(messageLength);
        for (int i = 0; i < messageLength; i++) {
            int pixel1 = pixelArray[i][0];
            int pixel2 = pixelArray[i][1];

            RGBArray[pixel1][pixel2][0] = randomArray[i];
            RGBArray[pixel1][pixel2][1] = asciiArray[i];
            RGBArray[pixel1][pixel2][2] = targetBlue;
        }

        addLogMessage("Encryption completed successfully.");
    }

    // Save the encrypted image
    public void saveEncryptedImage(String outputPath) throws IOException {
        BufferedImage encryptedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = new Color(RGBArray[i][j][0], RGBArray[i][j][1], RGBArray[i][j][2]).getRGB();
                encryptedImage.setRGB(j, i, rgb);
            }
        }

        File outputFile = new File(outputPath);
        ImageIO.write(encryptedImage, "png", outputFile);
        addLogMessage("Encrypted image saved successfully.");
    }

    // Check if an array contains a value
    private boolean contains(int[] array, int value, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Check if pixel coordinates are unique
    private boolean uniquePixels(int[][] pixelArray, int pixel1, int pixel2, int index) {
        for (int i = 0; i < index; i++) {
            if (pixelArray[i][0] == pixel1 && pixelArray[i][1] == pixel2) {
                return true;
            }
        }
        return false;
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