import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class controllerLogin {
    modelLogin modellogin;
    viewLogin viewlogin;
    daoLogin daologin;
    
    public controllerLogin(modelLogin modellogin, viewLogin viewlogin, daoLogin daologin){
        this.modellogin = modellogin;
        this.viewlogin = viewlogin;
        this.daologin = daologin;
        
        viewlogin.login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = viewlogin.getNama();
                String pass = viewlogin.getPass();
                if (nama.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap isi semua field");
                } else {
                    modellogin.setmodelLogin(nama, pass);
                    boolean login = daologin.Login(modellogin);
                    if (login) {
                        mainMVC mvc = new mainMVC();
                        JOptionPane.showMessageDialog(null, "Login Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(null, "Username atau Password Salah");
                    }
                }
            }
        });
    }
}
