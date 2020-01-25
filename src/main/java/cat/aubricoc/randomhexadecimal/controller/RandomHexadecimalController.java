package cat.aubricoc.randomhexadecimal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomHexadecimalController extends AbstractHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RandomHexadecimalController.class);

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String number = RandomStringUtils.random(32, "0123456789ABCDEF");
        LOG.info("Generated hexadecimal number: {}", number);

        response.setContentType("text/plain; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(number);
        baseRequest.setHandled(true);
    }
}
