


public class PageModel {
     private String judul, tipe, status, episode, rating, genre, cari;
     private int id;
    
    public void setPageModel(String njudul, String ntipe, String nstatus, String nepisode, 
            String nrating, String ngenre){
        this.judul = njudul;
        this.tipe = ntipe;
        this.status = nstatus;
        this.episode = nepisode;
        this.rating = nrating;
        this.genre = ngenre;
    }
    public void setCari(String ncari){
        this.cari = ncari;
    }
    public void setId(int nid){
        this.id = nid;
    }
    
    public String getJudul(){
        return judul;
    }
    public void getJudul(String judul){
        this.judul = judul;
    }
    public String getTipe(){
        return tipe;
    }
    public void getTipe(String tipe){
        this.tipe = tipe;
    }
    public String getStatus(){
        return status;
    }
    public void getStatus(String status){
        this.status = status;
    }
    public String getEpisode(){
        return episode;
    }
    public void getEpisode(String episode){
        this.episode = episode;
    }
    public String getRating(){
        return rating;
    }
    public void getRating(String rating){
        this.rating = rating;
    }
    public String getGenre(){
        return genre;
    }
    public void getGenre(String genre){
        this.genre = genre;
    }
    public String getCari(){
        return cari;
    }
    public void getCari(String cari){
        this.cari = cari;
    }
    public int getId(){
        return id;
    }
    public void getId(int id){
        this.id = id;
    }
}
