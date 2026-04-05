package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.InnerRep;

import java.util.List;

public final class Formatter {

    private Formatter() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(List<InnerRep> tree, String formatName) throws IllegalStateException,
            JsonProcessingException {


        return switch (formatName) {
            case "stylish" -> Stylish.format(tree);
            case "plain" -> Plain.format(tree);
            case "json" -> JSON.format(tree);
            default -> throw new IllegalStateException("Unknown format: " + formatName);
        };
    }
}
