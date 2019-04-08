import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HTTPQueryParserTest {
    @Test
    public void shouldReturnKeyCountAs1() {
        HTTPQueryParser httpQueryParser = new HTTPQueryParser("key1=value1");

        int count = httpQueryParser.count();

        assertEquals(1, count);
    }

    @Test
    public void shouldReturn2WhenThereAre2KeyValuePairs() {
        HTTPQueryParser httpQueryParser = new HTTPQueryParser("key1=value1&key2=value2");

        int count = httpQueryParser.count();

        assertEquals(2, count);
    }

    @Test
    public void shouldReturnValue1ForKey1() {
        HTTPQueryParser httpQueryParser = new HTTPQueryParser("key1=value1");

        String value = httpQueryParser.valueFor("key1");

        assertEquals("value1", value);
    }

    @Test
    public void shouldReturnValue2ForKey2() {
        HTTPQueryParser httpQueryParser = new HTTPQueryParser("key1=value1&key2=value2");

        String value = httpQueryParser.valueFor("key2");

        assertEquals("value2", value);
    }

    @Test
    public void shouldReturn0IfQueryStringIsEmpty() {
        HTTPQueryParser httpQueryParser = new HTTPQueryParser("");

        int count = httpQueryParser.count();

        assertEquals(0, count);
    }
}
