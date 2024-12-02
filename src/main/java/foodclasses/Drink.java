package foodclasses;

import javax.swing.ImageIcon;

public class Drink extends Food{
    
    private double size;

    public Drink(ImageIcon icon, String name, double price) {
        super(icon, name, price);
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

}
