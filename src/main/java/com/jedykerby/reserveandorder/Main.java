/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jedykerby.reserveandorder;

import java.util.Scanner;

/**
 *
 * @author YTAC
 */

import users.User;

public class Main {
    
    public static void main(String[] args) {
        User user = new User();
        WelcomeDialog wcdialog = new WelcomeDialog(null, false, user);
        wcdialog.setVisible(true);
    }    
}
