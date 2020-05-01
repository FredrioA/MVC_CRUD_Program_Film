
import javax.swing.*;


public class viewLogin extends JFrame{
    JLabel judul, username, password;
    JTextField txuser;
    JPasswordField txpass;
    JButton login;
    
    public viewLogin(){
        setTitle("LOGIN");
        judul = new JLabel("LOGIN ADMIN");
        username = new JLabel("Username");
        password = new JLabel("Password");
        
        txuser = new JTextField();
        txpass = new JPasswordField();
        
        login = new JButton("Login");
        
        setLayout(null);
        add(judul);
        add(username);
        add(password);
        add(txuser);
        add(txpass);
        add(login);
 
        judul.setBounds(160, 30, 100, 20);
        username.setBounds(70, 70, 80, 25);
        txuser.setBounds(160, 70, 145, 25);
        password.setBounds(70, 110, 80, 25);
        txpass.setBounds(160, 110, 145, 25);
        login.setBounds(160, 150, 80, 25);

        setSize(400,250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getNama(){
        return txuser.getText();
    }
    
    public String getPass(){
        return txpass.getText();
    }
}
