package ru.otus.java.basic.http.server.processors;

import ru.otus.java.basic.http.server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class UnknownRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        String response =
                "HTTP/1.1 404 Not Found\n" +
                        "Content-Type: text/html\n" +
                        "Content-Length: 216\n" +
                        "\n" +
                        "<html>\n" +
                        "  <head>\n" +
                        "    <title>Resource Not Found</title>\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "    <h1>404 page not found.</h1>\n" +
                        "  </body>\n" +
                        "</html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
