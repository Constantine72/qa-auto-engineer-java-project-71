package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {

        try {

            Map<String, Object> data1 = Parser.parse(filePath1);
            Map<String, Object> data2 = Parser.parse(filePath2);

            Set<String> keys = new TreeSet<>();
            keys.addAll(data1.keySet());
            keys.addAll(data2.keySet());

            StringBuilder result = new StringBuilder();

            result.append("{\n");

            for (String key : keys) {

                if (!data1.containsKey(key)) {

                    result.append(" + ")
                            .append(key)
                            .append(": ")
                            .append(data2.get(key))
                            .append("\n");
                } else if (!data2.containsKey(key)) {

                    result.append(" - ")
                            .append(key)
                            .append(": ")
                            .append(data1.get(key))
                            .append("\n");
                } else if (!data1.get(key).equals(data2.get(key))) {

                    result.append(" - ")
                            .append(key)
                            .append(": ")
                            .append(data1.get(key))
                            .append("\n");

                    result.append(" + ")
                            .append(key)
                            .append(": ")
                            .append(data2.get(key))
                            .append("\n");
                } else {

                    result.append("   ")
                            .append(key)
                            .append(": ")
                            .append(data1.get(key))
                            .append("\n");
                }
            }
            result.append("}");

            return result.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);


        }


    }
}
