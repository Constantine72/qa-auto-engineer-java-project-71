package hexlet.code;

import java.util.List;
import java.util.Map;

import hexlet.code.formatters.Formatter;


public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {

        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);

        List<InnerRep> diffTree = TreeBuilder.buildTree(data1, data2);

        return Formatter.format(diffTree, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}



