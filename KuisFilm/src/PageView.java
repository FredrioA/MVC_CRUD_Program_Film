import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PageView extends JFrame {
    JLabel judul, tipe, status, episode, rating, genre;
    JTextField txjudul, txtipe, txepisode, txrating, txgenre, txcari;
    JComboBox cbstatus; 
    JButton cari, refresh, create, update, delete, exit;
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"No","ID","Judul","Tipe","Episode","Genre","Status","Rating"};
    Statement statement;
    
    public PageView(){
        setTitle("Program Pengolahan Data Film");
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        judul = new JLabel("Judul");
        tipe = new JLabel("Tipe");
        status = new JLabel("Status");
        episode = new JLabel("Episode");
        rating = new JLabel("Rating");
        genre = new JLabel("Genre");
        
        txjudul = new JTextField();
        txtipe = new JTextField();
        txepisode = new JTextField();
        txrating = new JTextField();
        txgenre = new JTextField();
        txcari = new JTextField();
        
        cbstatus = new JComboBox();
        cbstatus.addItem("Selesai");
        cbstatus.addItem("Belum");
        
        cari = new JButton("Search");
        refresh = new JButton("Refresh");
        create = new JButton("Create");
        update = new JButton("Update");
        delete = new JButton("Delete");
        exit = new JButton("Exit");
        
        setLayout(null);
        add(judul);
        add(tipe);
        add(status);
        add(episode);
        add(rating);
        add(genre);
        add(txjudul);
        add(txtipe);
        add(txepisode);
        add(txrating);
        add(txgenre);
        add(txcari);
        add(cbstatus);
        add(cari);
        add(refresh);
        add(create);
        add(update);
        add(delete);
        add(exit);
        add(scrollPane);
        
        judul.setBounds(20, 280, 80, 25);
        txjudul.setBounds(20, 310, 290, 25);
        tipe.setBounds(20, 340, 80, 25);
        txtipe.setBounds(20, 370, 130, 25);
        status.setBounds(180, 340, 80, 25);
        cbstatus.setBounds(180, 370, 130, 25);
        episode.setBounds(20, 400, 80, 25);
        txepisode.setBounds(20, 430, 130, 25);
        rating.setBounds(180, 400, 80, 25);
        txrating.setBounds(180, 430, 130, 25);
        genre.setBounds(20, 460, 80, 25);
        txgenre.setBounds(20, 490, 290, 25);
        refresh.setBounds(370, 490, 80, 25);
        create.setBounds(470, 490, 80, 25);
        update.setBounds(570, 490, 80, 25);
        delete.setBounds(670, 490, 80, 25);
        txcari.setBounds(370, 310, 270, 25);
        cari.setBounds(670, 310, 80, 25);
        exit.setBounds(670, 370, 80, 25);
        scrollPane.setBounds(20, 20, 740, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getJudul(){
        return txjudul.getText();
    }
    
    public String getTipe(){
        return txtipe.getText();
    }
    
    public String getStatus(){
        return (String)cbstatus.getSelectedItem();
    }
    
    public String getEpisode(){
        return txepisode.getText();
    }
    
    public String getRating(){
        return txrating.getText();
    }
    
    public String getGenre(){
        return txgenre.getText();
    }
    
    public String getCari(){
        return txcari.getText();
    }
    
}
