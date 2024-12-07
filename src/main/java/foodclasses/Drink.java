package foodclasses;

import javax.swing.ImageIcon;

public class Drink extends Food{
    
    private int size;
    private String variant = "";
    
    public Drink(ImageIcon icon, String name, double price) {
        super(icon, name, price);
    }
    
    public void setVariant(String v) {
        this.variant = "("+v+")";
    }
    
    public String getVariant() {
        return this.variant;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

}
