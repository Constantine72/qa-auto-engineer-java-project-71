package hexlet.code;

import java.util.List;
import java.util.Map;

public class Stylish {

    private static final int INDENT_STEP = 4;

    public static String format(List<InnerRep> diffTree) {

        return formatTree(diffTree, 1);
    }

    private static String formatTree(List<InnerRep> innerReps, int depth) {

        StringBuilder result = new StringBuilder();
        result.append(("{\n"));


        String indent = " ".repeat(depth * INDENT_STEP);
        String signIndent = " ".repeat(depth * INDENT_STEP - 2);

        for (InnerRep innerRep : innerReps) {

            switch (innerRep.getType()) {

                case "nested":
                    String nestedString = formatTree(innerRep.getChildren(), depth + 1);
                    result.append(indent).append(innerRep.getName()).append(": ").append(nestedString).append("\n");
                    break;

                case "added":
                    result.append(signIndent).append("+ ").append(innerRep.getName()).append(": ")
                            .append(stringify(innerRep.getValue2(), depth)).append("\n");
                    break;

                case "deleted":
                    result.append(signIndent).append("- ").append(innerRep.getName()).append(": ")
                            .append(stringify(innerRep.getValue1(), depth)).append("\n");
                    break;

                case "unchanged":
                    result.append(indent).append(innerRep.getName()).append(": ")
                            .append(stringify(innerRep.getValue1(), depth)).append("\n");
                    break;

                case "changed":
                    result.append(signIndent).append("- ").append(innerRep.getName()).append(": ")
                            .append(stringify(innerRep.getValue1(), depth)).append("\n");

                    result.append(signIndent).append("+ ").append(innerRep.getName()).append(": ")
                            .append(stringify(innerRep.getValue2(), depth)).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown node type: " + innerRep.getType());
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
