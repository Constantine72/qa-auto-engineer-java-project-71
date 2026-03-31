package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

import java.util.Map;

public final class Parser {

    private Parser() {
        throw new IllegalStateException("Utility class");
    }


    public static Map<String, Object> parse(String content, String format) throws IOException {

        ObjectMapper mapper = format.equals("json") ? new JsonMapper() : new YAMLMapper();

        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}


