import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Message Processor!");
        System.out.println("1. Encrypt Message");
        System.out.println("2. Decrypt Message");
        System.out.print("Please choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        while (true)
        {
            if (choice == 1)
            {
                encryptMessage();
                break;
            } else if (choice == 2)
            {
                decryptMessage();
                break;
            } else
            {
                System.out.println("Invalid choice. Please choose 1 or 2.");
                choice = scanner.nextInt();
            }

        }

    }
    public static void encryptMessage() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the path of the image file to encrypt: ");
            String imagePath = scan.nextLine();
            Encryption encryption = new Encryption(imagePath);
            String message = encryption.getMessage(scan);
            encryption.encryptMessage(message);
            encryption.saveEncryptedImage("encryptedImage.png");
            System.out.println("Message encrypted successfully and saved as encryptedImage.png.");
            encryption.printLogMessages(); // Ensure logs are printed after encryption
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void decryptMessage() {
        try {
            BufferedImage image = ImageIO.read(new File("encryptedImage.png"));
            int width = image.getWidth();
            int height = image.getHeight();

            int[][][] RGBArray = new int[height][width][3];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color color = new Color(image.getRGB(j, i));
                    RGBArray[i][j][0] = color.getRed();
                    RGBArray[i][j][1] = color.getGreen();
                    RGBArray[i][j][2] = color.getBlue();
                }
            }

            Decryption decryption = new Decryption(RGBArray);
            String decryptedMessage = decryption.decryptMessage();
            System.out.println("Decrypted Message: " + decryptedMessage);
            decryption.printLogMessages(); // Ensure logs are printed after decryption
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}