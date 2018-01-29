
package MenuPrincipal;

import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import MenuPrincipal.MenuPrincipal;

public class Login extends javax.swing.JFrame {
    
    int xx;
    int xy;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/cocinero.png")).getImage());
    }
    
    public void buscarUsuario()
    {      
        String asql="";
        ConexionMySQL mysql=new ConexionMySQL();       
        Connection cn=mysql.conectar(); 
        
        String usu=txtUsuario.getText();
        String contra=new String(txtpContraseña.getPassword());  
        
        asql="SELECT * FROM empleado "
                +"WHERE usuario='" + usu + "' and contraseña='" + contra + "'";
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);
            
            if(rs.next()){
                JOptionPane.showMessageDialog( null, " BIENVENIDO, "+usu+" AHORA PUEDE HACER USO DEL SISTEMA", "INGRESAR", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new MenuPrincipal().setVisible(true); 
            }else{
                JOptionPane.showMessageDialog( null, "ERROR NO ES USUARIO REGISTRADO", "VERIFICAR", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        lblUsu = new javax.swing.JLabel();
        lblCon = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtpContraseña = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(543, 448));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setMaximumSize(new java.awt.Dimension(543, 448));
        jPanel1.setMinimumSize(new java.awt.Dimension(543, 448));
        jPanel1.setPreferredSize(new java.awt.Dimension(543, 448));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(61, 179, 150));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(61, 179, 150));
        jLabel1.setText("Registrate");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 350, 80, 60);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        btnIngresar.setBackground(new java.awt.Color(61, 179, 150));
        btnIngresar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Login");
        btnIngresar.setToolTipText("");
        btnIngresar.setBorder(null);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar);
        btnIngresar.setBounds(30, 120, 360, 40);

        lblUsu.setBackground(new java.awt.Color(255, 255, 255));
        lblUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.png"))); // NOI18N
        jPanel2.add(lblUsu);
        lblUsu.setBounds(360, 20, 24, 40);

        lblCon.setBackground(new java.awt.Color(255, 255, 255));
        lblCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contraseña.png"))); // NOI18N
        jPanel2.add(lblCon);
        lblCon.setBounds(360, 70, 24, 40);

        txtUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtUsuario.setText("jack");
        txtUsuario.setBorder(null);
        txtUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtUsuarioCaretUpdate(evt);
            }
        });
        jPanel2.add(txtUsuario);
        txtUsuario.setBounds(30, 20, 330, 40);

        txtpContraseña.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtpContraseña.setText("123456");
        txtpContraseña.setBorder(null);
        txtpContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpContraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(txtpContraseña);
        txtpContraseña.setBounds(30, 70, 330, 40);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(360, 20, 30, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(360, 70, 30, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 160, 410, 180);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SAZÓN FISI");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(160, 40, 230, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cocinero.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 20, 90, 80);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Iniciar Sesion");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 100, 110, 60);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("¿No tienes cuenta?");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 350, 160, 60);

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar16.png"))); // NOI18N
        cerrar.setText("jLabel6");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarMousePressed(evt);
            }
        });
        jPanel1.add(cerrar);
        cerrar.setBounds(510, 10, 20, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-hacia-abajo.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(480, 10, 20, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        cUsuario usu=new cUsuario();
        usu.escribir(txtUsuario.getText());
        buscarUsuario();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void cerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_cerrarMousePressed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void txtpContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpContraseñaActionPerformed

    private void txtUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtUsuarioCaretUpdate

    }//GEN-LAST:event_txtUsuarioCaretUpdate

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCon;
    private javax.swing.JLabel lblUsu;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtpContraseña;
    // End of variables declaration//GEN-END:variables
}
