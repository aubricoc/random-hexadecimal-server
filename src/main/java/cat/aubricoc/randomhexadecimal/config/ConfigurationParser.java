package cat.aubricoc.randomhexadecimal.config;

import cat.aubricoc.randomhexadecimal.exception.InvalidPortParameterException;
import org.apache.commons.lang3.math.NumberUtils;

public class ConfigurationParser {

    private static final String PORT_KEYWORD = "-port";
    private static final int DEFAULT_PORT = 8080;

    private ConfigurationParser() {
        throw new UnsupportedOperationException();
    }

    public static Configuration parse(String... args) {
        int port = DEFAULT_PORT;
        if (args != null) {
            int iter = 0;
            while (iter < args.length) {
                String arg = args[iter];
                if (PORT_KEYWORD.equals(arg)) {
                    iter++;
                    port = parsePortValue(args, iter);
                }
                iter++;
            }
        }
        return new Configuration(port);
    }

    private static int parsePortValue(String[] args, int iter) {
        if (iter < args.length) {
            String arg = args[iter];
            if (NumberUtils.isDigits(arg)) {
                return Integer.parseInt(arg);
            }
        }
        throw new InvalidPortParameterException();
    }
}
