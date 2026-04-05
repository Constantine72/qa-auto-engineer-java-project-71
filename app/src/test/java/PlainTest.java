import hexlet.code.Differ;
import hexlet.code.formatters.Plain;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlainTest {

    @Test
    void testConstructorIsPrivate() throws Exception {
        java.lang.reflect.Constructor<Plain> constructor = Plain.class.getDeclaredConstructor();
        assertTrue(java.lang.reflect.Modifier.isPrivate(constructor.getModifiers()),
                "Constructor must be private");
        constructor.setAccessible(true);
        assertThrows(java.lang.reflect.InvocationTargetException.class, constructor::newInstance);
    }
    @Test
    void testPlainRecursive() throws Exception {
        String filePath1 = "src/test/resources/fileNestedTest1.json";
        String filePath2 = "src/test/resources/fileNestedTest2.json";

        String result = Differ.generate(filePath1, filePath2, "plain");

        assertThat(result.contains("Property 'nestedKey.value1' was updated"));
    }
}
