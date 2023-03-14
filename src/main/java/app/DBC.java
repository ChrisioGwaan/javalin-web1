package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DBC implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/DBC.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Deaths by Country</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='bootstrap.css' />";
        html = html +   "<style>" + 
                        ".content-table {" +
                            "border-collapse: collapse;" +
                            "margin: 25px 0;" +
                            "font-size: 0.9em;" +
                            "min-width: 400px;" +
                            "border-radius: 5px 5px 0 0;" +
                            "overflow: hidden;" +
                        "}" +
                        ".content-table thead tr {" +
                            "background-color: #009879;" +
                            "color: #ffffff;" +
                            "text-align: left;" +
                            "font-weight: bold;" +
                        "}" +
                        ".content-table th, .content-table td {" +
                            "padding: 12px 15px;" +
                            "text-align: center;" +
                        "}" +
                        ".content-table tbody tr {" +
                            "border-bottom: 1px solid #dddddd;" +
                        "}" +
                        ".content-table tbody tr:nth-of-type(even) {" +
                            "background-color: #f3f3f3;" +
                        "}" +
                        "h1 {" +
                            "font-size: 50px;" +
                            "font-family: Georgia, serif;" +
                            "text-align: center;" +
                        "}" +
                        "h2 {" +
                            "text-align: center;" +
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
                    "</style>";

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
                            "<li><a href=\"/\">Home</a></li>" + 
                            "<li><a href=\"Overview.html\">Overview</a></li>" + 
                            "<li><a href=\"IBC.html\">Infections By Country</a></li>" + 
                            "<li class=\"active\"><a href=\"DBC.html\">Death By Country</a></li>" + 
                            "<li><a href=\"CR.html\">Cumulative Report</a></li>" +
                      "</ul>" +
                      "</nav>";

        

        // BEGIN: Infections By Country Content 
        html = html + "<h1 style=\"text-align: centre; font-family:montserrat; color:000000; font-size: 40px;\"><b>Deaths By Country</h1>";

        // Sort and Search Button
        html = html +   "<form action=\'/DBC.html\' method=\'post\' class=\"navbar-form navbar-center\" role=\"search\">" +
                            "<div class=\'form-group\'>" +
                                "<label for=\'Sort_Drop\'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                                "Sort By(Highest/Lowest):</label>" +
                                "<select id=\'Sort_drop\' name=\'Sort_drop\'>" +
                                    "<option>None</option>" +
                                    "<option>Highest</option>" +
                                    "<option>Lowest</option>" +
                                "</select>" +
                            "</div>" +
                            "<div class='form-group'>" +
                                "<label for='Sort_textbox'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                                "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                                "Select By Country: </label>" +
                                "<input class='form-control' id='Sort_textbox' name='Sort_textbox'>" +
                            "</div>" +
                                "<button type=\"submit\" class=\"btn btn-primary\">Submit</button>" +
                        "</form>";
        
        // Dropdown Process
        String Sort_drop = context.formParam("Sort_drop");
        if (Sort_drop == null || Sort_drop.equals("None")) {
            html = html + outputDeaths("None");
        } else {
            html = html + outputDeaths(Sort_drop);
        }

        String Sort_textbox = context.formParam("Sort_textbox");
        if (Sort_textbox == null || Sort_textbox == "") {
            html = html + outputTextBoxResults2("None");
        } else {
            Sort_textbox = Sort_textbox.substring(0, 1).toUpperCase() + Sort_textbox.substring(1);
            html = html + outputTextBoxResults2(Sort_textbox);
        }

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

    public String outputDeaths(String type) {
        String html = "";

        if (type.equals("Highest")) {
            html = html + "<h2>Sort By <strong>" + type + "</strong>.</h2>";
            type = "DESC";
        }
        else if (type.equals("Lowest")) {
            html = html + "<h2>Sort By <strong>" + type + "</strong>.</h2>";
            type = "ASC";
        }
        else {
            type = "";
            html = html + "";
        }

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> names = jdbc.getCountryName(type);
        ArrayList<Integer> populations = jdbc.getPopulations(type);
        ArrayList<Integer> deaths = jdbc.getDeaths(type);
        
        html = html +   "<table class=\"content-table\"  style=\"float: left; margin-left:left; margin-right:auto\">" + 
                            "<thead>" +
                                "<tr>" +
                                    "<td>Name</td>" +
                                    "<td>Population</td>" +
                                    "<td>Deaths Cumulative Total</td>" +
                                "</tr>" +
                            "<tbody>";
        for (int i = 0; i < names.size(); ++i) {
            html = html +       "<tr>" +
                                    "<td>" + names.get(i) + "</td>" +
                                    "<td>" + populations.get(i) + "</td>" +
                                    "<td>" + deaths.get(i) + "</td>" +
                                "</tr>";
        }
        html = html +       "</tbody>" +
                        "</table>";

        return html;
    }

    public String outputTextBoxResults2(String userText) {
        String html = "";
        if (userText.equals("None")) {
            html = html + "";
        }
        else{
            html = html + "<h2>Showing <strong>" + userText + "</strong> data.</h2>";
        }

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<String> Region_names = jdbc.getRegionResults(userText);
        ArrayList<String> Country_names = jdbc.getSingleCountryResults(userText);
        ArrayList<Integer> populations = jdbc.getPopulations1(userText);
        ArrayList<Integer> deaths = jdbc.getDeaths2(userText);

        html = html +   "<table class=\"content-table\" style=\"float: right; margin-left:auto; margin-right:right\">" + 
                            "<thead>" +
                                "<tr>" +
                                    "<td>Province/State</td>" +
                                    "<td>Country</td>" +
                                    "<td>Population</td>" +
                                    "<td>Deaths Cumulative Total</td>" +
                                "</tr>" +
                            "<tbody>";
        for (int i = 0; i < Country_names.size(); ++i) {
            html = html +       "<tr>" +
                                    "<td>" + Region_names.get(i) + "</td>" +
                                    "<td>" + Country_names.get(i) + "</td>" +
                                    "<td>" + populations.get(i) + "</td>" +
                                    "<td>" + deaths.get(i) + "</td>" +
                                "</tr>";
        }
        html = html +       "</tbody>" +
                        "</table>";

        return html;
    }
}
