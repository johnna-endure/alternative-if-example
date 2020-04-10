package example;

public class Request {
    private final HttpMethod httpMethod;
    private final String url;

    public Request(HttpMethod httpMethod, String url) {
        this.httpMethod = httpMethod;
        this.url = url;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }
}
