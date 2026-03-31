package hexlet.code.formatters;

import hexlet.code.InnerRep;

import java.util.List;


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

}
