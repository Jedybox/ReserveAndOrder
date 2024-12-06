package foodclasses;

import java.util.ArrayList;

public class Order {
    
    private ArrayList<Appitizer> appitizers;
    private ArrayList<MainCourse> mainCourses;
    private ArrayList<Dessert> desserts;
    private ArrayList<Drink> drinks;

    public Order() {
        appitizers = new ArrayList<Appitizer>();
        mainCourses = new ArrayList<MainCourse>();
        desserts = new ArrayList<Dessert>();
        drinks = new ArrayList<Drink>();
    }

    public void add(Appitizer appitizer, int amount) {

        for (int i = 0; i < appitizers.size(); i++) {
            if (appitizers.get(i).getName().equals(appitizer.getName())) {
                appitizers.get(i).addQuantity(amount);
                return;
            }
        }

        appitizers.add(appitizer);
    }

    public void add(MainCourse mainCourse, int amount) {

        for (int i = 0; i < mainCourses.size(); i++) {
            if (mainCourses.get(i).getName().equals(mainCourse.getName())) {
                mainCourses.get(i).addQuantity(amount);
                return;
            }
        }

        mainCourses.add(mainCourse);
    }

    public void add(Dessert dessert, int amount) {

        for (int i = 0; i < desserts.size(); i++) {
            if (desserts.get(i).getName().equals(dessert.getName())) {
                desserts.get(i).addQuantity(amount);
                return;
            }
        }

        desserts.add(dessert);
    }

    public void add(Drink drink, int amount) {

        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getName().equals(drink.getName()) &&
                drinks.get(i).getSize() == drink.getSize()) {
                drinks.get(i).addQuantity(amount);
                return;
            }
        }

        drinks.add(drink);
    }
    
    public void remove(Appitizer appitizer, int amount) {
        int len  = appitizers.size();

        for (int i = 0; i < len; i++) {
            if (appitizers.get(i).getName().equals(appitizer.getName())) {
                appitizers.get(i).removeQuantity();
                if (appitizers.get(i).getQuantity() <= 0) 
                    appitizers.remove(i);
                return;
            }
        }
    }
    
    public void remove(Appitizer appitizer) {
        int len  = appitizers.size();

        for (int i = 0; i < len; i++) {
            if (appitizers.get(i).getName().equals(appitizer.getName())) {
                appitizers.remove(i);
                return;
            }
        }
    }
    
    public void remove(MainCourse mainCourse, int a) {
        int len  = mainCourses.size();

        for (int i = 0; i < len; i++) {
            if (mainCourses.get(i).getName().equals(mainCourse.getName())) {
                mainCourses.get(i).removeQuantity();
                
                if (mainCourses.get(i).getQuantity() <= 0)
                    mainCourses.remove(i);
                return;
            }
        }
    }
    
    public void remove(MainCourse mainCourse) {
        int len  = mainCourses.size();

        for (int i = 0; i < len; i++) {
            if (mainCourses.get(i).getName().equals(mainCourse.getName())) {
                mainCourses.remove(i);
                return;
            }
        }
    }
    
    public void remove(Dessert dessert, int a) {
        int len  = desserts.size();

        for (int i = 0; i < len; i++) {
            if (desserts.get(i).getName().equals(dessert.getName())) {
                desserts.get(i).removeQuantity();
                if (desserts.get(i).getQuantity() <= 0)
                    desserts.remove(i);
                return;
            }
        }
    }
    
    public void remove(Dessert dessert) {
        int len  = desserts.size();

        for (int i = 0; i < len; i++) {
            if (desserts.get(i).getName().equals(dessert.getName())) {
                desserts.remove(i);
                return;
            }
        }
    }
    
    public void remove(Drink drink, int a) {
        int len = drinks.size();
        
        
        for (int i = 0; i < len; i++) {
            if (drinks.get(i).getName().equals(drink.getName()) &&
                    drinks.get(i).getSize() == drink.getSize() &&
                    drinks.get(i).getVariant().equals(drink.getVariant())) {
                
                drinks.get(i).removeQuantity();
                
                if (drinks.get(i).getQuantity() <= 0) 
                    drinks.remove(i);
            }
        }
    }
    
    public void remove(Drink drink) {
        int len = drinks.size();
        
        for (int i = 0; i < len; i++) {
            if (drinks.get(i).getName().equals(drink.getName()) &&
                    drinks.get(i).getSize() == drink.getSize() &&
                    drinks.get(i).getVariant().equals(drink.getVariant())) {
                
                    drinks.remove(i);
                    return;
            }
        }
    }
    
    public void removeAll() {
        appitizers.clear();
        mainCourses.clear();
        desserts.clear();
        drinks.clear();
    }

    public ArrayList<Appitizer> getAppitizers() {
        return appitizers;
    }

    public ArrayList<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }
    
    public double getTotal() {
        double total = 0;
        
        for (Appitizer appitizer : appitizers) {
            total += appitizer.getPrice() * appitizer.getQuantity();
        }
        
        for (MainCourse mainCourse : mainCourses) {
            total += mainCourse.getPrice() * mainCourse.getQuantity();
        }
        
        for (Dessert dessert : desserts) {
            total += dessert.getPrice() * dessert.getQuantity();
        }
        
        for (Drink drink : drinks) {
            total += drink.getPrice() * drink.getQuantity();
        }
        
        return total;
    }
}
