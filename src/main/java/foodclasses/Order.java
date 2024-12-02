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

    public void addAppitizer(Appitizer appitizer) {
        appitizers.add(appitizer);
    }

    public void addMainCourse(MainCourse mainCourse) {
        mainCourses.add(mainCourse);
    }

    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void removeAppitizer(Appitizer appitizer) {
        appitizers.remove(appitizer);
    }

    public void removeMainCourse(MainCourse mainCourse) {
        mainCourses.remove(mainCourse);
    }

    public void removeDessert(Dessert dessert) {
        desserts.remove(dessert);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
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
    
    
}
