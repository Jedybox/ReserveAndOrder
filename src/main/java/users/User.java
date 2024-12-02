package users;

public class User {
    
    private String name;
    private boolean isAdmin = false;

    public User() {}

    public void setName( String name ) {
        this.name = name;
    }

    public void setAdmin( boolean isAdmin ) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
