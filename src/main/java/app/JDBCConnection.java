package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 * 
 * This is an example JDBC Connection that has a single query for the Movies Database
 * This is similar to the project workshop JDBC examples.
 *
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/Covid.db";

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    public int countCases(String sqlQuery, String colomnName) {
        int values = 0;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = sqlQuery;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                values = results.getInt(colomnName);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return values;
    }

    public ArrayList<String> getCountryName(String type1) {
        ArrayList<String> CountryName = new ArrayList<String>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion, SUM(population) AS ppl, SUM(totalcases) AS tlc FROM Region GROUP BY CountryRegion ORDER BY tlc " +
            type1 + ";";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString("CountryRegion");
                CountryName.add(name);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return CountryName; 
    }

    public ArrayList<Integer> getPopulations(String type1) {
        ArrayList<Integer> populationNum = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion, SUM(population) AS ppl, SUM(totalcases) AS tlc FROM Region GROUP BY CountryRegion ORDER BY tlc " +
            type1 + ";";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int population = results.getInt("ppl");
                populationNum.add(population);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return populationNum;
    }

    public ArrayList<Integer> getComfirmedCases(String type1) {
        ArrayList<Integer> GCC = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion, SUM(population) AS ppl, SUM(totalcases) AS tlc FROM Region GROUP BY CountryRegion ORDER BY tlc " +
            type1 + ";";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int comfirmedCase = results.getInt("tlc");
                GCC.add(comfirmedCase);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return GCC;
    }

    public ArrayList<Integer> getDeaths(String type1) {
        ArrayList<Integer> GCD = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion, SUM(population) AS ppl, SUM(totaldeath) AS tld FROM Region GROUP BY CountryRegion ORDER BY tld " +
            type1 + ";";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int death = results.getInt("tld");
                GCD.add(death);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return GCD;
    }

    public ArrayList<String> getSingleCountryResults(String type2) {  // Level 2 the Second TextBox
        ArrayList<String> Countries = new ArrayList<String>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT ProvinceState, CountryRegion, population AS ppl, totalcases AS tlc FROM Region WHERE CountryRegion = '" +
            type2 + "';";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString("CountryRegion");
                Countries.add(name);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return Countries;
    }

    public ArrayList<String> getRegionResults(String type2) {
        ArrayList<String> Regions = new ArrayList<String>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT ProvinceState, CountryRegion, population AS ppl, totalcases AS tlc FROM Region WHERE CountryRegion = '" +
            type2 + "';";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString("ProvinceState");
                Regions.add(name);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return Regions;
    }

    public ArrayList<Integer> getPopulations1(String type2) {
        ArrayList<Integer> populationNum1 = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT ProvinceState, CountryRegion, population AS ppl, totalcases AS tlc FROM Region WHERE CountryRegion = '" +
            type2 + "';";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int population = results.getInt("ppl");
                populationNum1.add(population);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return populationNum1;
    }

    public ArrayList<Integer> getComfirmedCases1(String type2) {
        ArrayList<Integer> GCC1 = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT ProvinceState, CountryRegion, population AS ppl, totalcases AS tlc FROM Region WHERE CountryRegion = '" +
            type2 + "';";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int comfirmedCase = results.getInt("tlc");
                GCC1.add(comfirmedCase);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return GCC1;
    }

    public ArrayList<Integer> getDeaths2(String type2) {
        ArrayList<Integer> GCD2 = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT ProvinceState, CountryRegion, population AS ppl, totaldeath AS tld FROM Region WHERE CountryRegion = '" +
            type2 + "';";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int death = results.getInt("tld");
                GCD2.add(death);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return GCD2;
    }

    public ArrayList<String> getAllCountries() {  //LEVEL 3 EXTENSION!!!
        ArrayList<String> Countries = new ArrayList<String>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion FROM Region GROUP BY CountryRegion;";
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString("CountryRegion");
                Countries.add(name);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return Countries; 
    }

    public ArrayList<String> getResultsProvinceStates(String type4, String type5) {
        ArrayList<String> provinces = new ArrayList<String>();
        String userWants = "";
        if (type5 == null || type5.equals("None")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + "';";
        }
        else if (type5.equals("Date(Earliest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date ASC;";
        }
        else if (type5.equals("Date(Latest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date DESC;";
        }
        else if (type5.equals("CountryRegion")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY CountryRegion;";
        }
        else if (type5.equals("ProvinceState")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ProvinceState;";
        }
        else if (type5.equals("ComfirmedCase(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase DESC;";
        }
        else if (type5.equals("ComfirmedCase(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase ASC;";
        }
        else if (type5.equals("Death(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death DESC;";
        }
        else if (type5.equals("Death(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userWants;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String state = results.getString("ProvinceState");
                provinces.add(state);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return provinces;
    }

    public ArrayList<String> getResultsCountries(String type4, String type5) {
        ArrayList<String> countries = new ArrayList<String>();
        String userWants = "";
        if (type5 == null || type5.equals("None")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + "';";
        }
        else if (type5.equals("Date(Earliest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date ASC;";
        }
        else if (type5.equals("Date(Latest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date DESC;";
        }
        else if (type5.equals("CountryRegion")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY CountryRegion;";
        }
        else if (type5.equals("ProvinceState")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ProvinceState;";
        }
        else if (type5.equals("ComfirmedCase(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase DESC;";
        }
        else if (type5.equals("ComfirmedCase(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase ASC;";
        }
        else if (type5.equals("Death(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death DESC;";
        }
        else if (type5.equals("Death(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userWants;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String region = results.getString("CountryRegion");
                countries.add(region);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return countries;
    }

    public ArrayList<String> getResultsDates(String type4, String type5) {
        ArrayList<String> dates = new ArrayList<String>();
        String userWants = "";
        if (type5 == null || type5.equals("None")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + "';";
        }
        else if (type5.equals("Date(Earliest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date ASC;";
        }
        else if (type5.equals("Date(Latest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date DESC;";
        }
        else if (type5.equals("CountryRegion")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY CountryRegion;";
        }
        else if (type5.equals("ProvinceState")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ProvinceState;";
        }
        else if (type5.equals("ComfirmedCase(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase DESC;";
        }
        else if (type5.equals("ComfirmedCase(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase ASC;";
        }
        else if (type5.equals("Death(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death DESC;";
        }
        else if (type5.equals("Death(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userWants;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String datetime = results.getString("Date");
                dates.add(datetime);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return dates;
    }

    public ArrayList<Integer> getResultsComfirmedCase(String type4, String type5) {
        ArrayList<Integer> comfirms = new ArrayList<Integer>();
        String userWants = "";
        if (type5 == null || type5.equals("None")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + "';";
        }
        else if (type5.equals("Date(Earliest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date ASC;";
        }
        else if (type5.equals("Date(Latest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date DESC;";
        }
        else if (type5.equals("CountryRegion")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY CountryRegion;";
        }
        else if (type5.equals("ProvinceState")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ProvinceState;";
        }
        else if (type5.equals("ComfirmedCase(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase DESC;";
        }
        else if (type5.equals("ComfirmedCase(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase ASC;";
        }
        else if (type5.equals("Death(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death DESC;";
        }
        else if (type5.equals("Death(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userWants;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int infection = results.getInt("ComfirmedCase");
                comfirms.add(infection);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return comfirms;
    }

    public ArrayList<Integer> getResultsDeaths(String type4, String type5) {
        ArrayList<Integer> deaths = new ArrayList<Integer>();
        String userWants = "";
        if (type5 == null || type5.equals("None")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + "';";
        }
        else if (type5.equals("Date(Earliest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date ASC;";
        }
        else if (type5.equals("Date(Latest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Date DESC;";
        }
        else if (type5.equals("CountryRegion")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY CountryRegion;";
        }
        else if (type5.equals("ProvinceState")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ProvinceState;";
        }
        else if (type5.equals("ComfirmedCase(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase DESC;";
        }
        else if (type5.equals("ComfirmedCase(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY ComfirmedCase ASC;";
        }
        else if (type5.equals("Death(Highest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death DESC;";
        }
        else if (type5.equals("Death(Lowest)")) {
            userWants = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ type4 + 
            "' ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userWants;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int death = results.getInt("Death");
                deaths.add(death);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return deaths;
    }

    public ArrayList<String> getAllStates2(String q1, String q2, int q3) { // LEVEL 3 LAST X DAYS BEGIN!!!
        ArrayList<String> p1 = new ArrayList<String>();
        String userNeeds = "";
        if (q2 == null || q2.equals("None")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day');";
        }
        else if (q2.equals("Date(Earliest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date ASC;";
        }
        else if (q2.equals("Date(Latest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date DESC;";
        }
        else if (q2.equals("CountryRegion")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY CountryRegion;";
        }
        else if (q2.equals("ProvinceState")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ProvinceState;";
        }
        else if (q2.equals("ComfirmedCase(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase DESC;";
        }
        else if (q2.equals("ComfirmedCase(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase ASC;";
        }
        else if (q2.equals("Death(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death DESC;";
        }
        else if (q2.equals("Death(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userNeeds;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String state = results.getString("ProvinceState");
                p1.add(state);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return p1;
    }

    public ArrayList<String> getResultsCountries2(String q1, String q2, int q3) {
        ArrayList<String> c1 = new ArrayList<String>();
        String userNeeds = "";
        if (q2 == null || q2.equals("None")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day');";
        }
        else if (q2.equals("Date(Earliest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date ASC;";
        }
        else if (q2.equals("Date(Latest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date DESC;";
        }
        else if (q2.equals("CountryRegion")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY CountryRegion;";
        }
        else if (q2.equals("ProvinceState")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ProvinceState;";
        }
        else if (q2.equals("ComfirmedCase(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase DESC;";
        }
        else if (q2.equals("ComfirmedCase(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase ASC;";
        }
        else if (q2.equals("Death(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death DESC;";
        }
        else if (q2.equals("Death(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userNeeds;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String country = results.getString("CountryRegion");
                c1.add(country);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return c1;
    }

    public ArrayList<String> getManyDates2(String q1, String q2, int q3) {
        ArrayList<String> t1 = new ArrayList<String>();
        String userNeeds = "";
        if (q2 == null || q2.equals("None")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day');";
        }
        else if (q2.equals("Date(Earliest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date ASC;";
        }
        else if (q2.equals("Date(Latest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date DESC;";
        }
        else if (q2.equals("CountryRegion")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY CountryRegion;";
        }
        else if (q2.equals("ProvinceState")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ProvinceState;";
        }
        else if (q2.equals("ComfirmedCase(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase DESC;";
        }
        else if (q2.equals("ComfirmedCase(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase ASC;";
        }
        else if (q2.equals("Death(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death DESC;";
        }
        else if (q2.equals("Death(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userNeeds;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String datetime = results.getString("Date");
                t1.add(datetime);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return t1;
    }

    public ArrayList<Integer> getManyCases2(String q1, String q2, int q3) {
        ArrayList<Integer> cc1 = new ArrayList<Integer>();
        String userNeeds = "";
        if (q2 == null || q2.equals("None")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day');";
        }
        else if (q2.equals("Date(Earliest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date ASC;";
        }
        else if (q2.equals("Date(Latest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date DESC;";
        }
        else if (q2.equals("CountryRegion")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY CountryRegion;";
        }
        else if (q2.equals("ProvinceState")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ProvinceState;";
        }
        else if (q2.equals("ComfirmedCase(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase DESC;";
        }
        else if (q2.equals("ComfirmedCase(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase ASC;";
        }
        else if (q2.equals("Death(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death DESC;";
        }
        else if (q2.equals("Death(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userNeeds;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int cases = results.getInt("ComfirmedCase");
                cc1.add(cases);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return cc1;
    }

    public ArrayList<Integer> getManyDeaths2(String q1, String q2, int q3) {
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        String userNeeds = "";
        if (q2 == null || q2.equals("None")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day');";
        }
        else if (q2.equals("Date(Earliest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date ASC;";
        }
        else if (q2.equals("Date(Latest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Date DESC;";
        }
        else if (q2.equals("CountryRegion")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY CountryRegion;";
        }
        else if (q2.equals("ProvinceState")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ProvinceState;";
        }
        else if (q2.equals("ComfirmedCase(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase DESC;";
        }
        else if (q2.equals("ComfirmedCase(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY ComfirmedCase ASC;";
        }
        else if (q2.equals("Death(Highest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death DESC;";
        }
        else if (q2.equals("Death(Lowest)")) {
            userNeeds = "SELECT ProvinceState, CountryRegion, Date, ComfirmedCase, Death FROM Region NATURAL JOIN cases " +
            "WHERE CountryRegion = '"+ q1 + "' AND Date > DATETIME('2021-04-22', '-" + q3 + " day')" +
            " ORDER BY Death ASC;";
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = userNeeds;
            
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int number = results.getInt("Death");
                d1.add(number);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return d1;
    }

    public ArrayList<String> getOverviewCountries() { // OVERVIEW PAGE
        ArrayList<String> CountryName = new ArrayList<String>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion, SUM(TotalCases) AS tlc FROM Region GROUP BY CountryRegion;";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString("CountryRegion");
                CountryName.add(name);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return CountryName; 
    }

    public ArrayList<Integer> getOverviewComfirmedCases() { // OVERVIEW PAGE
        ArrayList<Integer> cases = new ArrayList<Integer>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT CountryRegion, SUM(TotalCases) AS tlc FROM Region GROUP BY CountryRegion;";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int values = results.getInt("tlc");
                cases.add(values);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return cases; 
    }
}
