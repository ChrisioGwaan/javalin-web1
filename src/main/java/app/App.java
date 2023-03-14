package app;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the 
 * Javalin HTTP Server and our web application.
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class App {

    public static final int         JAVALIN_PORT    = 7000;
    public static final String      CSS_DIR         = "css/";
    public static final String      IMAGES_DIR      = "images/";

    public static void main(String[] args) {
        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
            
            // Uncomment this if you have files in the CSS Directory
            config.addStaticFiles(CSS_DIR);

            // Uncomment this if you have files in the Images Directory
            config.addStaticFiles(IMAGES_DIR);
        }).start(JAVALIN_PORT);


        // Configure Web Routes
        configureRoutes(app);
    }

    public static void configureRoutes(Javalin app) {
        // All webpages are listed here as GET pages
        app.get(HomePage.URL, new HomePage());
        app.get(Overview.URL, new Overview());
        app.get(IBC.URL, new IBC());
        app.get(DBC.URL, new DBC());
        app.get(CR.URL, new CR());
        // Add / uncomment POST commands for any pages that need web form POSTS
        // app.post(HomePage.URL, new HomePage());
        // app.post(Overview.URL, new Overview());
        app.post(IBC.URL, new IBC());
        app.post(DBC.URL, new DBC());
        app.post(CR.URL, new CR());
        // app.post(CP.URL, newCP());
        // app.post(Page6.URL, new Page6());
    }

}
