package example;

public class Handlers {
    @RequestMapping(method = HttpMethod.GET, url = "/hello")
    public Response hello_GET() {
        return new Response(200,"hello, client","getBody");
    }

    @RequestMapping(method = HttpMethod.POST, url = "/hello")
    public Response hello_POST() {
        return new Response(200,"hello, client", "postBody");
    }

}

