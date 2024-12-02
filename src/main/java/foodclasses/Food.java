package foodclasses;

import javax.swing.ImageIcon;

public abstract class Food {
    
    private ImageIcon image;
    private String name;
    private double price;
    private int quantity = 0;

    public Food( ImageIcon image, String name, double price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity() {
        quantity++;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity() {
        quantity--;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

}
