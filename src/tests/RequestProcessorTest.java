package tests;

import httpserver.RequestHandler;
import httpserver.RequestProcessor;
import httpserver.Router;
import org.junit.Test;
import tests.mocks.Mocket;
import tests.mocks.MocketWrapper;

import java.util.concurrent.Future;

import static org.junit.Assert.assertTrue;

public class RequestProcessorTest {
    @Test
    public void testRequestProcessed() {
        MocketWrapper client = new MocketWrapper(new Mocket(null, null));
        RequestProcessor processor = new RequestProcessor(1);
        Future<?> job = processor.submit(new RequestHandler(client, new Router()));

        int tries = 10;
        for (int i = 0; i < tries; i++) {
            try {
                assertTrue(job.isDone());
            }
            catch (AssertionError e) {
                if (i == tries) {
                    throw e;
                }
            }
        }
    }
}
