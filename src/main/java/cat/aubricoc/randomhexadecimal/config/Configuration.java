package cat.aubricoc.randomhexadecimal.config;

import java.util.Objects;

public class Configuration {

    private final int port;

    public Configuration(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Override
    public int hashCode() {
        return Objects.hash(port);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Configuration other = (Configuration) obj;
        return port == other.port;
    }

    @Override
    public String toString() {
        return "Configuration: port = '" + port;
    }
}
