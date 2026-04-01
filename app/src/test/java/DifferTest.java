import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;


    @BeforeAll
    public static void beforeAll() throws Exception {

        expectedStylish = readFixture("expectedStylish.txt");
        expectedPlain = readFixture("expectedPlain.txt");
        expectedJson = readFixture("expectedJson.json");
    }

    @Test
    void testJsonToAllFormats() throws Exception {
        String filePath1 = "src/test/resources/fileNested1.json";
        String filePath2 = "src/test/resources/fileNested2.json";

        assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(expectedJson);

        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(expectedStylish);
    }

    @Test
    void testYamlToAllFormats() throws Exception {
        String file1 = "src/test/resources/fileNested1.yml";
        String file2 = "src/test/resources/fileNested2.yml";

        assertThat(Differ.generate(file1, file2, "stylish")).isEqualTo(expectedStylish);
        assertThat(Differ.generate(file1, file2, "plain")).isEqualTo(expectedPlain);
        assertThat(Differ.generate(file1, file2, "json")).isEqualTo(expectedJson);

        assertThat(Differ.generate(file1, file2)).isEqualTo(expectedStylish);

    }

    public static String readFixture(String fileName) throws Exception {
        Path filePath = Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
        return Files.readString(filePath).replace("\r\n", "\n").trim();
    }
}


