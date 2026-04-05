package hexlet.code;

import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;


import hexlet.code.formatters.Formatter;


public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {


        String content1 = readFile(filePath1);
        String content2 = readFile(filePath2);

        String dataType1 = getDataType(filePath1);
        String dataType2 = getDataType(filePath2);


        Map<String, Object> data1 = Parser.parse(content1, dataType1);
        Map<String, Object> data2 = Parser.parse(content2, dataType2);

        List<InnerRep> diffTree = TreeBuilder.buildTree(data1, data2);

        return Formatter.format(diffTree, formatName);
    }

    private static String readFile(String filePath) throws IOException {
        Path fullPath = Paths.get(filePath).toAbsolutePath().normalize();
        if (!Files.exists(fullPath)) {
            throw new IOException("File not found: " + fullPath);
        }
        return Files.readString(fullPath);
    }

    private static String getDataType(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index == -1 ? "" : filePath.substring(index + 1);
    }

}



