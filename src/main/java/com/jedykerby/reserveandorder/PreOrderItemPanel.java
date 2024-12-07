/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.jedykerby.reserveandorder;

import foodclasses.MainCourse;
import foodclasses.Appitizer;
import foodclasses.Dessert;
import foodclasses.Drink;

/**
 *
 * @author YTAC
 */
public class PreOrderItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form PreOrderItemPanel
     */
    
    CustomerFrame parent;
        
    MainCourse mc;
    Appitizer ap;
    Dessert ds;
    Drink dr;
    
    public PreOrderItemPanel(CustomerFrame parent, MainCourse mc) {
        initComponents();
        this.parent = parent;
        this.mc = mc;
        this.name.setText(mc.getName());
        this.icon.setIcon(mc.getImage());
        this.amount.setText("Amount: "+mc.getQuantity());
        this.price.setText("Price: PHP "+mc.getPrice());
    }
    
    public PreOrderItemPanel(CustomerFrame parent, Appitizer ap) {
        initComponents();
        this.parent = parent;
        this.ap = ap;
        this.name.setText(ap.getName());
        this.icon.setIcon(ap.getImage());
        this.amount.setText("Amount: "+ap.getQuantity());
        this.price.setText("Price: PHP "+ap.getPrice());
    }
    
    public PreOrderItemPanel(CustomerFrame parent, Dessert ds) {
        initComponents();
        this.parent = parent;
        this.ds = ds;
        this.name.setText(ds.getName());
        this.icon.setIcon(ds.getImage());
        this.amount.setText("Amount: "+ds.getQuantity());
        this.price.setText("Price: PHP "+ds.getPrice());
    }
    
    public PreOrderItemPanel(CustomerFrame parent, Drink dr) {
        initComponents();
        this.parent = parent;
        this.dr = dr;
        this.name.setText(dr.getName() + " - "+dr.getVariant()+" " + dr.getSize() + "oz");
        this.icon.setIcon(dr.getImage());
        this.amount.setText("Amount: "+dr.getQuantity());
        this.price.setText("Price: PHP "+dr.getPrice());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        amount = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        price = new javax.swing.JLabel();

        setOpaque(false);

        name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        name.setText("itemName");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ChimkenParmesan.jpg"))); // NOI18N

        add.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        add.setText("+");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        minus.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        minus.setText("-");
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });

        amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount.setText("amount");

        jButton17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jButton17.setText("Delete");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        price.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        price.setText("price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(icon)
                .addGap(18, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton17))
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addGap(18, 18, 18)
                        .addComponent(price)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amount)
                            .addComponent(add)
                            .addComponent(minus))
                        .addGap(29, 29, 29)
                        .addComponent(jButton17)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if (mc != null) 
            this.parent.orders.add(mc, 1);
        else if (ap != null)
            this.parent.orders.add(ap, 1);
        else if (ds != null)
            this.parent.orders.add(ds, 1);
        else if (dr != null)
            this.parent.orders.add(dr, 1);
        
        this.parent.renderOrders();
    }//GEN-LAST:event_addActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed
        if (mc != null) 
            this.parent.orders.remove(mc, 1);
        else if (ap != null)
            this.parent.orders.remove(ap, 1);
        else if (ds != null)
            this.parent.orders.remove(ds, 1);
        else if (dr != null)
            this.parent.orders.remove(dr, 1);
        
        this.parent.renderOrders();
    }//GEN-LAST:event_minusActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (mc != null) 
            this.parent.orders.remove(mc);
        else if (ap != null)
            this.parent.orders.remove(ap);
        else if (ds != null)
            this.parent.orders.remove(ds);
        else if (dr != null)
            this.parent.orders.remove(dr);
        
        this.parent.renderOrders();
    }//GEN-LAST:event_jButton17ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel icon;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton minus;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
