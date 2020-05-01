import java.sql.*;
import javax.swing.JOptionPane;

public class daoLogin {
    Connection koneksi;
    Statement statement;
    private ResultSet cek;
    
    public daoLogin(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/film";
            koneksi = DriverManager.getConnection(url, "root", "");
            statement = koneksi.createStatement();
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Class Not found : " + ex);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "SQL Exception : " + ex);
        }
    }
    
    public boolean Login(modelLogin Model){
        try{
            String query = "SELECT * FROM admin WHERE username='"+Model.getName()+"' "
                                + "AND password='"+Model.getPass()+"'";
            cek = statement.executeQuery(query);
            while (cek.next()) {
                if (Model.getName().equals(cek.getString("username")) && Model.getPass().equals(cek.getString("password"))) {
                    return true;
                }
            }
            return false;
        }catch(Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
            return false;
        }
    }
}
