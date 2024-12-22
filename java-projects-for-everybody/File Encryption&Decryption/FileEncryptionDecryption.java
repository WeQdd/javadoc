import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;

/**
 * Этот класс предоставляет функциональность для шифрования и дешифрования файлов с использованием алгоритма AES.
 */
public class FileEncryptionDecryption {

     /** Используемый алгоритм шифрования (AES). */
    private static final String AES_ALGORITHM = "AES";

     /** Расширение файла для зашифрованных файлов. */
    private static final String ENCRYPTED_FILE_EXTENSION = ".enc";

    /**
     * Основной метод для запуска процесса шифрования/дешифрования файла.
     * Запрашивает у пользователя путь к файлу, ключ шифрования и режим (шифрование или дешифрование).
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void RunFileEncryptionDecryption(String[] args) {
        try {
            // Read user input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter file path: ");
            String filePath = reader.readLine();

            System.out.print("Enter encryption key: ");
            String encryptionKey = reader.readLine();

            System.out.print("Encrypt (E) or Decrypt (D): ");
            String mode = reader.readLine();

            if (mode.equalsIgnoreCase("E")) {
                encryptFile(filePath, encryptionKey);
                System.out.println("File encrypted successfully!");
            } else if (mode.equalsIgnoreCase("D")) {
                decryptFile(filePath, encryptionKey);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid mode selected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Шифрует указанный файл, используя заданный ключ шифрования.
     *
     * @param filePath      Путь к файлу, который нужно зашифровать
     * @param encryptionKey Ключ, используемый для шифрования
     * @throws Exception Если произошла ошибка во время процесса шифрования
     */
    private static void encryptFile(String filePath, String encryptionKey) throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

        Key key = generateKey(encryptionKey);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedContent = cipher.doFinal(fileContent);

        String encryptedFilePath = filePath + ENCRYPTED_FILE_EXTENSION;
        FileOutputStream outputStream = new FileOutputStream(encryptedFilePath);
        outputStream.write(encryptedContent);
        outputStream.close();
    }

    /**
     * Дешифрует указанный файл, используя заданный ключ шифрования.
     *
     * @param filePath      Путь к файлу, который нужно дешифровать
     * @param encryptionKey Ключ, используемый для дешифрования
     * @throws Exception Если произошла ошибка во время процесса дешифрования
     */
    private static void decryptFile(String filePath, String encryptionKey) throws Exception {
        byte[] encryptedContent = Files.readAllBytes(Paths.get(filePath));

        Key key = generateKey(encryptionKey);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedContent = cipher.doFinal(encryptedContent);

        String decryptedFilePath = filePath.replace(ENCRYPTED_FILE_EXTENSION, "");
        FileOutputStream outputStream = new FileOutputStream(decryptedFilePath);
        outputStream.write(decryptedContent);
        outputStream.close();
    }

    /**
     * Генерирует криптографический ключ из заданной строки ключа шифрования.
     *
     * @param encryptionKey Строка, используемая в качестве ключа шифрования
     * @return Объект Key, подходящий для использования с шифрованием/дешифрованием AES
     * @throws Exception Если произошла ошибка во время генерации ключа
     */
    private static Key generateKey(String encryptionKey) throws Exception {
        byte[] keyBytes = encryptionKey.getBytes();
        return new SecretKeySpec(keyBytes, AES_ALGORITHM);
    }
}

