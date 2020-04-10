import example.*;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Dispatcher dispatcher = new Dispatcher();
        Handlers handlers = new Handlers();

        controller.setDispatcher(dispatcher);
        dispatcher.setHandler(handlers);

        Request getRequest = new Request(HttpMethod.GET, "/hello");
        Response getResponse = controller.processRequest(getRequest);
        System.out.println(getResponse);

        Request postRequest = new Request(HttpMethod.POST, "/hello");
        Response postResponse = controller.processRequest(postRequest);
        System.out.println(postResponse);
    }
}
