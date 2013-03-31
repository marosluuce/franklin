package httpserver.responders;

import httpserver.Utilities;

import java.io.IOException;
import java.util.Map;

public class HelloResponder implements Responder {
    @Override
    public Map<String, Object> respond(Map<String, Object> request) throws IOException {

        Map<String, String> parameters = (Map<String, String>) request.get("Parameters");
        byte[] body = Utilities.toBytes(String.format("Hello, ", parameters.get("name")));

        Map<String, String> headers = Utilities.getCommonHeader("text/html", body.length);
        return Utilities.generateResponse(Utilities.statusLine(200), headers, body);
    }
}
