/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Vector;

/**
 *
 * @author bbdnet2332
 */
public class Database {
    private Statement DatabaseConnection(){
        Connection conMySQLConnectionString= null;
        Statement stSQLQuery = null;
        
        try {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa1_assessment","root","!QAZxsw2");
            stSQLQuery = conMySQLConnectionString.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            System.out.println(e);
        }
        
        return stSQLQuery;
    }
    
    public Vector selectAllDataFromATable(String tableName){
        ResultSet results = null;
        ResultSetMetaData resultSetMetaData = null;
        int columnCount = 0;
        Vector vColumn = null;
        Vector vData = new Vector();
        Vector vRow = null; 
        
        try{
            results = this.DatabaseConnection().executeQuery("select * from " + tableName);
            resultSetMetaData = results.getMetaData();
            columnCount = resultSetMetaData.getColumnCount();
            
            vColumn = new Vector(columnCount);
            
            for (int i = 1; i <= columnCount; i++) {
                vColumn.add(resultSetMetaData.getColumnName(i));
            }
            
            while(results.next()){
                vRow = new Vector(columnCount);
                for(int i = 1; i <= columnCount; i++){
                    vRow.add(results.getString(i));
                }
                vData.add(vRow);
            }
            
            Vector information = new Vector();
            information.add(vData);
            information.add(vColumn);
            
            return information;
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            System.out.println(e);
        }
        return new Vector();
    }
    
    public Vector selectAllDataFromATableCustom(String sqlStatement){
        ResultSet results = null;
        ResultSetMetaData resultSetMetaData = null;
        int columnCount = 0;
        Vector vColumn = null;
        Vector vData = new Vector();
        Vector vRow = null; 
        
        try{
            results = this.DatabaseConnection().executeQuery(sqlStatement);
            resultSetMetaData = results.getMetaData();
            columnCount = resultSetMetaData.getColumnCount();
            
            vColumn = new Vector(columnCount);
            
            for (int i = 1; i <= columnCount; i++) {
                vColumn.add(resultSetMetaData.getColumnName(i));
            }
            
            while(results.next()){
                vRow = new Vector(columnCount);
                for(int i = 1; i <= columnCount; i++){
                    vRow.add(results.getString(i));
                }
                vData.add(vRow);
            }
            
            Vector information = new Vector();
            information.add(vData);
            information.add(vColumn);
            
            return information;
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            System.out.println(e);
        }
        return new Vector();
    }
    
    public boolean insertDataIntoATable(String sqlStatement){
        boolean results;
        ResultSetMetaData resultSetMetaData = null;
        
        try {
            results = this.DatabaseConnection().execute(sqlStatement);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return false;
    }
}
