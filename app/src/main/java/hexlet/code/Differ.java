package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.google.gson.Gson;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {

        Path writeFilePath1 = Paths.get("src/main/resources/file1.json");
        Path writeFilePath2 = Paths.get("src/main/resources/file2.json");

        try {
            Path createdFilePath1 = Files.createFile(writeFilePath1);
            System.out.println("Файл создан: " + createdFilePath1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Path createdFilePath2 = Files.createFile(writeFilePath2);
            System.out.println("Файл создан: " + createdFilePath2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String readFilePath1 = Files.readString(writeFilePath1);
        String readFilePath2 = Files.readString(writeFilePath2);

        Path path1 = Paths.get(readFilePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(readFilePath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }
        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        System.out.println(content1);
        System.out.println(content2);

        Gson gson = new Gson();
        Map dictionary1 = gson.fromJson(content1, Map.class);
        Map dictionary2 = gson.fromJson(content2, Map.class);

        System.out.println("Parsing is complete");


        return "";
    }
}
