package com.bootcamp.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Model {
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;

    public Model(){
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("/Users/faridhwisanggeni/Downloads/Day 15 Examp - Silo Mardadi/WebServeletUji/src/main/java/com/bootcamp/model/user.properties"));
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/worker",username,password);
            statement = connection.createStatement();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public int insert(String table, String maps, String value) throws ClassNotFoundException, SQLException, IOException {
        String query = "insert into "+ table +" "+maps +" values "+value;
        int result = statement.executeUpdate(query);
        return result;
    }

    public ResultSet getData(String table) throws SQLException {
        return statement.executeQuery("select * from "+table);
    }

    public ResultSet getDataLimit(String table, int start, int limit) throws SQLException {
        String query = "select * from "+table+" limit "+ start +", "+limit;
        return statement.executeQuery(query);
    }

    public int getCount(String table) throws SQLException {
        String query = "select count(*) from "+table;
        ResultSet result = statement.executeQuery(query);
        result.next();
        return result.getInt(1);
    }

    public int getCountWhere(String table, String field, String where) throws SQLException {
        String query = "select count(*) from "+table+" where "+field+"="+where;
        ResultSet result = statement.executeQuery(query);
        result.next();
        return result.getInt(1);
    }

    public ResultSet getWhere(String table, String where) throws SQLException{
        String query = "select * from "+table+" where "+where;
        return statement.executeQuery(query);
    }

    public int delete(String table, String field, String where) throws SQLException{
        String query = "delete from "+table+" where "+field+"="+where;
        int result = statement.executeUpdate(query);
        return result;
    }

    public int emptyTable(String table) throws SQLException{
        String query = "delete from "+table;
        int result = statement.executeUpdate(query);
        return result;
    }

    public int updateData(String table, String value, String where) throws SQLException{
        String query = "update "+table+" set "+ value +" where "+where;
        int res = statement.executeUpdate(query);
        return res;
    }

    public ResultSet getListData() throws SQLException {
        String query = "SELECT k.id_karyawan, k.nama_karyawan, k.gaji_pokok, j.nama_jabatan, j.tunj_makan, j.tunj_transport, " +
                "(k.gaji_pokok + j.tunj_makan + j.tunj_transport) as 'total_gaji' " +
                "FROM karyawan k JOIN jabatan j ON k.id_jabatan = j.id_jabatan";
        return statement.executeQuery(query);
    }


    public int deleteAll(String table) throws SQLException{
        String query = "delete from "+table;
        int res = statement.executeUpdate(query);
        return res;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
    }
}
