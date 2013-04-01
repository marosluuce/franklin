package httpserver;

import httpserver.responders.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private Map<String, Responder> routes;

    public static Router getConfiguredRouter(File rootDir) {
        Router router = new Router();
        router.addRoute("filesystem", new FileSystemResponder(rootDir));
        router.addRoute("/redirect", new RedirectResponder("/"));
        router.addRoute("/parameters", new ParameterResponder());
        router.addRoute("/form", new PutPostResponder());
        router.addRoute("/hello", new HelloResponder());
        return router;
    }

    public Router() {
        routes = new HashMap<>();
    }

    public Map<String, Responder> getRoutes() {
        return routes;
    }

    public void addRoute(String path, Responder responder) {
        routes.put(path, responder);
    }

    public Map<String, Object> route(Map<String, Object> request) throws IOException {
        Responder responder = routes.get(request.get("Request-URI"));

        if (responder != null) {
            return responder.respond(request);
        }
        else {
            return routes.get("filesystem").respond(request);
        }
    }
}
