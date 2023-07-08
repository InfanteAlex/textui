package com.mycompany.uipart3;

import com.mycompany.uipart3.words;
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
public class database {

    public static void sql(String word , int count) throws IOException, ClassNotFoundException, SQLException {
//        Set<String> uniqueWords = new HashSet<>();

    
        String url = ("jdbc:mysql://localhost:3306/word occurrences");
        String uname = "root";
        String password = "password";

//        for (int i = 0; i < wordList.size(); i++) {
//
//            uniqueWords.add(wordList.get(i));
//
//        }
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement statement = con.createStatement();
        try {
//            for (String x : uniqueWords) {
//                word = x;

                String query = ("INSERT INTO word (newWord, Count) values (" + '\"' + word + '\"' + "," + count + ")");
                statement.executeUpdate(query);
//            }

//                while (result.next()) {
//                    System.out.println(result);
//                }
//
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
