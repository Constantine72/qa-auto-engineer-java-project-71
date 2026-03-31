package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hexlet.code.InnerRep;

public final class Plain {

    private Plain() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(List<InnerRep> tree) {

        return buildPlain(tree, "");
    }

    private static String buildPlain(List<InnerRep> tree, String path) {

        List<String> lines = new ArrayList<>();

        var property = "Property";

        for (InnerRep innerRep : tree) {

            String currentPath = path.isEmpty() ? innerRep.getName() : path + "." + innerRep.getName();

            switch (innerRep.getType()) {

                case "added":
                    lines.add(property + " '" + currentPath + "' was added with value: "
                            +
                            formatValue(innerRep.getValue2()));
                    break;

                case "deleted":
                    lines.add(property + " '" + currentPath + "' was removed");
                    break;

                case "changed":
                    lines.add(property + " '" + currentPath + "' was updated. From " + formatValue(innerRep.getValue1())
                            + " to " + formatValue(innerRep.getValue2()));
                    break;

                case "nested":
                    String nestedLines = buildPlain(innerRep.getChildren(), currentPath);
                    if (!nestedLines.isEmpty()) {
                        lines.add(nestedLines);
                    }

                    break;

                case "unchanged":

                    break;

                default:
                    throw new IllegalStateException("Unknown innerRep type " + innerRep.getType());
            }
        }
        return String.join("\n", lines);
    }


    private static String formatValue(Object value) {

        if (value instanceof Map || value instanceof List) {

            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
