package utilities;

import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DBUtility {
    private static String user = "root";
    private static String password = "SQLJosh9891";
    private static String connString = "jdbc:mysql://localhost:3306/collection_manager";

    /**
     * This method returns the selectable categories when needing to create a new entry to the CollectionManager
     * @return ArrayList : String
     */
    public static ArrayList<String> getEntryCategories() {
        ArrayList<String> categories = new ArrayList<>();
        categories.addAll(Arrays.asList("Comic book, Manga", "TV show, Movie, Cartoon, Anime", "Figure, Statue"));
        return categories;
    }

    /**
     * This method returns the possible item conditions that a collectable could be under
     * @return ArrayList : String
     */
    public static ArrayList<String> getItemCondition() {
        ArrayList<String> conditions = new ArrayList<>();
        conditions.addAll(CollectibleCollection.acceptedItemConditions());
        return conditions;
    }

    /**
     * This method returns the categories of a collectable in the Print Media family
     * @return ArrayList : String
     */
    public static ArrayList<String> getPrintMediaCategories() {
        ArrayList<String> pmCategories = new ArrayList<>();
        pmCategories.addAll(PrintMedia.printMediaCategories());
        return pmCategories;
    }

    /**
     * This method returns the categories of a collectable in the Video Media family
     * @return ArrayList : String
     */
    public static ArrayList<String> getVideoMediaCategories() {
        ArrayList<String> vmCategories = new ArrayList<>();
        vmCategories.addAll(VideoMedia.videoMediaCategories());
        return vmCategories;
    }

    /**
     * This method returns the categories of a collectable in the Figure family
     * @return ArrayList : String
     */
    public static ArrayList<String> getFigureCategories() {
        ArrayList<String> fgCategories = new ArrayList<>();
        fgCategories.addAll(Figure.figureCategories());
        return fgCategories;
    }

    /**
     * This method returns the scale classifications
     * @return ArrayList : String
     */
    public static ArrayList<String> getScaleClassifications() {
        ArrayList<String> scaleClassifications = new ArrayList<>();
        scaleClassifications.addAll(Figure.acceptedScaleClassifications());
        return scaleClassifications;
    }

    public static ArrayList<CollectibleCollection> getPrintMediaFromDB() throws SQLException {
        ArrayList<CollectibleCollection> pmCollectables = new ArrayList<>();

        //create objects to access and read from the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1. connect to the DB
            conn = DriverManager.getConnection(connString, user, password);

            //2. create a statement object
            statement = conn.createStatement();

            //3. create / execute the query
            resultSet = statement.executeQuery("SELECT * FROM print_medias");

            //4. loop over the results
            while (resultSet.next()) {
                CollectibleCollection newPrintMedia = new PrintMedia(
                        resultSet.getString("itemName"),
                        resultSet.getInt("price"),
                        resultSet.getString("itemCondition"),
                        resultSet.getString("collectibleCategory"),
                        resultSet.getString("author"),
                        resultSet.getString("illustrator"),
                        resultSet.getString("publisher"),
                        resultSet.getInt("pageCount")
                );
                pmCollectables.add(newPrintMedia);
            }
        } catch (SQLException e) {
            System.out.println("Database access issue: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //5. close the connection, statement, resultSet
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return pmCollectables;
    }

    public static ArrayList<CollectibleCollection> getVideoMediaFromDB() throws SQLException {
        ArrayList<CollectibleCollection> vmCollectables = new ArrayList<>();

        //create objects to access and read from the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1. connect to the DB
            conn = DriverManager.getConnection(connString, user, password);

            //2. create a statement object
            statement = conn.createStatement();

            //3. create / execute the query
            resultSet = statement.executeQuery("SELECT * FROM video_medias");

            //4. loop over the results
            while (resultSet.next()) {
                CollectibleCollection newVideoMedia = new VideoMedia(
                        resultSet.getString("itemName"),
                        resultSet.getInt("price"),
                        resultSet.getString("itemCondition"),
                        resultSet.getString("collectibleCategory"),
                        resultSet.getString("director"),
                        resultSet.getString("studio"),
                        resultSet.getInt("episodes"),
                        resultSet.getInt("runTime")
                );
                vmCollectables.add(newVideoMedia);
            }
        } catch (SQLException e) {
            System.out.println("Database access issue: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //5. close the connection, statement, resultSet
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return vmCollectables;
    }

    public static ArrayList<CollectibleCollection> getFiguresFromDB() throws SQLException {
        ArrayList<CollectibleCollection> fgCollectables = new ArrayList<>();

        //create objects to access and read from the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1. connect to the DB
            conn = DriverManager.getConnection(connString, user, password);

            //2. create a statement object
            statement = conn.createStatement();

            //3. create / execute the query
            resultSet = statement.executeQuery("SELECT * FROM figures");

            //4. loop over the results
            while (resultSet.next()) {
                CollectibleCollection newFigure = new Figure(
                        resultSet.getString("itemName"),
                        resultSet.getInt("price"),
                        resultSet.getString("itemCondition"),
                        resultSet.getString("collectibleCategory"),
                        resultSet.getString("companyName"),
                        resultSet.getString("characterName"),
                        resultSet.getString("origin"),
                        resultSet.getString("scale")
                );
                fgCollectables.add(newFigure);
            }
        } catch (SQLException e) {
            System.out.println("Database access issue: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //5. close the connection, statement, resultSet
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return fgCollectables;
    }

    public static void addNewPrintMedia(PrintMedia pmCollectable) throws SQLException {
        String sql = "INSERT INTO print_medias (itemName, price, itemCondition, collectibleCategory, author, illustrator, publisher, pageCount) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try (Connection conn = DriverManager.getConnection(connString, user, password);) {
            preparedStatement = conn.prepareStatement(sql);

            // Bind the values
            preparedStatement.setString(1, pmCollectable.getItemName());
            preparedStatement.setInt(2, pmCollectable.getPrice());
            preparedStatement.setString(3, pmCollectable.getItemCondition());
            preparedStatement.setString(4, pmCollectable.getCollectibleCategory());
            preparedStatement.setString(5, pmCollectable.getAuthor());
            preparedStatement.setString(6, pmCollectable.getIllustrator());
            preparedStatement.setString(7, pmCollectable.getPublisher());
            preparedStatement.setInt(8, pmCollectable.getPageCount());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if(preparedStatement != null)
                preparedStatement.close();
        }
    }
}
