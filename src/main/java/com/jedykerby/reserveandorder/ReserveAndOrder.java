/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jedykerby.reserveandorder;

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
            
            System.out.println(option);

            switch (option) {
                case 0:
                    System.out.println("Customer");
                    break;
                case 1:
                    System.out.println("Admin");
                    break;
                case 2:
                    System.exit(0);
                    break;
                case -1:
                    System.exit(0);
                    break;
            }
            
        }
    }
}
