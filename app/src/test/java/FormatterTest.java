import hexlet.code.InnerRep;
import hexlet.code.formatters.Formatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FormatterTest {
    private List<InnerRep> tree;

    @BeforeEach
    void setUp() {
        tree = List.of();
    }

    @Test
    void shouldFormatAsStylish() throws Exception {
        String result = Formatter.format(tree, "stylish");
        assertNotNull(result);
    }

    @Test
    void shouldFormatAsPlain() throws Exception {
        String result = Formatter.format(tree, "plain");
        assertNotNull(result);
    }

    @Test
    void shouldFormatAsJson() throws Exception {
        String result = Formatter.format(tree, "json");
        assertNotNull(result);
    }

    @Test
    void shouldThrowExceptionForUnknownFormat() throws Exception {
        assertThrows(IllegalStateException.class, () -> {
            Formatter.format(tree, "unknown format");

        });
    }
    @Test
    void testConstructorIsPrivate() throws NoSuchMethodException {
        Constructor<Formatter> constructor = Formatter.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()), "Constructor should be private");
        constructor.setAccessible(true);

        assertThrows(InvocationTargetException.class, constructor::newInstance);
    }
}
