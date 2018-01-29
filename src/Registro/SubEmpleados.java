
package Registro;

import BaseDatos.ConexionMySQL;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class SubEmpleados extends javax.swing.JPanel {
    DefaultTableModel modelo;

    public SubEmpleados() {
        initComponents();
        modelo = (DefaultTableModel) tablaEmpleados.getModel();
        codEmpleado.setVisible(false);
        bloquear();
        buscarEmpleado(""); 
    }

    public void agregarEmpleado(){
        ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn=mysql.conectar();
        
        String nom,ape,sexo,cel,dni,est_c,urlfoto,usu,cont,area,est,sueldo,bonificacion,descuento,pagar;

        nom = txtNombre.getText();
        ape = txtApellido.getText();
        sexo = cbxGenero.getSelectedItem().toString();
        cel = txtCelular.getText();
        dni = txtDni.getText();
        est_c = cbxCivil.getSelectedItem().toString();
        urlfoto = txtUrl.getText();
        usu = txtUsuario.getText();
        cont = txtpContra.getText();
        area = cbxArea.getSelectedItem().toString();
        est = cbxEstado.getSelectedItem().toString();
        sueldo = txtSueldo.getText();
        bonificacion = txtBoni.getText();
        descuento = txtDes.getText();
        pagar = txtPagar.getText();
        String asql="";
        String mensaje="";
        
        asql = "INSERT INTO empleado(usuario,contraseña,area,estado,sueldo,bonificacion,descuento,neto_pagar,nombres,apellidos,genero,celular,dni,estado_civil,direc_foto,foto)"+
                "VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
        
        mensaje="Los Datos se han guardado de manera Satisfactoria...";
        try 
        {
            FileInputStream  archivofoto;
            PreparedStatement pst = cn.prepareStatement(asql);
            pst.setString(1, usu);
            pst.setString(2, cont);
            pst.setString(3, area);
            pst.setString(4, est);
            pst.setString(5, sueldo);
            pst.setString(6, bonificacion);
            pst.setString(7, descuento);
            pst.setString(8, pagar);
            pst.setString(9, nom);
            pst.setString(10, ape);
            pst.setString(11, sexo);
            pst.setString(12, cel);
            pst.setString(13, dni);
            pst.setString(14, est_c);
            pst.setString(15, urlfoto);
            archivofoto = new FileInputStream(urlfoto);
            pst.setBinaryStream(16, archivofoto);
            
            int n=pst.executeUpdate();
            
            if(n>0)
            {            
                JOptionPane.showMessageDialog(null,mensaje,"Guardando",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SubEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ActualizarEmpleado(){
        
        try{
            ConexionMySQL  mysql=new ConexionMySQL();
            Connection cn=mysql.conectar();

            String cod,nom,ape,sexo,cel,dni,est_c,urlfoto,usu,cont,area,est,sueldo,bonificacion,descuento,pagar;

            cod=codEmpleado.getText();

            nom = txtNombre.getText();
            ape = txtApellido.getText();
            sexo = cbxGenero.getSelectedItem().toString();
            cel = txtCelular.getText();
            dni = txtDni.getText();
            est_c = cbxCivil.getSelectedItem().toString();
            urlfoto = txtUrl.getText();
            usu = txtUsuario.getText();
            cont = txtpContra.getText();
            area = cbxArea.getSelectedItem().toString();
            est = cbxEstado.getSelectedItem().toString();
            sueldo = txtSueldo.getText();
            bonificacion = txtBoni.getText();
            descuento = txtDes.getText();
            pagar = txtPagar.getText();

            String sql="UPDATE empleado SET "
                     + "usuario = ?,"
                     + "contraseña = ?,"
                     + "area = ?,"
                     + "estado = ?,"
                     + "sueldo = ?,"
                     + "bonificacion = ?,"
                     + "descuento = ?,"
                     + "neto_pagar = ?,"
                     + "nombres = ?,"
                     + "apellidos = ?,"
                     + "genero = ?,"
                     + "celular = ?,"
                     + "dni = ?,"
                     + "estado_civil = ?,"
                     + "direc_foto = ?,"
                     + "foto = ?"
                     + " WHERE cod_empleado = '"+cod+"'"; 
         
            PreparedStatement pst = cn.prepareStatement(sql);
            FileInputStream  archivofoto;
            pst.setString(1, usu);
            pst.setString(2, cont);
            pst.setString(3, area);
            pst.setString(4, est);
            pst.setString(5, sueldo);
            pst.setString(6, bonificacion);
            pst.setString(7, descuento);
            pst.setString(8, pagar);
            pst.setString(9, nom);
            pst.setString(10, ape);
            pst.setString(11, sexo);
            pst.setString(12, cel);
            pst.setString(13, dni);
            pst.setString(14, est_c);
            pst.setString(15, urlfoto);
            archivofoto = new FileInputStream(urlfoto);
            pst.setBinaryStream(16, archivofoto);
            
            int n= pst.executeUpdate();
            String mensaje="Los datos han sido modificados de manera satisfactoria";
            if(n>0){            
                JOptionPane.showMessageDialog(null,mensaje,"Actualizar",JOptionPane.INFORMATION_MESSAGE);
            }
            limpiarTodo();
            bloquear();
            btnActualizar.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
    
    public void buscarEmpleado(String valor){
        String[] titulos={"Codigo","Nombres","Apellidos"} ;
        String[] registro=new String[3];     
        modelo=new DefaultTableModel(null,titulos);
        
        String asql="";
        
        ConexionMySQL mysql=new ConexionMySQL();       
        Connection cn=mysql.conectar();
        
        asql="SELECT * FROM empleado "
                +"WHERE CONCAT(nombres,' ',apellidos) LIKE '%"+valor+"%'";
        
        try 
        {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);
            
            while(rs.next())
            {
                registro[0]=rs.getString("cod_empleado");
                registro[1]=rs.getString("nombres");
                registro[2]=rs.getString("apellidos");
                
                modelo.addRow(registro);
            }
            tablaEmpleados.setModel(modelo);
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    public void limpiar(){
        txtbuscar.setText("");
    }
    public void limpiarTodo(){
        txtNombre.setText(null);
       txtApellido.setText(null);
       cbxGenero.setSelectedItem(null);
       txtCelular.setText(null);
       txtDni.setText(null);;
       cbxCivil.setSelectedItem(null);
       txtUsuario.setText(null);
       txtpContra.setText(null);
       cbxArea.setSelectedItem(null);
       cbxEstado.setSelectedItem(null);
       txtSueldo.setText(null);
       txtBoni.setText(null);
       txtDes.setText(null);
       txtPagar.setText(null);
       cbxGenero.setSelectedItem(null);
        cbxCivil.setSelectedItem(null);
        cbxArea.setSelectedItem(null);
        cbxEstado.setSelectedItem(null);
        String path = "/imagenes/Retratoicono.png";  
        URL url = this.getClass().getResource(path);  
        ImageIcon icon = new ImageIcon(url);
        lblfoto.setIcon(icon);
        txtUrl.setText(null);
    }
    public void bloquear(){
       txtNombre.setEnabled(false);
       txtApellido.setEnabled(false);
       cbxGenero.setEnabled(false);
       txtCelular.setEnabled(false);
       txtDni.setEnabled(false);
       cbxCivil.setEnabled(false);
       btnfoto.setEnabled(false);
       txtUsuario.setEnabled(false);
       txtpContra.setEnabled(false);
       cbxArea.setEnabled(false);
       cbxEstado.setEnabled(false);
       txtSueldo.setEnabled(false);
       txtBoni.setEnabled(false);
       txtDes.setEnabled(false);
       txtPagar.setEnabled(false);
       cbxGenero.setSelectedItem(null);
        cbxCivil.setSelectedItem(null);
        cbxArea.setSelectedItem(null);
        cbxEstado.setSelectedItem(null);
        txtUsuario.setEnabled(false);
        txtpContra.setEnabled(false);
    }
    public void desbloquear(){
       txtNombre.setEnabled(true);
       txtApellido.setEnabled(true);
       cbxGenero.setEnabled(true);
       txtCelular.setEnabled(true);
       txtDni.setEnabled(true);
       cbxCivil.setEnabled(true);
       btnfoto.setEnabled(true);
       txtUsuario.setEnabled(true);
       txtpContra.setEnabled(true);
       txtpContra.setText("");
       cbxArea.setEnabled(true);
       cbxEstado.setEnabled(true);
       txtSueldo.setEnabled(true);
       txtBoni.setEnabled(true);
       txtDes.setEnabled(true);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnexaminar = new javax.swing.JButton();
        txtDni = new javax.swing.JFormattedTextField();
        lblnombre = new javax.swing.JLabel();
        lbldni = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();
        txtApellido = new javax.swing.JTextField();
        lblapellido = new javax.swing.JLabel();
        lblcelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JFormattedTextField();
        lblgenero = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbxCivil = new javax.swing.JComboBox<>();
        txtSueldo = new javax.swing.JTextField();
        txtBoni = new javax.swing.JTextField();
        txtDes = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        txtPagar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        btnfoto = new javax.swing.JButton();
        txtUrl = new javax.swing.JTextField();
        btnlimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        añadirButton = new javax.swing.JButton();
        txtpContra = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        codEmpleado = new javax.swing.JTextField();
        eliminarButton = new javax.swing.JButton();
        modCuenta = new javax.swing.JToggleButton();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();

        modificar.setText("modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificar);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 520));
        setMinimumSize(new java.awt.Dimension(790, 520));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ListaEmpleados.png"))); // NOI18N
        jLabel2.setText("LISTA DE EMPLEADO");
        add(jLabel2);
        jLabel2.setBounds(50, 0, 220, 50);

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellidos"
            }
        ));
        tablaEmpleados.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tablaEmpleados);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 400, 90);

        txtbuscar.setBorder(null);
        add(txtbuscar);
        txtbuscar.setBounds(30, 70, 230, 14);

        btnexaminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnexaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar 16.png"))); // NOI18N
        btnexaminar.setBorderPainted(false);
        btnexaminar.setContentAreaFilled(false);
        btnexaminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexaminar.setPreferredSize(new java.awt.Dimension(65, 23));
        btnexaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexaminarActionPerformed(evt);
            }
        });
        add(btnexaminar);
        btnexaminar.setBounds(270, 70, 30, 30);

        txtDni.setBorder(null);
        try {
            txtDni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        add(txtDni);
        txtDni.setBounds(140, 390, 90, 20);

        lblnombre.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblnombre.setText("Nombre:");
        add(lblnombre);
        lblnombre.setBounds(60, 270, 70, 20);

        lbldni.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbldni.setText("DNI:");
        add(lbldni);
        lbldni.setBounds(60, 390, 70, 20);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("Datos Personales");
        add(jLabel8);
        jLabel8.setBounds(110, 240, 140, 20);

        cbxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerencia", "Administrativo", "Prensa" }));
        cbxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreaActionPerformed(evt);
            }
        });
        add(cbxArea);
        cbxArea.setBounds(620, 260, 90, 20);

        txtApellido.setBorder(null);
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        add(txtApellido);
        txtApellido.setBounds(140, 300, 110, 20);

        lblapellido.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblapellido.setText("Apellidos:");
        add(lblapellido);
        lblapellido.setBounds(60, 300, 70, 20);

        lblcelular.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblcelular.setText("Celular:");
        add(lblcelular);
        lblcelular.setBounds(60, 360, 70, 20);

        txtCelular.setBorder(null);
        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        add(txtCelular);
        txtCelular.setBounds(140, 360, 90, 20);

        lblgenero.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblgenero.setText("Género: ");
        add(lblgenero);
        lblgenero.setBounds(60, 330, 70, 20);

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbxGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxGeneroItemStateChanged(evt);
            }
        });
        cbxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGeneroActionPerformed(evt);
            }
        });
        add(cbxGenero);
        cbxGenero.setBounds(140, 330, 90, 20);

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel22.setText("Estado Civil: ");
        add(jLabel22);
        jLabel22.setBounds(60, 410, 70, 40);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel16.setText("Contraseña: ");
        add(jLabel16);
        jLabel16.setBounds(520, 110, 70, 20);

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel23.setText("Sueldo:");
        add(jLabel23);
        jLabel23.setBounds(520, 320, 70, 20);

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel24.setText("Bonificación: ");
        add(jLabel24);
        jLabel24.setBounds(520, 350, 90, 20);

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel25.setText("Descuento:");
        add(jLabel25);
        jLabel25.setBounds(520, 380, 70, 30);

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel26.setText("Neto a Pagar:");
        add(jLabel26);
        jLabel26.setBounds(520, 410, 90, 30);

        cbxCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado" }));
        cbxCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCivilActionPerformed(evt);
            }
        });
        add(cbxCivil);
        cbxCivil.setBounds(140, 420, 90, 20);

        txtSueldo.setBorder(null);
        txtSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSueldoActionPerformed(evt);
            }
        });
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSueldoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });
        add(txtSueldo);
        txtSueldo.setBounds(620, 320, 90, 20);

        txtBoni.setBorder(null);
        txtBoni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBoniKeyReleased(evt);
            }
        });
        add(txtBoni);
        txtBoni.setBounds(620, 350, 90, 20);

        txtDes.setBorder(null);
        txtDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDesKeyReleased(evt);
            }
        });
        add(txtDes);
        txtDes.setBounds(620, 380, 90, 20);

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel27.setText("Estado:");
        add(jLabel27);
        jLabel27.setBounds(520, 290, 70, 20);

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Retirado", "Vacaciones", "Incapacidad Médica" }));
        cbxEstado.setToolTipText("");
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });
        add(cbxEstado);
        cbxEstado.setBounds(620, 290, 90, 20);

        txtPagar.setBorder(null);
        txtPagar.setEnabled(false);
        txtPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagarActionPerformed(evt);
            }
        });
        add(txtPagar);
        txtPagar.setBounds(620, 410, 90, 20);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Datos Usuario");
        add(jLabel9);
        jLabel9.setBounds(570, 50, 100, 20);

        lblfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Retratoicono.png"))); // NOI18N
        add(lblfoto);
        lblfoto.setBounds(260, 250, 140, 120);

        btnfoto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen.png"))); // NOI18N
        btnfoto.setBorderPainted(false);
        btnfoto.setContentAreaFilled(false);
        btnfoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnfoto.setFocusPainted(false);
        btnfoto.setFocusable(false);
        btnfoto.setPreferredSize(new java.awt.Dimension(65, 23));
        btnfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotoActionPerformed(evt);
            }
        });
        add(btnfoto);
        btnfoto.setBounds(250, 370, 40, 40);

        txtUrl.setEditable(false);
        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });
        add(txtUrl);
        txtUrl.setBounds(290, 380, 110, 20);

        btnlimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrador.png"))); // NOI18N
        btnlimpiar.setBorderPainted(false);
        btnlimpiar.setContentAreaFilled(false);
        btnlimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlimpiar.setPreferredSize(new java.awt.Dimension(65, 23));
        btnlimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlimpiarMouseClicked(evt);
            }
        });
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        add(btnlimpiar);
        btnlimpiar.setBounds(310, 70, 30, 30);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar1.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setEnabled(false);
        btnActualizar.setPreferredSize(new java.awt.Dimension(65, 23));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar);
        btnActualizar.setBounds(250, 450, 140, 30);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel17.setText("Dep/Área: ");
        add(jLabel17);
        jLabel17.setBounds(520, 260, 70, 20);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel18.setText("Usuario:");
        add(jLabel18);
        jLabel18.setBounds(520, 70, 80, 30);

        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        add(txtNombre);
        txtNombre.setBounds(140, 270, 110, 20);

        txtUsuario.setBorder(null);
        txtUsuario.setEnabled(false);
        add(txtUsuario);
        txtUsuario.setBounds(600, 70, 120, 20);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleado.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setPreferredSize(new java.awt.Dimension(65, 23));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        add(btnNuevo);
        btnNuevo.setBounds(110, 450, 110, 30);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Datos Laborales");
        add(jLabel10);
        jLabel10.setBounds(580, 230, 140, 20);

        añadirButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        añadirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadirEmpleado.png"))); // NOI18N
        añadirButton.setText("Añadir");
        añadirButton.setBorderPainted(false);
        añadirButton.setContentAreaFilled(false);
        añadirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        añadirButton.setEnabled(false);
        añadirButton.setPreferredSize(new java.awt.Dimension(65, 23));
        añadirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                añadirButtonMouseClicked(evt);
            }
        });
        añadirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirButtonActionPerformed(evt);
            }
        });
        add(añadirButton);
        añadirButton.setBounds(410, 440, 120, 50);

        txtpContra.setText("jPasswordField1");
        txtpContra.setBorder(null);
        txtpContra.setEnabled(false);
        add(txtpContra);
        txtpContra.setBounds(600, 110, 120, 20);
        add(jSeparator3);
        jSeparator3.setBounds(30, 90, 230, 10);
        add(jSeparator4);
        jSeparator4.setBounds(140, 290, 110, 10);
        add(jSeparator5);
        jSeparator5.setBounds(140, 320, 110, 10);
        add(jSeparator6);
        jSeparator6.setBounds(140, 380, 90, 10);
        add(jSeparator7);
        jSeparator7.setBounds(140, 410, 90, 10);
        add(jSeparator1);
        jSeparator1.setBounds(620, 340, 90, 2);
        add(jSeparator2);
        jSeparator2.setBounds(620, 370, 90, 2);
        add(jSeparator8);
        jSeparator8.setBounds(620, 400, 90, 10);
        add(jSeparator9);
        jSeparator9.setBounds(620, 430, 90, 20);
        add(jSeparator10);
        jSeparator10.setBounds(600, 90, 120, 10);
        add(jSeparator11);
        jSeparator11.setBounds(600, 130, 120, 10);
        add(jSeparator12);
        jSeparator12.setBounds(510, 30, 240, 2);

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator13);
        jSeparator13.setBounds(470, 40, 20, 390);
        add(jSeparator14);
        jSeparator14.setBounds(30, 220, 420, 10);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator15);
        jSeparator15.setBounds(750, 30, 20, 120);

        codEmpleado.setEnabled(false);
        add(codEmpleado);
        codEmpleado.setBounds(30, 240, 70, 20);

        eliminarButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarEmpleado.png"))); // NOI18N
        eliminarButton.setText("Eliminar");
        eliminarButton.setBorderPainted(false);
        eliminarButton.setContentAreaFilled(false);
        eliminarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarButton.setPreferredSize(new java.awt.Dimension(65, 23));
        eliminarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarButtonMouseClicked(evt);
            }
        });
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });
        add(eliminarButton);
        eliminarButton.setBounds(550, 440, 120, 50);

        modCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modCuenta.png"))); // NOI18N
        modCuenta.setText("Modificar cuenta de acceso");
        modCuenta.setBorderPainted(false);
        modCuenta.setContentAreaFilled(false);
        modCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modCuenta.setEnabled(false);
        modCuenta.setFocusPainted(false);
        modCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCuentaActionPerformed(evt);
            }
        });
        add(modCuenta);
        modCuenta.setBounds(480, 160, 290, 32);

        jSeparator21.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator21);
        jSeparator21.setBounds(510, 30, 20, 120);
        add(jSeparator22);
        jSeparator22.setBounds(510, 150, 240, 10);
        add(jSeparator23);
        jSeparator23.setBounds(510, 220, 240, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexaminarActionPerformed
        String valor = txtbuscar.getText();
        buscarEmpleado(valor); 
    }//GEN-LAST:event_btnexaminarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void cbxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAreaActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void cbxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGeneroActionPerformed

    private void cbxCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCivilActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void btnfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfotoActionPerformed
        //Creamos nuestra variable archivo en la cual podremos usar todos los metodos de la clase jFileChooser
        JFileChooser archivo = new JFileChooser();
        //Si deseamos crear filtros para la selecion de archivos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg","jpeg");
        //Si deseas que se muestre primero los filtros usa la linea q esta abajo de esta.
        //archivo.setFileFilter(filtro);
        // Agregamos el Filtro pero cuidado se mostrara despues de todos los archivos
        archivo.addChoosableFileFilter(filtro);
        // Colocamos titulo a nuestra ventana de Seleccion
        archivo.setDialogTitle("Abrir Archivo");
        //Si deseamos que muestre una carpeta predetermina usa la siguiente linea
        //////File ruta = new File("D:/productos");
        //Le implementamos a nuestro ventana de seleccion
         /////archivo.setCurrentDirectory(ruta);
         //Abrimos nuestra Ventana de Selccion
        int ventana = archivo.showOpenDialog(null);
        //hacemos comparacion en caso de aprete el boton abrir
        if(ventana == JFileChooser.APPROVE_OPTION)
        {
            //Obtenemos la ruta de nuestra imagen seleccionada
            File file = archivo.getSelectedFile();
            //Lo imprimimos en una caja de texto para ver su ruta
            txtUrl.setText(String.valueOf(file));
            //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
            Image foto= getToolkit().getImage(txtUrl.getText());
            //Le damos dimension a nuestro label que tendra la imagen
            foto= foto.getScaledInstance(128, 128, Image.SCALE_DEFAULT);
            //Imprimimos la imagen en el label
            lblfoto.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_btnfotoActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        
        int fila = tablaEmpleados.getSelectedRow();
        
        if(fila>=0)
        {

            desbloquear();
            btnActualizar.setEnabled(true);
            txtUsuario.setEnabled(false);
            txtpContra.setEnabled(false);
            String cod = tablaEmpleados.getValueAt(fila, 0).toString();
            codEmpleado.setText(cod);
            ConexionMySQL mysql=new ConexionMySQL();       
            Connection cn=mysql.conectar();
            String asql="";
            asql="SELECT * FROM empleado "
                    +"WHERE CONCAT(cod_empleado) LIKE '%"+cod+"%'";
        
            try 
            {
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(asql);

                while(rs.next())
                {
                    txtNombre.setText(rs.getString("nombres"));
                    txtApellido.setText(rs.getString("apellidos"));
                    cbxGenero.setSelectedItem(rs.getString("genero"));
                    txtCelular.setText(rs.getString("celular"));
                    txtDni.setText(rs.getString("dni"));
                    cbxCivil.setSelectedItem(rs.getString("estado_civil"));                                                       
                    txtUrl.setText(rs.getString("direc_foto"));                    
                    
                    String dir = txtUrl.getText();
                    Image foto = getToolkit().getImage(dir);
                    foto= foto.getScaledInstance(128, 128, 1);
                    lblfoto.setIcon(new ImageIcon(foto));  
                    //Jack, esto ya estaba y no me funciona n.n no sé si cambiaste algo en otro lado
                        
                    
                    txtUsuario.setText(rs.getString("usuario"));
                    txtpContra.setText(rs.getString("contraseña"));
                    cbxArea.setSelectedItem(rs.getString("area"));
                    cbxEstado.setSelectedItem(rs.getString("estado"));
                    txtSueldo.setText(rs.getString("sueldo"));
                    txtBoni.setText(rs.getString("bonificacion"));
                    txtDes.setText(rs.getString("descuento"));
                    txtPagar.setText(rs.getString("neto_pagar"));
                }
            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null,ex);
            }
               
        }        
        else
        {
           JOptionPane.showMessageDialog(null, "Elija una fila");
        }
        
    }//GEN-LAST:event_modificarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
        buscarEmpleado("");
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try{
        ActualizarEmpleado();
        buscarEmpleado("");
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Complete todos los espacios");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSueldoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        desbloquear();
        limpiarTodo();
        btnActualizar.setEnabled(false);
        añadirButton.setEnabled(true);
        
        modCuenta.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void añadirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirButtonActionPerformed
        try{
        agregarEmpleado();
        buscarEmpleado("");
        bloquear();
        añadirButton.setEnabled(false);
        btnActualizar.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Complete todos los espacios");
        }
    }//GEN-LAST:event_añadirButtonActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void añadirButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirButtonMouseClicked
        
    }//GEN-LAST:event_añadirButtonMouseClicked

    private void btnlimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlimpiarMouseClicked
        
    }//GEN-LAST:event_btnlimpiarMouseClicked

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrlActionPerformed

    private void txtPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagarActionPerformed
        float total = Float.parseFloat(txtSueldo.getText()) + Float.parseFloat(txtBoni.getText()) + Float.parseFloat(txtDes.getText());
        txtPagar.setText(""+total+"");
    }//GEN-LAST:event_txtPagarActionPerformed

    private void cbxGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxGeneroItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxGeneroItemStateChanged

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSueldoKeyTyped

    private void txtSueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyReleased
        // TODO add your handling code here:
        try{
            int sueldo= Integer.parseInt(txtSueldo.getText());
            int bonificacion = Integer.parseInt(txtBoni.getText());
            int descuento = Integer.parseInt(txtDes.getText());
            
        int total = sueldo + bonificacion - descuento;
        txtPagar.setText(""+total+"");
        }catch(Exception e){
        }
    }//GEN-LAST:event_txtSueldoKeyReleased

    private void txtSueldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSueldoKeyPressed

    private void txtBoniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoniKeyReleased
        // TODO add your handling code here:
        try{
            int sueldo= Integer.parseInt(txtSueldo.getText());
            int bonificacion = Integer.parseInt(txtBoni.getText());
            int descuento = Integer.parseInt(txtDes.getText());
            
        int total = sueldo + bonificacion - descuento;
        txtPagar.setText(""+total+"");
        }catch(Exception e){
        }
    }//GEN-LAST:event_txtBoniKeyReleased

    private void txtDesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesKeyReleased
        // TODO add your handling code here:
        try{
            int sueldo= Integer.parseInt(txtSueldo.getText());
            int bonificacion = Integer.parseInt(txtBoni.getText());
            int descuento = Integer.parseInt(txtDes.getText());
            
        int total = sueldo + bonificacion - descuento;
        txtPagar.setText(""+total+"");
        }catch(Exception e){
        }
    }//GEN-LAST:event_txtDesKeyReleased

    private void eliminarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarButtonMouseClicked

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        int fila = tablaEmpleados.getSelectedRow();
         

        if(fila>=0)
        {
            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el registro del empleado?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(resp==0){
            
            String cod = tablaEmpleados.getValueAt(fila, 0).toString();
            
            ConexionMySQL mysql=new ConexionMySQL();       
            Connection cn=mysql.conectar();
            String instSql="DELETE FROM empleado "
                    +"WHERE CONCAT(cod_empleado) LIKE '%"+cod+"%'";
        
            try 
            {
                PreparedStatement pst = cn.prepareStatement(instSql);
                pst.execute();
                buscarEmpleado("");
                JOptionPane.showMessageDialog(null, "Elemento eliminado con éxito");


            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null,ex);
            }
            }

        }
        else
        {
    JOptionPane.showMessageDialog(null, "Elija un empleado de la tabla", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void modCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCuentaActionPerformed
        // TODO add your handling code here:
        txtUsuario.setEnabled(true);
        txtpContra.setEnabled(true);
    }//GEN-LAST:event_modCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirButton;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnexaminar;
    private javax.swing.JButton btnfoto;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JComboBox<String> cbxCivil;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JTextField codEmpleado;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lblcelular;
    private javax.swing.JLabel lbldni;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblgenero;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JToggleButton modCuenta;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBoni;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtDes;
    private javax.swing.JFormattedTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPagar;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JPasswordField txtpContra;
    // End of variables declaration//GEN-END:variables
}
