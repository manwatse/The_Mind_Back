public class TheMindWebsocketMain  {
    private static final  int PORT = 8099;

    public static void main(String[] args) {
        //initiate all logic


//        ITheMindEvent socket = new TheMindEvent():



//        Server webSocketServer = new Server();
//        ServerConnector connector = new ServerConnector(webSocketServer);
//        connector.setPort(PORT);
//        webSocketServer.addConnector(connector);
//
//        // Setup the basic application "context" for this application at "/"
//        // This is also known as the handler tree (in jetty speak)
//        ServletContextHandler webSocketContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        webSocketContext.setContextPath("/");
//        webSocketServer.setHandler(webSocketContext);
//
//        try {
//            // Initialize javax.websocket layer
//            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(webSocketContext);
//
//            // Add websocket endpoint to javax.websocket layer
//            ServerEndpointConfig config = ServerEndpointConfig.Builder.create(socket.getClass(), socket.getClass().getAnnotation(ServerEndpoint.class).value())
//                    .configurator(new ServerEndpointConfig.Configurator() {
//                        @Override
//                        public <T> T getEndpointInstance(Class<T> endpointClass) {
//                            return (T) socket;
//                        }
//                    })
//                    .build();
//            wscontainer.addEndpoint(config);
//            webSocketServer.start();
//            webSocketServer.join();
//
//        } catch (Exception ex) {
//            Logger.getInstance().log(ex);
//        }

    }
}
