
package MenuPrincipal;

import java.io.*;
import javax.swing.JOptionPane;
public class cUsuario {
    
    public void escribir(String usuario){
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            fichero = new FileWriter("usuario.txt");
            pw = new PrintWriter(fichero);
            
            pw.println(usuario);
            
            if(null!=fichero){
                fichero.close();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ha sucedido un error "+e);
        }
    } 
}
