package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Overview implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/Overview.html";

    @Override
    public void handle(Context context) throws Exception {
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + "<meta charset=\"utf-8\">" +
               "<title>Overview</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='bootstrap.css' />";
        html = html + "<style>" + 
        "h1 {" + 
        "font-size: 50x;" +
        "font-family: Georgia, serif;" +
    "}" +
    "p {" +
            "font-size: 20px;" +
            "color:#f7ba7b;" +
        "}" +
                        ".a-container {" +
                            "display: grid;" +
                            "grid-template-columns: auto auto;" + 
                            "background-color: rgb(255, 255, 255);" +
                          
                        
                        "}" + 
                        ".b-container {" +
                            "display: grid;" +
                            "grid-template-columns: auto auto auto;" + 
                            "background-color: rgb(255, 255, 255);" +
                           
                        "}" +
                        ".c-container {" +
                            "display: grid;" +
                            "grid-template-columns: auto;" + 
                            "background-color: rgb(255, 255, 255);" +
                            
                        "}";
        html = html + ".grid-item {" +
                            "background-color: #5e4391;" + 
                            "border: 1px solid #5e4391;" +
                            "padding: 10px;" +
                            "font-size: 25px;" +
                            "text-align: center;" +
                        "}" + 
                        ".grid-item2{" +
                        "font-family:roboto;" +
                        "color:#ffe240;" +
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
                            "padding: 14px 16px;" +
                            "text-decoration: none;" +
                            "font-size: 17px;" +
                        "}" +
                        ".topnav a:hover {" +
                            "background-color: #ddd;" +
                            "color: rgb(255, 255, 255);" +
                        "}" +
                        "#test2 {" +
                            "font-size: 50x;" +
                            "font-family: Georgia, serif;" +
                            "background-color: #5e4391;" +
                            "text-align: centre;" +
                        "hr {" +
                             "position: relative;" +
                            "top: 20px;" +
                            "border: none;" +
                            "height: 12px;" +
                            "background: black;" +
                            "margin-bottom: 50px;" +
                        "}" +
                        ".vl {" +
                            "border-left: 6px solid #ffffff;" +
                            "height: 500px;" +
                        "}" +
                    "</style>";

        // JavaScript
        html = html + "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>" +
        "<script type=\"text/javascript\">" +
          "google.charts.load('current', {" +
            "'packages':['geochart']," +
            "'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'" +
          "});" +
          "google.charts.setOnLoadCallback(drawRegionsMap);" +
    
          "function drawRegionsMap() {" +
            "var data = google.visualization.arrayToDataTable([" +
            "['Country', 'Cases']," +
            "['US', 31953125]," +
            "['India', 16263695]," +
            "['Brazil', 14167973]," +
            "['France', 5625638]," +
            "['Russia', 4682573]," +
            "['Turkey', 4501382]," +
            "['United Kingdom', 4423570]," +
            "['Italy', 3921241]," +
            "['Spain', 3626392]," +
            "['Germany', 3254609]," +
            "['Argentina', 2796768]," +
            "['Poland', 2731256]," +
            "['Iran', 2335905]," +
            "['Mexico', 2319596]," +
            "['Ukraine', 2043901]," +
            "['Peru', 1734606]," +
            "['Indonesia', 1626812]," +
            "['Czechia', 1617260]," +
            "['Netherlands', 1460753]," +
            "['Canada', 1164082]," +
            "['Austria', 602494]," +
            "['Japan', 553362]," +
            "['China', 102347]," +
            "['Australia', 29838]," +
            "['New Zealand', 2608]," +
            "]);" +
            "var options = {colorAxis: {colors: ['#E9FFDF', '#2F9300']}};" +
    
            "var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));" +
    
            "chart.draw(data, options);" +
          "}" +
        "</script>";

        // Add the body
        html = html + "</head>" + "<body>";

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
                            "<li><a href=\"/\">Home</a></li>" + 
                            "<li class=\"active\"><a href=\"Overview.html\">Overview</a></li>" + 
                            "<li><a href=\"IBC.html\">Infections By Country</a></li>" + 
                            "<li><a href=\"DBC.html\">Death By Country</a></li>" + 
                            "<li><a href=\"CR.html\">Cumulative Report</a></li>" +
                      "</ul>" +
                      "</nav>";

        // Latest Global Numbers
        html = html + "<div id='test2'>" +
        "<br>" +
        "<div class=\"vl\">" + 
          "<h1 style=\"text-align: center; font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Latest Global Numbers</h1>" +
                      "<div class=\"a-container\">" +
                            "<div class=\"grid-item\"><p>" + 
                            jdbc.countCases("SELECT SUM(comfirmedcase) AS Cases From Cases WHERE date = '2021-04-22';", "Cases") +
                            "</p>" + 
                            "<p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Cases Required Globally</b></p>" + 
                            "<p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>(Last 24 Hours)</p>" + 
                        "</div>" +
                        "<div class=\"grid-item\"><p>" +
                            jdbc.countCases("SELECT SUM(totalcases) AS Total FROM Region;", "Total") +  
                            "</p>" +
                            "<p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Total Cases Globally</p>" + 
                        "</div>" +
                        "<div class=\"grid-item\"><p>" + 
                            jdbc.countCases("SELECT SUM(death) AS Cases From Cases WHERE date = '2021-04-22';", "Cases") + 
                            "</p>" +
                            "<p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Lives Lost</p>" +
                            "<p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>(Last 24 Hours)</p>" + 
                        "</div>" +
                        "<div class=\"grid-item\"><p>" +
                            jdbc.countCases("SELECT SUM(totaldeath) AS Total FROM Region;", "Total") +
                            "</p>" +
                            "<p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Total Lives Lost Globally</p>" + 
                        "</div>" +
                        "</div>" +
                      "</div>";

        // Add New Line
        html = html + "<br>";
        html = html + "<hr>";
        // Top 3 Affected Countries by Covid-19
        html = html + "<br>" +
        "<h1 style=\"text-align: center;font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Top 3 Affected Countries by Covid-19</h1>" +
                      "<div class=\"b-container\">" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>United States</b>" +
                                "<p>" + 
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'US';", "Cases") + 
                                "</p>" + 
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>India</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'India';", "Cases") + 
                                "</p>" + 
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Brazil</b>" +
                                "<p>" + 
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Brazil';", "Cases") +
                                "</p>" + 
                            "</div>" +
                      "</div>";

        // Add New Line
        html = html + "<br>";
        html = html + "<hr>";
        //Top 10 Affected Countries by Covid-19
        html = html + "<br>" +
        "<h1 style=\"text-align: center;font-family:roboto; color:#ffffff; font-size: 20px;\"><b>Top 10 Affected Countries by Covid-19</b></h1>" +
                      "<div class=\"c-container\">" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>1. United States</b>" +
                                "<p>" + 
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'US';", "Cases") +
                                "</p>" + 
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>2. India</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'India';", "Cases") +
                                "</p>" + 
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>3. Brazil</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Brazil';", "Cases") +
                                "</p>" + 
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>4. France</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'France';", "Cases") +
                                "</p>" +  
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>5. Russia</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Russia';", "Cases") +
                                "</p>" +  
                            "</div>" +      
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>6. Turkey</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Turkey';", "Cases") +
                                "</p>" +  
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>7. United Kingdom</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'United Kingdom';", "Cases") +
                                "</p>" +  
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>8. Italy</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Italy';", "Cases") +
                                "</p>" +  
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>9. Spain</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Spain';", "Cases") +
                                "</p>" +  
                            "</div>" +
                            "<div class=\"grid-item\"><p style=\"font-family:roboto; color:#ffffff; font-size: 20px;\"><b>10. Germany</b>" +
                                "<p>" +
                                jdbc.countCases("SELECT SUM(totalcases) AS Cases FROM Region WHERE countryregion = 'Germany';", "Cases") +
                                "</p>" + 
                            "</div>" +
                      "</div>"+
                      "</div>";
                      
        html = html + "<div id=\"regions_div\" style=\"width: 1200px; height: 675px;\"></div>";

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
