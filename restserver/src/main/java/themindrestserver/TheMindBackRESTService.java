package themindrestserver;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class TheMindBackRESTService  {

    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        Server jettyServer = new Server(8091);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);


        TheMindFirebaseResponse.setRestLogic(new TheMindRESTLogic(new TheMindFirebaseDB()));
        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
                TheMindFirebaseResponse.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
