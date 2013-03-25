package httpserver;

import httpserver.sockets.HttpServerSocket;
import httpserver.sockets.HttpSocket;

import java.io.*;

public class Server {
    private HttpServerSocket serverSocket;
    private Router router;
    private RequestProcessor processor;

    public Server(HttpServerSocket serverSocket, Router router) throws IOException {
        this.router = router;
        this.serverSocket = serverSocket;
        int cores = Runtime.getRuntime().availableProcessors();
        processor = new RequestProcessor(cores);

    }

    public void run() throws IOException {
        while(!serverSocket.isClosed()) {
            HttpSocket client = serverSocket.accept();
            processor.submit(new RequestHandler(client, router));
        }

        close();
    }

    public boolean isBound() {
        return serverSocket.isBound();
    }

    public void close() throws IOException {
        serverSocket.close();
    }

    public boolean isClosed() {
        return serverSocket.isClosed();
    }
}
