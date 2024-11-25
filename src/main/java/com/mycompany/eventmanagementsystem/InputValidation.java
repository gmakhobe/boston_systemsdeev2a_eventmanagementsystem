/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author bbdnet2332
 */
public class InputValidation {
    public boolean isFieldEmpty(String value, String fieldName){
        if (value.length() > 0) {
            return false;
        }
        JOptionPane.showMessageDialog(null, fieldName + " is empty.");
        return true;
    }
    
    public boolean isGivenValueNumber(String value, String fieldName){
        if (value.matches("\\d+")){
            return true;
        }
        JOptionPane.showMessageDialog(null, fieldName + " given value is not a number.");
        return false;
    }
}
