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
                modellogin.setmodelLogin(nama, pass);
                daologin.Login(modellogin);
            }
        });
    }
}
