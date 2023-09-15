import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Заданные кодировки, в которые необходимо перевести файлы
        Charset[] charsets = {
                Charset.forName("Windows-1251"),
                Charset.forName("IBM866"),
                Charset.forName("UTF-16"),
                Charset.forName("UTF-32"),
                Charset.forName("UTF-8"),
                Charset.forName("US-ASCII")
        };

        // Процесс кодирования
        long encodingStartTime = System.currentTimeMillis();

        try {
            for (Charset charset : charsets) {
                encodeFile(fileName, charset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long encodingEndTime = System.currentTimeMillis();
        long encodingTimeElapsed = encodingEndTime - encodingStartTime;
        System.out.println("Время кодирования: " + encodingTimeElapsed + " мс");

        // Процесс декодирования
        long decodingStartTime = System.currentTimeMillis();

        try {
            for (Charset charset : charsets) {
                decodeFile(fileName, charset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long decodingEndTime = System.currentTimeMillis();
        long decodingTimeElapsed = decodingEndTime - decodingStartTime;
        System.out.println("Время декодирования: " + decodingTimeElapsed + " мс");

        // Пример перекодировки в base64 для любого типа файлов
        try {
            encodeToBase64("example.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            decodeFromBase64("base64_example.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encodeFile(String fileName, Charset charset) throws IOException {
        String encodedFileName = getEncodedFileName(fileName, charset);

        byte[] fileContent = Files.readAllBytes(Paths.get(fileName));

        try (FileOutputStream fos = new FileOutputStream(encodedFileName);
             OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
             BufferedWriter writer = new BufferedWriter(osw)) {
            writer.write(new String(fileContent, charset));
        }

        System.out.println("Файл " + fileName + " успешно закодирован в " + charset + " и сохранен как " + encodedFileName);
    }

    private static void decodeFile(String fileName, Charset charset) throws IOException {
        String decodedFileName = getDecodedFileName(fileName, charset);

        byte[] fileContent = Files.readAllBytes(Paths.get(fileName));

        try (FileOutputStream fos = new FileOutputStream(decodedFileName);
             OutputStreamWriter osw = new OutputStreamWriter(fos, charset);
             BufferedWriter writer = new BufferedWriter(osw)) {
            writer.write(new String(fileContent, charset));
        }

        System.out.println("Файл " + fileName + " успешно декодирован из " + charset + " и сохранен как " + decodedFileName);
    }

    private static String getEncodedFileName(String fileName, Charset charset) {
        return "encoded_" + charset.name() + "_" + fileName;
    }

    private static String getDecodedFileName(String fileName, Charset charset) {
        return "decoded_" + charset.name() + "_" + fileName;
    }

    private static void encodeToBase64(String fileName) throws IOException {
        byte[] fileContent = Files.readAllBytes(Paths.get(fileName));
        byte[] base64Bytes = Base64.getUrlEncoder().encode(fileContent);

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("base64_" + fileName))) {
            bos.write(base64Bytes);
        }
        System.out.println("Файл " + fileName + " успешно закодирован в base64");
    }

    private static void decodeFromBase64(String fileName) throws IOException {
        byte[] base64Bytes = Files.readAllBytes(Paths.get(fileName));
        byte[] fileContent = Base64.getUrlDecoder().decode(base64Bytes);

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("decoded_" + fileName))) {
            bos.write(fileContent);
        }
        System.out.println("Файл " + fileName + " успешно декодирован из base64");
    }
}
