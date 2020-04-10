package example;

import java.util.Optional;

public class Response {
    private final int statusCode;
    private final String description;
    private final Optional<String> bodyOpt;

    public Response(int statusCode, String description) {
        this(statusCode, description, null);
    }

    public Response(int statusCode, String description, String body) {
        this.statusCode = statusCode;
        this.description = description;
        this.bodyOpt = Optional.ofNullable(body);
    }

    public Optional<String> getBodyOpt() {
        return bodyOpt;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Response{" +
                "statusCode=" + statusCode +
                ", description='" + description + '\'' +
                ", bodyOpt=" + bodyOpt +
                '}';
    }
}
