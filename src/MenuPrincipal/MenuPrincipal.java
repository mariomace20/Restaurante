package MenuPrincipal;


import BalanceGeneral.MenuBalanceGeneral;
import Comanda.MenuComanda;
import Registro.MenuRegistros;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MenuPrincipal extends javax.swing.JFrame {

    private Timer timer;

    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/cocinero.png")).getImage());
        
        ///Lectura de Archivo
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String lec;
        try{
            archivo = new File("usuario.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine())!= null){
                lblUsuario.setText(linea);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ha sucedido un error "+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenus = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JLabel();
        paneRegistro = new javax.swing.JPanel();
        btnRegistro = new javax.swing.JButton();
        paneComanda = new javax.swing.JPanel();
        btnComanda = new javax.swing.JButton();
        paneInicio = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        paneNosotros = new javax.swing.JPanel();
        btnNosotros = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        lbHoras = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbMinutos = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbSegundos = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelBarraSup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        minimizar3 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(970, 605));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        panelMenus.setBackground(new java.awt.Color(51, 51, 51));
        panelMenus.setLayout(null);

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-de-encendido.png"))); // NOI18N
        btnCerrarSesion.setText(" Cerrar Sesion");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        panelMenus.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(30, 520, 120, 30);

        paneRegistro.setBackground(new java.awt.Color(51, 51, 51));
        paneRegistro.setLayout(null);

        btnRegistro.setBackground(new java.awt.Color(51, 51, 51));
        btnRegistro.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/copia.png"))); // NOI18N
        btnRegistro.setText("Registros");
        btnRegistro.setToolTipText("");
        btnRegistro.setBorder(null);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setFocusPainted(false);
        btnRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        paneRegistro.add(btnRegistro);
        btnRegistro.setBounds(10, 0, 170, 100);

        panelMenus.add(paneRegistro);
        paneRegistro.setBounds(0, 280, 180, 100);

        paneComanda.setBackground(new java.awt.Color(51, 51, 51));
        paneComanda.setLayout(null);

        btnComanda.setBackground(new java.awt.Color(51, 51, 51));
        btnComanda.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnComanda.setForeground(new java.awt.Color(255, 255, 255));
        btnComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cena (1).png"))); // NOI18N
        btnComanda.setText("Comandas");
        btnComanda.setToolTipText("");
        btnComanda.setBorder(null);
        btnComanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComanda.setFocusPainted(false);
        btnComanda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComanda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComandaActionPerformed(evt);
            }
        });
        paneComanda.add(btnComanda);
        btnComanda.setBounds(10, 0, 170, 100);

        panelMenus.add(paneComanda);
        paneComanda.setBounds(0, 180, 180, 100);

        paneInicio.setBackground(new java.awt.Color(51, 51, 51));
        paneInicio.setLayout(null);

        btnInicio.setBackground(new java.awt.Color(51, 51, 51));
        btnInicio.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicioCasa.png"))); // NOI18N
        btnInicio.setText("Home");
        btnInicio.setToolTipText("");
        btnInicio.setBorder(null);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFocusPainted(false);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        paneInicio.add(btnInicio);
        btnInicio.setBounds(10, 0, 170, 100);

        panelMenus.add(paneInicio);
        paneInicio.setBounds(0, 80, 180, 100);

        paneNosotros.setBackground(new java.awt.Color(51, 51, 51));
        paneNosotros.setLayout(null);

        btnNosotros.setBackground(new java.awt.Color(51, 51, 51));
        btnNosotros.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnNosotros.setForeground(new java.awt.Color(255, 255, 255));
        btnNosotros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/chef.png"))); // NOI18N
        btnNosotros.setText("Nosotros");
        btnNosotros.setToolTipText("");
        btnNosotros.setBorder(null);
        btnNosotros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNosotros.setFocusPainted(false);
        btnNosotros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNosotros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNosotrosActionPerformed(evt);
            }
        });
        paneNosotros.add(btnNosotros);
        btnNosotros.setBounds(10, 0, 170, 100);

        panelMenus.add(paneNosotros);
        paneNosotros.setBounds(0, 380, 180, 100);

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("AM");
        panelMenus.add(jLabel19);
        jLabel19.setBounds(120, 40, 30, 20);

        lbHoras.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbHoras.setForeground(new java.awt.Color(255, 255, 255));
        lbHoras.setText("0");
        panelMenus.add(lbHoras);
        lbHoras.setBounds(20, 40, 20, 20);

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(":");
        panelMenus.add(jLabel21);
        jLabel21.setBounds(40, 40, 20, 20);

        lbMinutos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbMinutos.setForeground(new java.awt.Color(255, 255, 255));
        lbMinutos.setText("0");
        panelMenus.add(lbMinutos);
        lbMinutos.setBounds(60, 40, 20, 20);

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText(":");
        panelMenus.add(jLabel23);
        jLabel23.setBounds(80, 40, 20, 20);

        lbSegundos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbSegundos.setForeground(new java.awt.Color(255, 255, 255));
        lbSegundos.setText("0");
        panelMenus.add(lbSegundos);
        lbSegundos.setBounds(100, 40, 20, 20);

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Hora del Sistema");
        panelMenus.add(jLabel20);
        jLabel20.setBounds(20, 10, 100, 16);

        getContentPane().add(panelMenus);
        panelMenus.setBounds(0, 40, 180, 630);

        panelPrincipal.setBackground(new java.awt.Color(248, 254, 244));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(790, 570));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(790, 570));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel5.setText("¡ Bienvenido al restaurante SAZON FISI !");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/como.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vidrio.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ensalada.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medalla.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos (2).png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pavo.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setText("Preferencia de la gente");

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel14.setText("Saludable");

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setText("Calidad Total");

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel17.setText("Comida deliciosa");

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel18.setText("Celebracion");

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel16.setText("Atencion Confortable");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(164, 164, 164))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addGap(102, 102, 102)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 38, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(177, 177, 177)
                                .addComponent(jLabel15)
                                .addGap(94, 94, 94))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel17))
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18)
                                        .addGap(110, 110, 110))))))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addContainerGap(571, Short.MAX_VALUE))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(51, 51, 51)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(33, 33, 33)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel17))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal);
        panelPrincipal.setBounds(180, 40, 790, 570);

        panelBarraSup.setBackground(new java.awt.Color(51, 51, 51));
        panelBarraSup.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelBarraSupMouseDragged(evt);
            }
        });
        panelBarraSup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBarraSupMousePressed(evt);
            }
        });
        panelBarraSup.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("El restaurante de la buena comida :)");
        panelBarraSup.add(jLabel2);
        jLabel2.setBounds(400, 0, 220, 44);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        panelBarraSup.add(jLabel6);
        jLabel6.setBounds(10, 10, 30, 24);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cocinero24.png"))); // NOI18N
        jLabel7.setText(" Sazon FISI");
        panelBarraSup.add(jLabel7);
        jLabel7.setBounds(50, 0, 110, 44);

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user2.png"))); // NOI18N
        lblUsuario.setText("Usuario");
        panelBarraSup.add(lblUsuario);
        lblUsuario.setBounds(780, -10, 120, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/notificacion.png"))); // NOI18N
        panelBarraSup.add(jLabel3);
        jLabel3.setBounds(720, -10, 60, 60);

        minimizar3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minimizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-hacia-abajo.png"))); // NOI18N
        minimizar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizar3MouseClicked(evt);
            }
        });
        panelBarraSup.add(minimizar3);
        minimizar3.setBounds(910, 0, 20, 40);

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar16.png"))); // NOI18N
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        panelBarraSup.add(cerrar);
        cerrar.setBounds(940, 0, 20, 40);

        getContentPane().add(panelBarraSup);
        panelBarraSup.setBounds(0, 0, 970, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandaActionPerformed
        paneComanda.setBackground(new Color(255, 140, 50));
        btnComanda.setBackground(new Color(40, 40, 40));
        paneInicio.setBackground(new Color(51, 51, 51));
        paneRegistro.setBackground(new Color(51, 51, 51));
        btnRegistro.setBackground(new Color(51, 51, 51));
        btnInicio.setBackground(new Color(51, 51, 51));
        paneNosotros.setBackground(new Color(51, 51, 51));
        btnNosotros.setBackground(new Color(51, 51, 51));
        
        MenuComanda p1 = new MenuComanda();
        p1.setSize(790, 570);
        p1.setLocation(0, 0);
        panelPrincipal.removeAll();
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate(); 
        panelPrincipal.repaint();
    }//GEN-LAST:event_btnComandaActionPerformed

    private void minimizar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizar3MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizar3MouseClicked

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    public class cronometro implements ActionListener{
    
        public void actionPerformed(ActionEvent evt){
        
            GregorianCalendar tiempo = new GregorianCalendar();
            int hora, minutos, segundos;

            hora=tiempo.get(Calendar.HOUR_OF_DAY);
            minutos=tiempo.get(Calendar.MINUTE);
            segundos=tiempo.get(Calendar.SECOND);
            
            lbHoras.setText(String.valueOf(hora));
            lbMinutos.setText(String.valueOf(minutos));
            lbSegundos.setText(String.valueOf(segundos));

        }
    }
    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        paneRegistro.setBackground(new Color(255, 140, 50));
        btnRegistro.setBackground(new Color(40, 40, 40));
        paneInicio.setBackground(new Color(51, 51, 51));
        paneComanda.setBackground(new Color(51, 51, 51));
        btnComanda.setBackground(new Color(51, 51, 51));
        btnInicio.setBackground(new Color(51, 51, 51));
        paneNosotros.setBackground(new Color(51, 51, 51));
        btnNosotros.setBackground(new Color(51, 51, 51));
        
        MenuRegistros p1 = new MenuRegistros();
        p1.setSize(790, 570);
        p1.setLocation(0, 0);
        panelPrincipal.removeAll();
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate(); 
        panelPrincipal.repaint();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void panelBarraSupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraSupMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panelBarraSupMousePressed

    private void panelBarraSupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraSupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_panelBarraSupMouseDragged

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        paneInicio.setBackground(new Color(255, 140, 50));
        btnInicio.setBackground(new Color(40, 40, 40));
        paneRegistro.setBackground(new Color(51, 51, 51));
        btnRegistro.setBackground(new Color(51, 51, 51));        
        paneComanda.setBackground(new Color(51, 51, 51));
        btnComanda.setBackground(new Color(51, 51, 51));
        paneNosotros.setBackground(new Color(51, 51, 51));
        btnNosotros.setBackground(new Color(51, 51, 51));
        
        Inicio p1 = new Inicio();
        p1.setSize(790, 570);
        p1.setLocation(0, 0);
        panelPrincipal.removeAll();
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate(); 
        panelPrincipal.repaint();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        this.dispose();
        Login l=new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNosotrosActionPerformed
        paneNosotros.setBackground(new Color(255, 140, 50));
        btnNosotros.setBackground(new Color(40, 40, 40));
        paneInicio.setBackground(new Color(51, 51, 51));
        btnInicio.setBackground(new Color(51, 51, 51));
        paneRegistro.setBackground(new Color(51, 51, 51));
        btnRegistro.setBackground(new Color(51, 51, 51));        
        paneComanda.setBackground(new Color(51, 51, 51));
        btnComanda.setBackground(new Color(51, 51, 51));
        
        
        Nosotros p1 = new Nosotros();
        p1.setSize(790, 570);
        p1.setLocation(0, 0);
        panelPrincipal.removeAll();
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate(); 
        panelPrincipal.repaint();
    }//GEN-LAST:event_btnNosotrosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        timer = new Timer(1000, new cronometro());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    int xy;
    int xx;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JButton btnComanda;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnNosotros;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbHoras;
    private javax.swing.JLabel lbMinutos;
    private javax.swing.JLabel lbSegundos;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel minimizar3;
    private javax.swing.JPanel paneComanda;
    private javax.swing.JPanel paneInicio;
    private javax.swing.JPanel paneNosotros;
    private javax.swing.JPanel paneRegistro;
    private javax.swing.JPanel panelBarraSup;
    private javax.swing.JPanel panelMenus;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}



