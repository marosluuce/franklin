package httpserver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RequestProcessor {
    private ExecutorService threadPool;

    public RequestProcessor(int threads) {
        threadPool = Executors.newFixedThreadPool(threads);
    }

    public Future<?> submit(RequestHandler handler) {
        return threadPool.submit(handler);
    }
}
