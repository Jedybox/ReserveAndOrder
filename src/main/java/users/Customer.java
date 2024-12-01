package users;

public class Customer extends User{
    
    private String password; 

    public Customer( String name, String password ) {
        super();
        setName( name );
        this.password = password;
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
