package cat.aubricoc.randomhexadecimal.config;

import cat.aubricoc.randomhexadecimal.config.Configuration;
import cat.aubricoc.randomhexadecimal.config.ConfigurationParser;
import cat.aubricoc.randomhexadecimal.exception.InvalidPortParameterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConfigurationParserTest {

    @Test
    public void testParseNoArgs() {
        Configuration config = ConfigurationParser.parse();
        verifyResult(config, 8080);
    }

    @Test
    public void testParseEmptyString() {
        Configuration config = ConfigurationParser.parse("");
        verifyResult(config, 8080);
    }

    @Test
    public void testParseWithoutPortKeyword() {
        Configuration config = ConfigurationParser.parse("1234");
        verifyResult(config, 8080);
    }

    @Test
    public void testParseWithoutPortValue() {
        assertThrows(InvalidPortParameterException.class, () -> ConfigurationParser.parse("-port"));
    }

    @Test
    public void testParseWithPortValueInvalid() {
        assertThrows(InvalidPortParameterException.class, () -> ConfigurationParser.parse("-port", "a"));
    }

    @Test
    public void testParseWithPortValue() {
        Configuration config = ConfigurationParser.parse("-port", "1234");
        verifyResult(config, 1234);
    }

    private void verifyResult(Configuration config, int port) {
        assertNotNull(config);
        assertEquals(port, config.getPort());
    }
}
