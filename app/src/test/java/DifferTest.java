import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testFlatJsonComparison() throws Exception {

        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        String actual = Differ.generate(path1, path2);

        assertEquals(expected, actual);
    }

    @Test
    public void testFlatYamlComparison() throws Exception {

        String path1 = "src/test/resources/file1.yml";
        String path2 = "src/test/resources/file2.yml";

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        String actual = Differ.generate(path1, path2);

        assertEquals(expected, actual);
    }

    @Test
    public void testNestedJsonComparison() throws Exception {

        String path1 = "src/test/resources/fileNested1.json";
        String path2 = "src/test/resources/fileNested2.json";

        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {
                        nestedKey: value
                        isNested: true
                    }
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        String actual = Differ.generate(path1, path2);

        assertEquals(expected, actual);
    }

    @Test
    public void testNestedYamlComparison() throws Exception {

        String path1 = "src/test/resources/fileNested1.yml";
        String path2 = "src/test/resources/fileNested2.yml";

        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {
                        nestedKey: value
                        isNested: true
                    }
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        String actual = Differ.generate(path1, path2);

        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFormat() throws Exception {

        String expectedPlain = Files.readString(Path.of("src/test/resources/expectedPlain.txt"))
                .replace("\r\n", "\n")
                .trim();

        String actualPlain = Differ.generate("src/test/resources/fileNested1.json",
                "src/test/resources/fileNested2.json", "plain")
                        .trim();

        assertEquals(actualPlain, expectedPlain);
    }
}



