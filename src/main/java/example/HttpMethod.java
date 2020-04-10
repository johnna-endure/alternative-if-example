package example;

public enum HttpMethod {
    GET(1),
    POST(2);

    private final int code;

    HttpMethod(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
