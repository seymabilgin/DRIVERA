package drivera.Utilities;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_Utilty {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;


    public static void createConnection() {
        // connection = DriverManager.getConnection("jdbc:postgresql://64.227.123.49:5432/prettierhomes", "tech_pro_edu", "testingIsFun");

        String url = "jdbc:postgresql://64.227.123.49:5432/prettierhomes";
        String user = "tech_pro_edu";
        String password = "testingIsFun";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }

    public static List<Object> getRowListIndex(String query, int i) {
        return getQueryResultList(query).get(i);
    }

    public static List<Object> getRowList(String query) {
        return getQueryResultList(query).get(0);
    }



    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;
    }


    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowList;
    }

    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }

    public static Date date(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate;
        parsedDate = dateFormat.parse(date);
        Date sqlDate = new Date(parsedDate.getTime());
        System.out.println("java.sql.Date: " + sqlDate);

        return sqlDate;
    }

    public static Timestamp dateTime() {

        String stringDateTime = "2024-04-20 09:58:27.934954";

// İstediğiniz formatı belirleyin
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

// String'i tarihe parse edin
        Date parsedDate = null;
        try {
            parsedDate = (Date) formatter.parse(stringDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

// Tarihi Timestamp'e dönüştürün
        Timestamp timestamp = null;
        if (parsedDate != null) {
            timestamp = new Timestamp(parsedDate.getTime());
        }
            return timestamp;

}

    public static Long longaDonustur (Integer num){
        Long numLong = num.longValue();
        return numLong;
    }


}

