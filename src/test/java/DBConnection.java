import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String DB_URL = "jdbc:postgresql://greencity-data.postgres.database.azure.com/greencity_ubs";
    private static final String USER = "greencity_admin@greencity-data";
    private static final String PASS = "GbCAq5MU8asY0gxOmoQX8/V5vcbWgnRkzWAmZTZU5qo=";

    private Connection connection;
    public DBConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() throws SQLException {
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static List<String> getDistrict(String expression) throws SQLException {
        DBConnection address = new DBConnection();
        Statement statement = address.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(expression);
        List<String> list = new ArrayList<>();
        while (resultSet.next()) {
            String s = resultSet.getString(1);
            list.add(s);
        }
        address.closeConnection();
        return list;
    }
}