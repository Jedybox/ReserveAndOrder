/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jedykerby.reserveandorder;

//Comment test

/**
 *
 * @author YTAC && KERBY
 */

import javax.swing.JOptionPane;

public class ReserveAndOrder {

    public static void main(String[] args) {
    
        while (true) {
            String[] menu = {"Customer", "Admin", "Exit"};
            
            int option = JOptionPane.showOptionDialog(
                null, 
                "Use the system as:\n\n", 
                "Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                menu, 
                menu[0]);
            
            System.out.println("nice");

            switch (option) {
                case 0 -> System.out.println("Customer");
                case 1 -> System.out.println("Admin");
                case 2 -> System.exit(0);
                case -1 -> System.exit(0);
            }
            
        }
    }
}
