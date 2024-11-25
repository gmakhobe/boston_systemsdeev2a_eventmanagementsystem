/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eventmanagementsystem;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bbdnet2332
 */
public class EventManagementSystem {

    public static void main(String[] args) {
        try {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.show();
            
            //Database myDB = new Database();
        } catch (Exception ex) {
            Logger.getLogger(EventManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
