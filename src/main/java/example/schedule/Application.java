package example.schedule;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public final class Application {
  private Application() {}
  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 8004), 0);
    server.createContext("/health", exchange -> { byte[] body = "{\"status\":\"ok\"}".getBytes(); exchange.sendResponseHeaders(200, body.length); exchange.getResponseBody().write(body); exchange.close(); });
    server.start();
  }
}
