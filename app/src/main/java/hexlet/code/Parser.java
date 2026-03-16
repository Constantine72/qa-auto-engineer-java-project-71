package hexlet.code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filepath) throws Exception {

        String content = Files.readString(Path.of(filepath));

        if (filepath.endsWith(".yml") || filepath.endsWith(".yaml")) {

            ObjectMapper mapper = new ObjectMapper((new YAMLFactory()));
            return mapper.readValue(content, Map.class);
        } else if (filepath.endsWith(".json")) {
            Gson gson = new GsonBuilder()
                    .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                    .create();
            return gson.fromJson(content, Map.class);
        } else {
            throw new Exception("Unsupported file format: " + filepath);
        }
    }
}
