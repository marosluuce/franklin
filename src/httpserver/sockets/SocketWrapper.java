package httpserver.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketWrapper implements HttpSocket {
    private Socket socket;

    public SocketWrapper(Socket socket) {
        this.socket = socket;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

    @Override
    public boolean isClosed() {
        return socket.isClosed();
    }
}
