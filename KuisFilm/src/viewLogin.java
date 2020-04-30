
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class viewLogin extends JFrame{
    private Connection koneksi;
    private Statement statement;
    private ResultSet cek;
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
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/film";
                    koneksi = DriverManager.getConnection(url, "root", "");
                    statement = koneksi.createStatement();
                    try{
                        String query = "SELECT * FROM admin WHERE username='"+txuser.getText()+"' "
                                + "AND password='"+txpass.getText()+"'";;
                        cek = statement.executeQuery(query);
                        if(cek.next()){
                                if(txuser.getText().equals(cek.getString("username")) 
                                        && txpass.getText().equals(cek.getString("password"))){
                                    setVisible(false);
                                    mainMVC mvc = new mainMVC();
                                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                                }
                        }else{
                            JOptionPane.showMessageDialog(null, "Username atau Password Salah");
                        }    
                    }catch(Exception sql){
                        JOptionPane.showMessageDialog(null, sql.getMessage());
                    }
                }catch(ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Class Not found : " + ex);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "SQL Exception : " + ex);
                }
            }
        });
    }
}
