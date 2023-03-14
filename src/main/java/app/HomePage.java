package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class HomePage implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + "<meta charset=\"utf-8\">" +
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='bootstrap.css'/>";
        html = html + "<style>" + 
                            "h1 {" +
                                "font-size: 50x;" +
                                "font-family: Georgia, serif;" +
                                "text-align: left;" +
                            "}" +
                            "p {" +
                                "font-size: 20px;" +
                            "}" + 
                                "#test1 {" +
                                "background-color: #d41717;" +
                            "}" +
                            ".topnav {" +
                                "overflow: hidden;" +
                                "background-color: rgb(255, 255, 255);" +
                            "}" +
                            ".topnav a {" +
                                "float: left;" +
                                "color: #f2f2f2;" +
                                "text-align: center;" +
                                "padding: 14px 16px;" +
                                "text-decoration: none;" +
                                "font-size: 17px;" +
                            "}" +
                            ".topnav a:hover {" +
                                "background-color: #d41717;" +
                                "color: #d41717;" +
                            "}" +
                                "#test2 {" +
                                "background-color: #5e4391;" +
                            "}" +
                            "</style>";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Vaccine Information
        html = html + "<div id='test1'>" +
        "<p style=\"font-family:roboto; color:#ffe240; font-size: 20px;\"> <b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>Check if you are eligible for Covid-19 vaccine and book an appointment.</b></u></p>" +
        "</div>";
        
        // Navigation Bar "Search"
        html = html + "<form class=\"navbar-form navbar-right\" role=\"search\">" + 
                      "<div class=\"form-group\">" + 
                            "<input type=\"text\" class=\"form-control\" placeholder=\"Type something\">" +
                      "</div>";
        // Navigation Bar "Search Button"
        html = html + "<button type=\"submit\" class=\"btn btn-primary\">Search</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                      "</form></nav></div>";

        //LOGO Bar
        html = html + "<div class='topnav'>" +
        "&nbsp&nbsp&nbsp<img src=\"logo.png\" alt=\"...\" width=\"140\" height=\"55\">" +
        "</div>";

        // Navigation Bar "LOGO"
        html = html + "<div class=\"container\" style=\"margin:20px\">" +
                      "<nav class=\"navbar navbar-default\" role=\"navigation\" style=\"padding-right:20px\">" +
                            "<div class=\"navbar-header\">" + 
                      "</div>";

        // Navigation Bar "All the lists"
        html = html + "<ul class=\"nav navbar-nav\">" + 
                            "<li class=\"active\"><a href=\"/\">Home</a></li>" + 
                            "<li><a href=\"Overview.html\">Overview</a></li>" + 
                            "<li><a href=\"IBC.html\">Infections By Country</a></li>" + 
                            "<li><a href=\"DBC.html\">Death By Country</a></li>" + 
                            "<li><a href=\"CR.html\">Cumulative Report</a></li>" +
                      "</ul>" +
                      "</nav>";

        // Landing Page Content
        html = html +   "<div id='test2'>" +
                            "<br>" +
                            "<h1 style=\"font-family:montserrat; color:ffffff; font-size: 50px;\"><b>&nbsp&nbsp&nbspCoronavirus (Covid-19) &nbsp;&nbsp;<img src=\"covid-19.png\" alt=\"...\" width=\"100\" height=\"100\"></b></h1>" +
                            "<br>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspThe latest offical coronavirus news, updates and advice from the World Health Organization.</p>" +
                            "<br>" +
                            "<h2 style=\"font-family:montserrat; color:ffffff; font-size: 40px;\"><b>&nbsp&nbsp&nbspCoronavirus Hotline</b></h2>" +
                            "<br>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspIf you suspect you may have coronavirus (COVID-19) call the dedicated hotline - open 24 hours, 7 days.</p>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPlease keep Tripple Zero (000) for emergencies only.</p>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 30px;\"><b>&nbsp&nbsp&nbsp&nbsp ☎ 1800 675 398</b></p>" +
                            "<h3 style=\"font-family:montserrat; color:ffffff; font-size: 40px;\"><b>&nbsp&nbsp&nbspAnnouncements</b></h3>" +
                            "<br>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&#9888; Updated COVIDSafe Setting from Thursday 17 June 2021</p>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&#9888; Case Alerts - public exposure sites </p>" +
                            "<p style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&#9888; Book your vaccine appointment </p>" +
                            "<br>"+

                            "<p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + 
                            "<u style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">Information in your language</u> ->" +
                            "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                            "<u style=\"font-family:montserrat; color:ffffff; font-size: 20px;\">Contacts for emergency support</u> ->" +
                            "</p>" +
                            "<br>" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"linkedin.png\" alt=\"...\" width=\"50\" height=\"50\">" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"twitter.png\" alt=\"...\" width=\"50\" height=\"50\">" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"facebook.png\" alt=\"...\" width=\"50\" height=\"50\">" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"instagram.png\" alt=\"...\" width=\"50\" height=\"50\">"+
                            "&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"youtube.png\" alt=\"...\" width=\"50\" height=\"50\">"+
                            "<br>" +
                            "<br>" +
                            "<br>" +
                            "<br>" +
                            "</div>";

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
