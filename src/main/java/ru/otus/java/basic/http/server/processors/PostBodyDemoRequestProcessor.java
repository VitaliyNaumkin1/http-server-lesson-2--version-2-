package ru.otus.java.basic.http.server.processors;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.entities.Product;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PostBodyDemoRequestProcessor implements RequestProcessor {
    private final Logger logger = LogManager.getLogger(PostBodyDemoRequestProcessor.class.getName());
    private Gson gson;

    public PostBodyDemoRequestProcessor() {
        gson = new Gson();
    }

    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        Product product = gson.fromJson(httpRequest.getBody(), Product.class);
        logger.info(product);
        String body = gson.toJson(product);
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body></body></html>" + body;
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
