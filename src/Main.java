import javax.crypto.SecretKey;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("NETWORKED PROGRAM");
            System.out.println("\n@Sender");

            // Generate a secret key
            AesEncryption aes_encryption = new AesEncryption();
            SecretKey key = aes_encryption.init();

            // Getting Message from File
            String sender_message = aes_encryption.readFile("C:\\Projects\\Java\\Digital-Signatures-Application\\src\\input.txt");

            // Encrypt user message
            String encryptedData = aes_encryption.encrypt(sender_message);

            // Display the encrypted string
            System.out.println("Encrypted Data: " + encryptedData);
            System.out.println("\n@Receiver");
            System.out.println("Encrypted Data: " + encryptedData);

            // Decrypt the user message
            String decryptedData = aes_encryption.decrypt(encryptedData);

            // Write original message
            aes_encryption.writeFile(decryptedData, Paths.get("C:\\Projects\\Java\\Digital-Signatures-Application\\src\\output.txt"));

        } catch (Exception ignored) {
        }
    }
}