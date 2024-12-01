package foodclasses;

import javax.swing.ImageIcon;

public class Food {
    
    private FoodType type;
    private ImageIcon image;
    private String name;
    private double price;
    private int quantity = 0;

    public Food( ImageIcon image, String name, double price, FoodType type ) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.type = type;
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

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }
}
