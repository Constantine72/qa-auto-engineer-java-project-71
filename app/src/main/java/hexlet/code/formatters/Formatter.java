package hexlet.code.formatters;

import hexlet.code.InnerRep;

import java.util.List;

public final class Formatter {

    private Formatter() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(List<InnerRep> tree, String formatName) throws Exception {


        switch (formatName) {
            case "stylish":
                return Stylish.format(tree);
            case "plain":
                return Plain.format(tree);
            case "json":
                return JSON.format(tree);
            default:
                throw new IllegalStateException("Unknown format: " + formatName);
        }
    }
}
