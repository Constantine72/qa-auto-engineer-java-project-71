package hexlet.code;

import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;
import java.nio.file.Path;


import hexlet.code.formatters.Formatter;


public final class Differ {

    private Differ() {
        throw new IllegalStateException("Utility class");
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {

        Path fullPath1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path fullPath2 = Paths.get(filePath2).toAbsolutePath().normalize();


        String content1 = Files.readString(fullPath1);
        String content2 = Files.readString(fullPath2);

        String dataType1 = getDataType(filePath1);
        String dataType2 = getDataType(filePath2);


        Map<String, Object> data1 = Parser.parse(content1, dataType1);
        Map<String, Object> data2 = Parser.parse(content2, dataType2);

        List<InnerRep> diffTree = TreeBuilder.buildTree(data1, data2);

        return Formatter.format(diffTree, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {

        return generate(filePath1, filePath2, "stylish");
    }

    private static String getDataType(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index == -1 ? "" : filePath.substring(index + 1);
    }
}



