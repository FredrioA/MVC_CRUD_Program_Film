
import java.sql.*;
import javax.swing.JOptionPane;


public class PageDAO {
    Connection koneksi;
    Statement statement;
    
     public PageDAO(){
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
     
    public void Insert(PageModel Model){
        try{
            String query = "INSERT INTO data_film VALUES ('"+0+"','"+Model.getJudul()+
                    "','"+Model.getTipe()+"','"+Model.getEpisode()+
                    "','"+Model.getGenre()+"','"+Model.getStatus()+
                    "','"+Model.getRating()+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data disimpan");
        }catch(Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void Update(PageModel Model){
        try{
            String query = "UPDATE data_film SET judul ='"+Model.getJudul()+
                    "',tipe='"+Model.getTipe()+"',episode='"+Model.getEpisode()+
                    "',genre='"+Model.getGenre()+"',status='"+Model.getStatus()+
                    "',rating='"+Model.getRating()+"' WHERE id='"+Model.getId()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil di update");
        }catch(Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void Delete(PageModel Model){
        try{
            String query = "DELETE FROM data_film WHERE id='"+Model.getId()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
        }catch(Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] Cari(PageModel Model){
        try{
            int Data = 0;
            int no = 1;
            String data[][] = new String[getJmldatacari(Model)][8];
            String query = "SELECT * FROM data_film WHERE judul LIKE '%"+Model.getCari()+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[Data][0] = Integer.toString(no);
                data[Data][1] = resultSet.getString("id");
                data[Data][2] = resultSet.getString("judul");
                data[Data][3] = resultSet.getString("tipe");
                data[Data][4] = resultSet.getString("episode");
                data[Data][5] = resultSet.getString("genre");
                data[Data][6] = resultSet.getString("status");
                data[Data][7] = resultSet.getString("rating");
                no++;
                Data++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] readFilm(){
        try{
            int jmlData = 0;
            int no = 1;
            String data[][] = new String[getJmldata()][8];
            String query = "SELECT * FROM data_film";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = Integer.toString(no);
                data[jmlData][1] = resultSet.getString("id");
                data[jmlData][2] = resultSet.getString("judul");
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                no++;
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public int getJmldata(){
        int jmlData = 0;
        try{
            String query = "SELECT * FROM data_film";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
             return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
     
    public int getJmldatacari(PageModel Model){
        int jmlData = 0;
        try{
            String query = "SELECT * FROM data_film WHERE judul LIKE '%"+Model.getCari()+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
             return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
}
