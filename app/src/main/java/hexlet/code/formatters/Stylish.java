package hexlet.code.formatters;

import hexlet.code.InnerRep;

import java.util.List;
import java.util.Map;

public final class Stylish {

    private Stylish() {

        throw new IllegalStateException("Utility class");
    }

    private static final int INDENT_STEP = 1;

    public static String format(List<InnerRep> diffTree) {

        return formatTree(diffTree, 1);
    }

    private static String formatTree(List<InnerRep> innerReps, int depth) {

        StringBuilder result = new StringBuilder();
        result.append(("{\n"));


        String indent = " ".repeat(depth * INDENT_STEP);

        for (InnerRep innerRep : innerReps) {

            switch (innerRep.getType()) {

                case "nested":
                    String nestedString = formatTree(innerRep.getChildren(), depth + 1);
                    result.append(indent).append(innerRep.getName()).append(": ").append(nestedString).append("\n");
                    break;

                case "added":
                    result.append(indent).append(" + ").append(innerRep.getName())
                            .append(": ").append(String.valueOf(innerRep.getValue2())).append("\n");
                    break;

                case "deleted":
                    result.append(indent).append(" - ").append(innerRep.getName())
                            .append(": ").append(String.valueOf(innerRep.getValue1())).append("\n");
                    break;

                case "unchanged":
                    result.append(indent + "   " + innerRep.getName() + ": " + innerRep.getValue1()
                            +
                            "\n");
                    break;

                case "changed":
                    result.append(indent).append(" - ").append(innerRep.getName())
                            .append(": ").append(String.valueOf(innerRep.getValue1())).append("\n");
                    result.append(indent).append(" + ").append(innerRep.getName())
                            .append(": ").append(String.valueOf(innerRep.getValue2())).append("\n");
                    break;
                default:
                    throw new IllegalStateException("Unknown node type: " + innerRep.getType());
            }
        }
        String bracketIndent = " ".repeat((depth - 1) * INDENT_STEP);
        result.append(bracketIndent).append("}");

        return result.toString();
    }

    private static String stringify(Object value, int depth) {

        if (value == null) {
            return "null";
        }
        if (!(value instanceof Map)) {
            return value.toString();
        }
        Map<String, Object> mapValue = (Map<String, Object>) value;
        StringBuilder result = new StringBuilder();
        result.append("{\n");

        int nextDepth = depth + 1;

        String indent = " ".repeat(nextDepth * INDENT_STEP);
        String bracketIndent = " ".repeat(depth * INDENT_STEP);

        for (Map.Entry<String, Object> entry : mapValue.entrySet()) {
            result.append(indent)
                    .append(entry.getKey())
                    .append(": ")
                    .append(stringify(entry.getValue(), nextDepth))
                    .append("\n");
        }
        result.append(bracketIndent).append("}");
        return result.toString();
    }
}
