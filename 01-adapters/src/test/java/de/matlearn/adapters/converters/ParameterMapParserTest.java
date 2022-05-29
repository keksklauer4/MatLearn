package de.matlearn.adapters.converters;

import de.matlearn.domain.entities.MatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParameterMapParserTest {
    private static String INT_KEY = "int";
    private static String STR_KEY = "text";
    private static String LST_KEY = "list";
    private static String TYPE_KEY = "type";

    private ParameterMapParser parser;

    void initialize(Map<String, Object> map) {
        parser = new ParameterMapParser(map);
    }

    @Test
    void test_ParseValidInteger(){
        initialize(Map.ofEntries(
                Map.entry(INT_KEY, 1)
        ));
        Assertions.assertEquals(1, parser.parseInteger(INT_KEY));
    }

    @Test
    void test_NotExistingInteger(){
        initialize(Map.ofEntries());
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseInteger(INT_KEY));
    }

    @Test
    void test_InvalidInteger(){
        initialize(Map.ofEntries(Map.entry(INT_KEY, "string")));
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseInteger(INT_KEY));
    }


    @Test
    void test_ParseValidString(){
        initialize(Map.ofEntries(
                Map.entry(STR_KEY, "string")
        ));
        Assertions.assertEquals("string", parser.parseString(STR_KEY));
    }

    @Test
    void test_InvalidString(){
        initialize(Map.ofEntries(
                Map.entry(STR_KEY, 1)
        ));
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseString(STR_KEY));
    }

    @Test
    void test_ValidNonemptyIntegerList(){
        List<Integer> expected = Arrays.asList(1,2,3);
        initialize(Map.ofEntries(
                Map.entry(LST_KEY, expected)
        ));
        List<Integer> res = parser.parseIntegerList(LST_KEY);
        Assertions.assertEquals(3, res.size());
        Assertions.assertTrue(res.containsAll(expected));
    }

    @Test
    void test_ValidEmptyIntegerList(){
        initialize(Map.ofEntries(
                Map.entry(LST_KEY, new ArrayList<Integer>())
        ));
        List<Integer> res = parser.parseIntegerList(LST_KEY);
        Assertions.assertTrue(res.isEmpty());
    }

    @Test
    void testInvalidEmptyIntegerList(){
        initialize(Map.ofEntries(
                Map.entry(LST_KEY, new ArrayList<String>())
        ));
        List<Integer> res = parser.parseIntegerList(LST_KEY);
        Assertions.assertTrue(res.isEmpty());
    }

    @Test
    void testInvalidNonemptyIntegerList(){
        initialize(Map.ofEntries(
                Map.entry(LST_KEY, Arrays.asList("string1", "string2"))
        ));
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseIntegerList(LST_KEY));
    }

    @Test
    void test_ParseValidMatType(){
        initialize(Map.ofEntries(
                Map.entry(TYPE_KEY, MatType.COROLLARY)
        ));
        Assertions.assertEquals(MatType.COROLLARY, parser.parseMatType(TYPE_KEY));
    }

    @Test
    void test_InvalidMatType(){
        initialize(Map.ofEntries(
                Map.entry(TYPE_KEY, "Test")
        ));
        Assertions.assertThrows(RuntimeException.class, () -> parser.parseMatType(TYPE_KEY));
    }
}
