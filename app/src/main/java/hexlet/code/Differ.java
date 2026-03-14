package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {

        try {

            Path path1 = Paths.get("src/main/resources/file1.json").toAbsolutePath().normalize();
            Path path2 = Paths.get("src/main/resources/file2.json").toAbsolutePath().normalize();


            if (!Files.exists(path1)) {
                throw new Exception("File '" + path1 + "' does not exist");
            }
            if (!Files.exists(path2)) {
                throw new Exception("File '" + path2 + "' does not exist");
            }

            String content1 = Files.readString(path1);
            String content2 = Files.readString(path2);

            Gson gson = new GsonBuilder()
                    .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                    .create();
            Map dictionary1 = gson.fromJson(content1, Map.class);
            Map dictionary2 = gson.fromJson(content2, Map.class);


            System.out.println("\n" + "{");

            Set<String> keys = new TreeSet<>();
            keys.addAll(dictionary1.keySet());
            keys.addAll(dictionary2.keySet());

            StringBuilder result = new StringBuilder();

            for (String key : keys) {

                if (!dictionary1.containsKey(key)) {

                    result.append(" + ")
                            .append(key)
                            .append(": ")
                            .append(dictionary2.get(key))
                            .append("\n");
                } else if (!dictionary2.containsKey(key)) {

                    result.append(" - ")
                            .append(key)
                            .append(": ")
                            .append(dictionary1.get(key))
                            .append("\n");
                } else if (!dictionary1.get(key).equals(dictionary2.get(key))) {

                    result.append(" - ")
                            .append(key)
                            .append(": ")
                            .append(dictionary1.get(key))
                            .append("\n");

                    result.append(" + ")
                            .append(key)
                            .append(": ")
                            .append(dictionary2.get(key))
                            .append("\n");
                } else {

                    result.append("   ")
                            .append(key)
                            .append(": ")
                            .append(dictionary1.get(key))
                            .append("\n");
                }
            }
            result.append("}");

            return result.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);


        }


    }
}
