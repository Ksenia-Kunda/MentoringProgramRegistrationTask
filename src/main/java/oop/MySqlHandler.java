package oop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ksenia on 02.11.2017.
 */
public class MySqlHandler {

    private static Connection connection;
    private static Statement statement;
    private static List<List<String>> voucher;

    private static final int DAYS_COLUMN = 3;
    private static final int TRANSFER_COLUMN = 4;
    private static final int FOOD_COLUMN = 5;


    public static void createMySQLdb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts?autoReconnect=true&useSSL=false", "root", "root");
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE vouchers(id int(3)AUTO_INCREMENT, voucherType VARCHAR(20)NOT NULL, days SET('1', '2', '3', '5', '7', '8', '11', '14', '21')NOT NULL," +
                    " transfer SET(\"BUS\", \"AIRPLANE\", \"TRAIN\", \"SHIP\"), food SET( 'BREAKFAST', 'TWO_TIMES_A_DAY', 'THREE_TIMES_A_DAY', 'FIFE_TIMES_A_DAY', 'ALL_INCLUDED'),  PRIMARY KEY(id))");
            statement.executeUpdate("INSERT INTO vouchers (voucherType, days, transfer, food) VALUES " +
                    "(\"Cruise\", \"5,8\", \"SHIP\",\"TWO_TIMES_A_DAY,ALL_INCLUDED\")" +
                    "(\"Excursion\", \"2,5\", \"BUS\")" +
                    "(\"Treatment\", \"14\", \"BUS,TRAIN\",\"FIFE_TIMES_A_DAY\")" +
                    "(\"Shopping\", \"1,3\", \"BUS,TRAIN\")" +
                    "(\"Vacation\", \"5,11,14,21\", \"BUS,TRAIN,AIRPLANE\",\"THREE_TIMES_A_DAY,ALL_INCLUDED\")");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<List<String>> readMySQLdb(String voucherType) {
        try {
            voucher = new ArrayList<>();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts?autoReconnect=true&useSSL=false", "root", "root");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vouchers WHERE voucherType="+voucherType);
            int i = 0;
            while (resultSet.next()) {
                voucher.add(new ArrayList<String>());
                voucher.get(i).add(resultSet.getString(DAYS_COLUMN));
                voucher.get(i).add(resultSet.getString(TRANSFER_COLUMN));
                voucher.get(i).add(resultSet.getString(FOOD_COLUMN));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucher;
    }
}
