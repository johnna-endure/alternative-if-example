package example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class Dispatcher {
    private Handlers handler;

    public void setHandler(Handlers handler) {
        this.handler = handler;
    }

    public Response dispatch(Request request) {
        Optional<Method> handlerOpt = findHandler(request.getHttpMethod(), request.getUrl());
        if(handlerOpt.isEmpty()) {
            return new Response(400,"bad request");
        }
        try {
            return (Response) handlerOpt.get().invoke(handler);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return new Response(500, "method invoke error");
        }
    }

    private Optional<Method> findHandler(HttpMethod httpMethod, String url) {
        Method[] methods = handler.getClass().getMethods();
        return Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(RequestMapping.class))
                .filter(m -> m.getAnnotation(RequestMapping.class).method().equals(httpMethod))
                .filter(m -> m.getAnnotation(RequestMapping.class).url().equals(url))
                .findFirst();
    }
}
