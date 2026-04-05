import hexlet.code.formatters.JSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonTest {
    @Test
    void testConstructorIsPrivate() throws Exception {
        java.lang.reflect.Constructor<JSON> constructor = JSON.class.getDeclaredConstructor();
        assertTrue(java.lang.reflect.Modifier.isPrivate(constructor.getModifiers()),
                "Constructor must be private");
        constructor.setAccessible(true);
        assertThrows(java.lang.reflect.InvocationTargetException.class, constructor::newInstance);
    }
}
