package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

    public static Connection con;
    public static Connection connectionProvider(){


        String url = "jdbc:mysql://localhost:3306/to_do_app";
        String username = "root" ;
        String password = "SJ8W@vWN";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           con =  DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return con;
    }

}
