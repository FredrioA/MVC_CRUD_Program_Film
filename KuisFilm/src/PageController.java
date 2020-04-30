import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PageController {
    PageModel pagemodel;
    PageView pageview;
    PageDAO pagedao;
    
    public PageController(PageModel pagemodel, PageView pageview, PageDAO pagedao){
        this.pagemodel = pagemodel;
        this.pageview = pageview;
        this.pagedao = pagedao;
        
        if (pagedao.getJmldata() != 0){
            String dataMahasiswa[][] = pagedao.readFilm();
            pageview.tabel.setModel((new JTable(dataMahasiswa, pageview.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        pageview.create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String judul = pageview.getJudul();
              String tipe = pageview.getTipe();
              String status = pageview.getStatus();
              String episode = pageview.getEpisode();
              String rating = pageview.getRating();
              String genre = pageview.getGenre();
              if(judul.isEmpty()||tipe.isEmpty()||status.isEmpty()||episode.isEmpty()
                      ||rating.isEmpty()||genre.isEmpty()){
                  JOptionPane.showMessageDialog(null, "Harap isi semua field");
              }else{
                  pagemodel.setPageModel(judul, tipe, status, episode, rating, genre);
                  pagedao.Insert(pagemodel);
              }
            }
        });
        
        pageview.refresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String dataFilm[][] = pagedao.readFilm();
              pageview.txepisode.setText("");
              pageview.txjudul.setText("");
              pageview.txtipe.setText("");
              pageview.txrating.setText("");
              pageview.txgenre.setText("");
              pageview.tabel.setModel((new JTable(dataFilm, pageview.namaKolom)).getModel());
            }
        });
        
        pageview.cari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String cari = pageview.getCari();
              pagemodel.setCari(cari);
              String dataFilm[][] = pagedao.Cari(pagemodel);
              pageview.txepisode.setText("");
              pageview.txjudul.setText("");
              pageview.txtipe.setText("");
              pageview.txrating.setText("");
              pageview.txgenre.setText("");
              pageview.tabel.setModel((new JTable(dataFilm, pageview.namaKolom)).getModel());
            }
        });
        
        pageview.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
		int pilih = pageview.tabel.getSelectedRow();
                    if(pilih == -1)
                        {
                            return;
			}
                    else{
                    String set = (String) pageview.tabel.getValueAt(pilih, 1);
                    int id = Integer.parseInt(set);
                    pagemodel.setId(id);
                    String judul = (String) pageview.tabel.getValueAt(pilih, 2);
                    pageview.txjudul.setText(judul);
                    String tipe = (String) pageview.tabel.getValueAt(pilih, 3);
                    pageview.txtipe.setText(tipe);
                    String episode = (String) pageview.tabel.getValueAt(pilih, 4);
                    pageview.txepisode.setText(episode);
                    String genre = (String) pageview.tabel.getValueAt(pilih, 5);
                    pageview.txgenre.setText(genre);
                    String rating = (String) pageview.tabel.getValueAt(pilih, 7);
                    pageview.txrating.setText(rating);}
            }
	});
        
        pageview.update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String judul = pageview.getJudul();
              String tipe = pageview.getTipe();
              String status = pageview.getStatus();
              String episode = pageview.getEpisode();
              String rating = pageview.getRating();
              String genre = pageview.getGenre();
              if(judul.isEmpty()||tipe.isEmpty()||status.isEmpty()||episode.isEmpty()
                      ||rating.isEmpty()||genre.isEmpty()){
                  JOptionPane.showMessageDialog(null, "Harap isi semua field");
              }else{
                  pagemodel.setPageModel(judul, tipe, status, episode, rating, genre);
                  pagedao.Update(pagemodel);
                  String dataMahasiswa[][] = pagedao.readFilm();
                  pageview.txepisode.setText("");
                  pageview.txjudul.setText("");
                  pageview.txtipe.setText("");
                  pageview.txrating.setText("");
                  pageview.txgenre.setText("");
                  pageview.tabel.setModel((new JTable(dataMahasiswa, pageview.namaKolom)).getModel());
              }
            }
        });
        
        pageview.delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String judul = pageview.getJudul();
              String tipe = pageview.getTipe();
              String status = pageview.getStatus();
              String episode = pageview.getEpisode();
              String rating = pageview.getRating();
              String genre = pageview.getGenre();
              if(judul.isEmpty()||tipe.isEmpty()||status.isEmpty()||episode.isEmpty()
                      ||rating.isEmpty()||genre.isEmpty()){
                  JOptionPane.showMessageDialog(null, "Harap isi semua field");
              }else{
                  pagemodel.setPageModel(judul, tipe, status, episode, rating, genre);
                  pagedao.Delete(pagemodel);
                  String dataMahasiswa[][] = pagedao.readFilm();
                  pageview.txepisode.setText("");
                  pageview.txjudul.setText("");
                  pageview.txtipe.setText("");
                  pageview.txrating.setText("");
                  pageview.txgenre.setText("");
                  pageview.tabel.setModel((new JTable(dataMahasiswa, pageview.namaKolom)).getModel());
              }
            }
        });
        
        pageview.exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
