package intergrationTest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.*;
import restclient.TheMindRestClient;
import shared.PlayerScoreDTO;
import themindrestserver.ITheMindFirebaseDB;
import themindrestserver.TheMindFirebaseDB;
import themindrestserver.TheMindFirebaseResponse;
import themindrestserver.TheMindRESTLogic;

import java.util.List;

public class TheMindRestIntergrationTest {

    private  static TheMindRestClient restClient;


    public  TheMindRestIntergrationTest(){

    }

    @BeforeClass
    public static void setUpClass() {

        // Start the Pet Store Server
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        final Server jettyServer = new Server(8090);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
                TheMindFirebaseResponse.class.getCanonicalName());
        TheMindFirebaseResponse.setRestLogic(new TheMindRESTLogic(new databaseStub()));
        // Start the jetty server in a separate thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    jettyServer.start();
                    jettyServer.join();
                } catch (Exception ex) {
                    System.out.println(ex);
                } finally {
                    jettyServer.destroy();
                }
            }

        });
        thread.start();


        restClient = new TheMindRestClient();
    }
    @AfterClass
    public static void tearDownClass() {

    }

    @Test
    public void testRestServer() throws InterruptedException{

        //add player
        PlayerScoreDTO createTest = restClient.createPlayer("test1",0);
        Assert.assertEquals("test1",createTest.getName());
        Assert.assertEquals(0,createTest.getScore());

        //get player
        PlayerScoreDTO getTest = restClient.getPlayer("test1");
        Assert.assertEquals("test1",getTest.getName());
        Assert.assertEquals(0,getTest.getScore());

        //set player score
        boolean setTest = restClient.setPlayerScore("test1",0);
        Assert.assertEquals(true,setTest);

        //get all players
        List<PlayerScoreDTO>  getAllTest = restClient.getAllScores();
        Assert.assertEquals(6,getAllTest.size());

    }



}
