package users;

public class Customer extends User{
    
    private String password; 
    private int id;

    public Customer( String name, String password , int id) {
        super();
        setName( name );
        this.password = password;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void order() {
        
    }
    
    public void reserve() {
        
    }
    
    public void pay() {
        
    }
    
    public void cancel() {
        
    }

}
