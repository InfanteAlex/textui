/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdata;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexa
 */
public class Database {

    public static void sql(String word, int count) throws IOException, ClassNotFoundException, SQLException {


        String url = ("jdbc:mysql://localhost:3306/word occurrences");
        String uname = "root";
        String password = "password";


      
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement statement = con.createStatement();
        try {


            String query = ("INSERT INTO word (newWord, Count) values (" + '\"' + word + '\"' + "," + count + ")");
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
