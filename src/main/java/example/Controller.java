package example;/*
example.Request 받아 처리를 위임하고
Response를 반환합니다.
 */

public class Controller {
    Dispatcher dispatcher;

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Response processRequest(Request request) {
        /*
            전처리 코드
         */
        Response response = dispatcher.dispatch(request);
        /*
            후처리 코드
         */
        return response;
    }
}
