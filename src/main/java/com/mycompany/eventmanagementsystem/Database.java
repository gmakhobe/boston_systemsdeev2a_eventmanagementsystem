/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author bbdnet2332
 */
public class Database {
    public Statement DatabaseConnection(){
        Connection conMySQLConnectionString= null;
        Statement stSQLQuery = null;
        
        System.out.println("Working nicely______");
        try {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa1_assessment","root","!QAZxsw2");
            stSQLQuery = conMySQLConnectionString.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            System.out.println(e);
        }
        
        return stSQLQuery;
    }
}
