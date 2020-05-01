
public class modelLogin {
    private String username, password;
    
    public void setmodelLogin(String nusername, String npassword){
        this.username = nusername;
        this.password = npassword;
    }
    
    public String getName(){
        return username;
    }
    public void getName(String username){
        this.username = username;
    }
    public String getPass(){
        return password;
    }
    public void getPass(String password){
        this.password = password;
    }
}
