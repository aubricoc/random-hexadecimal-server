package cat.aubricoc.randomhexadecimal;

import cat.aubricoc.randomhexadecimal.config.Configuration;
import cat.aubricoc.randomhexadecimal.config.ConfigurationParser;
import cat.aubricoc.randomhexadecimal.controller.RandomHexadecimalController;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ServerRunner.class);

    public static void main(String... args) {
        LOG.info("Random Hexadecimal Server starts...");
        try {
            Configuration config = ConfigurationParser.parse(args);
            Server server = new Server(config.getPort());
            server.setHandler(new RandomHexadecimalController());
            server.start();
            server.join();
            LOG.info("Random Hexadecimal Server finished!");
        } catch (Exception e) {
            LOG.error("Failed Random Hexadecimal Server", e);
        }
    }
}
