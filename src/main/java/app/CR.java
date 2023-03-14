package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class CR implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/CR.html";

    @Override
    public void handle(Context context) throws Exception {
        // Look up some information from JDBC
        // First we need to use your JDBCConnection class
        JDBCConnection jdbc = new JDBCConnection();

        // Create a simple HTML webpage in a String, create userNumber for last x days
        int userNumber = 0;
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Cumulative Report</title>";

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
                            "float: center;" +
                            "margin-left:auto;" +
                            "margin-right:auto;" +
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
                            "<li><a href=\"DBC.html\">Death By Country</a></li>" + 
                            "<li class=\"active\"><a href=\"CR.html\">Cumulative Report</a></li>" +
                      "</ul>"+
                      "</nav>";
        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // BEGIN: Infections By Country Content 
        html = html + "<h1 style=\"text-align: centre; font-family:montserrat; color:000000; font-size: 40px;\"><b>Cumulative Report</h1>";


        // Sort and Search Button
        html = html +   "<form action=\'/CR.html\' method=\'post\' class=\"navbar-form navbar-center\" role=\"search\">" +
                            "<div class=\'form-group\'>" +
                                "<label for=\'Sort_Drop2\'>Filter:</label>" +
                                "<select id=\'Sort_drop2\' name=\'Sort_drop2\'>" +
                                    "<option>None</option>" +
                                    "<option>Date(Earliest)</option>" +
                                    "<option>Date(Latest)</option>" +
                                    "<option>ProvinceState</option>" +
                                    "<option>CountryRegion</option>" +
                                    "<option>ComfirmedCase(Highest)</option>" +
                                    "<option>ComfirmedCase(Lowest)</option>" +
                                    "<option>Death(Highest)</option>" +
                                    "<option>Death(Lowest)</option>" +
                                "</select>" +
                            "</div>" + 
                            "<br>" +
                            "<div class=\'form-group\'>" +
                                "<label for=\'Sort_Drop1\'>Country(Dropdown):</label>" +
                                "<select id=\'Sort_drop1\' name=\'Sort_drop1\'>" +
                                    "<option>None</option>";
        ArrayList<String> nameCountries = jdbc.getAllCountries();
        for(String nameCountrie : nameCountries){
            html = html +           "<option>" + nameCountrie + "</option>";
        }
        html = html +           "</select>" +
                            "</div>" + 
                            "<div class='form-group'>" +
                                "<label for='Sort_textbox'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
                                "Last x Days(Enter an integer number for x):</label>" +
                                "<input class='form-control' id='Sort_textbox' name='Sort_textbox'>" +
                            "</div>" +
                                "<button type=\"submit\" class=\"btn btn-primary\">Show Data</button>" +
                        "</form>";

        // Dropdown and TextBox Process
        String Sort_drop1 = context.formParam("Sort_drop1");
        String Sort_drop2 = context.formParam("Sort_drop2");
        String Sort_textbox = context.formParam("Sort_textbox");
        if (Sort_drop1 == null || Sort_drop1.equals("None")) {
            html = html + outputOneResults("Afghanistan");
        } 
        else if (Sort_textbox.isEmpty()){
                html = html + outputTwoResults(Sort_drop1, Sort_drop2);
        }
        else {
            if (isNumeric(Sort_textbox)) {
                userNumber = Integer.parseInt(Sort_textbox);
                if (userNumber <= 457 && userNumber > 0) {
                    html = html + outputThreeResults(Sort_drop1, Sort_drop2, userNumber);
                }
                else {
                    html = html + "<h2><i>Sorry, your number is out of range.</i></h2>";
                }
            }
            else {
                html = html + "<h2><i>You have typed a wrong thing.</i></h2>";
            }
        }
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

    public String outputOneResults(String query1) {
        JDBCConnection jdbc = new JDBCConnection();
        String html = "";

        ArrayList<String> Province_names = jdbc.getResultsProvinceStates(query1, "None");
        ArrayList<String> Country_names = jdbc.getResultsCountries(query1, "None");
        ArrayList<String> Dates = jdbc.getResultsDates(query1, "None");
        ArrayList<Integer> Comfirms = jdbc.getResultsComfirmedCase(query1, "None");
        ArrayList<Integer> Deaths = jdbc.getResultsDeaths(query1, "None");

        html = html +   "<table class=\"content-table\">" + 
                        "<thead>" +
                            "<tr>" +
                                "<td>Province/State</td>" +
                                "<td>Country</td>" +
                                "<td>Date</td>" +
                                "<td>Comfirms Cumulative</td>" +
                                "<td>Deaths Cumulative</td>" +
                            "</tr>" +
                        "<tbody>";
        for (int i = 0; i < Country_names.size(); ++i) {
            html = html +   "<tr>" +
                                "<td>" + Province_names.get(i) + "</td>" +
                                "<td>" + Country_names.get(i) + "</td>" +
                                "<td>" + Dates.get(i) + "</td>" +
                                "<td>" + Comfirms.get(i) + "</td>" +
                                "<td>" + Deaths.get(i) + "</td>" +
                            "</tr>";
        }
        html = html +   "</tbody>" +
                    "</table>";

        return html;
    }

    public String outputTwoResults(String query1, String query2) {
        JDBCConnection jdbc = new JDBCConnection();
        String html = "";
        if (query2 == null || query2.equals("None")) {
            html = html + "<h2>You have chosen country <strong>" + query1 + "</strong>.</h2>";
        }
        else {
            html = html + "<h2>You have chosen country <strong>" + query1 + "</strong>.</h2>";
            html = html + "<h2>Sort by <strong>" + query2 + "</strong>.</h2>";
        }

        ArrayList<String> Province_names = jdbc.getResultsProvinceStates(query1, query2);
        ArrayList<String> Country_names = jdbc.getResultsCountries(query1, query2);
        ArrayList<String> Dates = jdbc.getResultsDates(query1, query2);
        ArrayList<Integer> Comfirms = jdbc.getResultsComfirmedCase(query1, query2);
        ArrayList<Integer> Deaths = jdbc.getResultsDeaths(query1, query2);

        html = html +   "<table class=\"content-table\">" + 
                        "<thead>" +
                            "<tr>" +
                                "<td>Province/State</td>" +
                                "<td>Country</td>" +
                                "<td>Date</td>" +
                                "<td>Comfirms Cumulative</td>" +
                                "<td>Deaths Cumulative</td>" +
                            "</tr>" +
                        "<tbody>";
        for (int i = 0; i < Country_names.size(); ++i) {
            html = html +   "<tr>" +
                                "<td>" + Province_names.get(i) + "</td>" +
                                "<td>" + Country_names.get(i) + "</td>" +
                                "<td>" + Dates.get(i) + "</td>" +
                                "<td>" + Comfirms.get(i) + "</td>" +
                                "<td>" + Deaths.get(i) + "</td>" +
                            "</tr>";
        }
        html = html +   "</tbody>" +
                    "</table>";

        return html;
    }

    public static boolean isNumeric(String string) {
        int intValue;
            
        System.out.println(String.format("Parsing string: \"%s\"", string));
            
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public String outputThreeResults(String query3, String query4, int query5) { //!!! 3 results
        JDBCConnection jdbc = new JDBCConnection();
        String html = "";
        if (query4 == null || query4.equals("None")) {
            html = html + "<h2>You have chosen country <strong>" + query3 + "</strong>.</h2>";
            html = html + "<h2>In last <strong>" + query5 + "</strong> days.</h2>";
        }
        else {
            html = html + "<h2>You have chosen country <strong>" + query3 + "</strong>.</h2>";
            html = html + "<h2>Sort by <strong>" + query4 + "</strong>.</h2>";
            html = html + "<h2>In last <strong>" + query5 + "</strong> days.</h2>";
        }

        ArrayList<String> Province_names = jdbc.getAllStates2(query3, query4, query5);
        ArrayList<String> Country_names = jdbc.getResultsCountries2(query3, query4, query5);
        ArrayList<String> Dates = jdbc.getManyDates2(query3, query4, query5);
        ArrayList<Integer> Comfirms = jdbc.getManyCases2(query3, query4, query5);
        ArrayList<Integer> Deaths = jdbc.getManyDeaths2(query3, query4, query5);

        html = html +   "<table class=\"content-table\">" + 
                        "<thead>" +
                            "<tr>" +
                                "<td>Province/State</td>" +
                                "<td>Country</td>" +
                                "<td>Date</td>" +
                                "<td>Comfirms Cumulative</td>" +
                                "<td>Deaths Cumulative</td>" +
                            "</tr>" +
                        "<tbody>";
        for (int i = 0; i < Country_names.size(); ++i) {
            html = html +   "<tr>" +
                                "<td>" + Province_names.get(i) + "</td>" +
                                "<td>" + Country_names.get(i) + "</td>" +
                                "<td>" + Dates.get(i) + "</td>" +
                                "<td>" + Comfirms.get(i) + "</td>" +
                                "<td>" + Deaths.get(i) + "</td>" +
                            "</tr>";
        }
        html = html +   "</tbody>" +
                    "</table>";

        return html;
    }
}
