import com.pusher.rest.Pusher;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;
import restapi.ITheMindRestHandler;
import restapi.TheMindRestHandler;
import themindwebsocketevent.ITheMindEvent;
import themindwebsocketevent.TheMindEvent;
import themindwebsocketlogic.ITheMindWebsocketLogic;
import themindwebsocketlogic.TheMindWebsocketLogic;
import themindwebsocketmessageprocessor.ITheMindWebsocketMessageProcessor;
import themindwebsocketmessageprocessor.TheMindWebsocketMessageProcessor;

import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Collections;

public class TheMindWebsocketMain  {
    private static final  int PORT = 8099;

    public static void main(String[] args) {

        //initiate all logic
        ITheMindRestHandler restHandler= new TheMindRestHandler();
        ITheMindWebsocketLogic logic = new TheMindWebsocketLogic(restHandler);
        ITheMindWebsocketMessageProcessor processor= new TheMindWebsocketMessageProcessor(logic);
        final ITheMindEvent socket = new TheMindEvent(logic,processor);

        logic.setEventSockets(socket);



        final Server webSocketServer = new Server();
        ServerConnector connector = new ServerConnector(webSocketServer);
        connector.setPort(PORT);
        webSocketServer.addConnector(connector);

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler webSocketContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        webSocketContext.setContextPath("/");
        webSocketServer.setHandler(webSocketContext);

        try {
            // Initialize javax.websocket layer
            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(webSocketContext);

            // Add websocket endpoint to javax.websocket layer
            ServerEndpointConfig config = ServerEndpointConfig.Builder.create(socket.getClass(), socket.getClass().getAnnotation(ServerEndpoint.class).value())
                    .configurator(new ServerEndpointConfig.Configurator() {
                        @Override
                        public <T> T getEndpointInstance(Class<T> endpointClass) {
                            return (T) socket;
                        }
                    })
                    .build();
            wscontainer.addEndpoint(config);
            webSocketServer.start();
            webSocketServer.join();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
