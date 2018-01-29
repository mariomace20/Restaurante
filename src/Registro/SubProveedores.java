/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import BaseDatos.ConexionMySQL;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class SubProveedores extends javax.swing.JPanel {
    /**
     * Creates new form SubProveedores
     */
    public SubProveedores() {
        initComponents();
        txtCodProve.setVisible(false);
        modificarButton.setVisible(false);
        tipoInsumoBox.setSelectedItem(null);
        newProvLabel.setVisible(false);
        buscarProveedor();
        
    }
    public void limpiar(){
        txtRSocial.setText("");
        txtRuc.setText("");
        txtTelefono.setText("");
        txtEmpresa.setText("");
        txtRepresentante.setText("");
        tipoInsumoBox.setSelectedItem(null);
        
    }
    public void bloquear(){
        txtRSocial.setEnabled(false);
        txtRuc.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmpresa.setEnabled(false);
        txtRepresentante.setEnabled(false);
        tipoInsumoBox.setEnabled(false);
        btnGuardar.setEnabled(false);
        modificarButton.setEnabled(false);
    }
    public void desbloquear(){
        txtRSocial.setEnabled(true);
        txtRuc.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmpresa.setEnabled(true);
        txtRepresentante.setEnabled(true);
        tipoInsumoBox.setEnabled(true);
        
        
    }
    public void buscarProveedor(){    
        String[] registro=new String[3];      
        String asql="";
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Empresa");
        modelo.addColumn("Representante");
        modelo.addColumn("Teléfono");
        tablaProveedores.setModel(modelo);
        
        ConexionMySQL mysql=new ConexionMySQL(); 
        Connection cn=mysql.conectar();
        
        asql="SELECT * FROM proveedor";
        
        try 
        {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);
            
            while(rs.next())
            {
                registro[0]=rs.getString("empresa");
                registro[1]=rs.getString("representante");
                registro[2]=rs.getString("telefono");
                
                modelo.addRow(registro);
            }
            tablaProveedores.setModel(modelo);
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    public void agregarProveedor(){
        ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn=mysql.conectar();
        
        String rs,ruc,tel,emp,re,id;
        
        rs = txtRSocial.getText();
        ruc = txtRuc.getText();
        tel = txtTelefono.getText();
        emp = txtEmpresa.getText();
        re = txtRepresentante.getText();
        id = tipoInsumoBox.getSelectedItem().toString();
        
        String asql="";
        String mensaje="";
        
        asql = "INSERT INTO proveedor(razon_social,ruc,telefono,empresa,representante,insumos)"+
                "VALUES(? ,? ,? ,? ,? ,? )";
        
        mensaje="Los datos se han guardado de manera satisfactoria";
        try 
        {
            PreparedStatement pst = cn.prepareStatement(asql);
            pst.setString(1, rs);
            pst.setString(2, ruc);
            pst.setString(3, tel);
            pst.setString(4, emp);
            pst.setString(5, re);
            pst.setString(6, id);
            
            int n=pst.executeUpdate();
            
            if(n>0)
            {            
                JOptionPane.showMessageDialog(null,mensaje,"Registrar",JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        buscarProveedor();
    }
    
    public void actualizar(){
        try {
            ConexionMySQL  mysql=new ConexionMySQL();
            Connection cn=mysql.conectar();

            String rs,ruc,tel,emp,re,id,cod;
            
            cod = txtCodProve.getText();
            rs = txtRSocial.getText();
            ruc = txtRuc.getText();
            tel = txtTelefono.getText();
            emp = txtEmpresa.getText();
            re = txtRepresentante.getText();
            id = tipoInsumoBox.getSelectedItem().toString();

            String asql="";
            String mensaje="";
            
            mensaje="Los datos han sido modificados de manera satisfactoria";
            String sql="UPDATE proveedor SET "
                 + "razon_social = '"+rs+"',"
                 + "ruc = '"+ruc+"',"
                 + "telefono = '"+tel+"',"
                 + "empresa = '"+emp+"',"
                 + "representante = '"+re+"',"
                 + "insumos = '"+id+"'"
                 + " WHERE cod_proveedor = '"+cod+"'"; 
            
            PreparedStatement pst = cn.prepareStatement(sql);
            int n= pst.executeUpdate();
            if(n>0)
            {            
                JOptionPane.showMessageDialog(null,mensaje,"Actualizar",JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
       /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        mnDetalle = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        PanelTry1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        newProvLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRSocial = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtRepresentante = new javax.swing.JTextField();
        tipoInsumoBox = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        txtCodProve = new javax.swing.JTextField();
        modificarButton = new javax.swing.JToggleButton();
        detallesLabel = new javax.swing.JLabel();
        jToggleButton5 = new javax.swing.JToggleButton();
        eliminarButton = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();

        mnDetalle.setText("Ver Detalle");
        mnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDetalleActionPerformed(evt);
            }
        });
        jPopupMenu2.add(mnDetalle);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 520));
        setMinimumSize(new java.awt.Dimension(790, 520));
        setPreferredSize(new java.awt.Dimension(790, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 610, 10));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Transporte.jpg"))); // NOI18N
        jLabel3.setText("LISTA DE PROVEEDORES");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        PanelTry1.setBackground(new java.awt.Color(255, 255, 255));
        PanelTry1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Empresa: ");
        PanelTry1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tipo insumo:");
        PanelTry1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        newProvLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newProvLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoProveedorLabelImg.png"))); // NOI18N
        newProvLabel.setText("Nuevo Proveedor");
        PanelTry1.add(newProvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Representante: ");
        PanelTry1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Razon Social:");
        PanelTry1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Telefono:");
        PanelTry1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("RUC:");
        PanelTry1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtRSocial.setEnabled(false);
        PanelTry1.add(txtRSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 150, -1));

        txtRuc.setEnabled(false);
        PanelTry1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 150, -1));

        txtTelefono.setEnabled(false);
        PanelTry1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, -1));

        txtEmpresa.setEnabled(false);
        PanelTry1.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));

        txtRepresentante.setEnabled(false);
        PanelTry1.add(txtRepresentante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, -1));

        tipoInsumoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abarrotes", "Carnes", "Frutas y/o Vegetales", "Bebidas", "Otros" }));
        tipoInsumoBox.setEnabled(false);
        tipoInsumoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoInsumoBoxActionPerformed(evt);
            }
        });
        PanelTry1.add(tipoInsumoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 150, -1));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setEnabled(false);
        btnGuardar.setPreferredSize(new java.awt.Dimension(65, 23));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PanelTry1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 110, -1));
        PanelTry1.add(txtCodProve, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, -1));

        modificarButton.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        modificarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ModificarBtn1.png"))); // NOI18N
        modificarButton.setText("Modificar");
        modificarButton.setBorder(null);
        modificarButton.setContentAreaFilled(false);
        modificarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificarButton.setFocusPainted(false);
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });
        PanelTry1.add(modificarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 100, 30));

        detallesLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        detallesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Apuntes.jpg"))); // NOI18N
        detallesLabel.setText("Detalles");
        PanelTry1.add(detallesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, 30));

        add(PanelTry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 360, 280));

        jToggleButton5.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadirbtn1.png"))); // NOI18N
        jToggleButton5.setText("Añadir");
        jToggleButton5.setBorder(null);
        jToggleButton5.setContentAreaFilled(false);
        jToggleButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton5.setFocusPainted(false);
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 90, 30));

        eliminarButton.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarBtn1.png"))); // NOI18N
        eliminarButton.setText("Eliminar");
        eliminarButton.setBorder(null);
        eliminarButton.setContentAreaFilled(false);
        eliminarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarButton.setFocusPainted(false);
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });
        add(eliminarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 100, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 10, 270));

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Empresa", "Representante", "Teléfono"
            }
        ));
        tablaProveedores.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(tablaProveedores);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 610, 120));
    }// </editor-fold>//GEN-END:initComponents

    private void mnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDetalleActionPerformed
        int fila = tablaProveedores.getSelectedRow();
        
        if(fila>=0)
        {

            desbloquear();
            modificarButton.setEnabled(true);
            String r = tablaProveedores.getValueAt(fila, 0).toString();
            ConexionMySQL mysql=new ConexionMySQL();       
            Connection cn=mysql.conectar();
            String asql="";
            asql="SELECT * FROM proveedor "
                    +"WHERE CONCAT(empresa) LIKE '%"+r+"%'";
        
            try 
            {
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(asql);

                while(rs.next())
                {
                    txtCodProve.setText(rs.getString("cod_proveedor"));
                    txtRSocial.setText(rs.getString("razon_social"));
                    txtRuc.setText(rs.getString("ruc"));
                    txtTelefono.setText(rs.getString("telefono"));
                    txtEmpresa.setText(rs.getString("empresa"));
                    txtRepresentante.setText(rs.getString("representante"));
                    tipoInsumoBox.setSelectedItem(rs.getString("insumos"));
                }
                modificarButton.setVisible(true);
                btnGuardar.setVisible(false);
                detallesLabel.setVisible(true);
                newProvLabel.setVisible(false);
            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null,ex);
            }

        }
        else
        {
           JOptionPane.showMessageDialog(null, "Elija una fila de la tabla");
        }
    }//GEN-LAST:event_mnDetalleActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
        agregarProveedor();
        limpiar();
        bloquear();
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Complete todos los espacios");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        limpiar();
        desbloquear();
        btnGuardar.setEnabled(true);
        btnGuardar.setVisible(true);
        modificarButton.setVisible(false);
        detallesLabel.setVisible(false);
        newProvLabel.setVisible(true);
        
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        actualizar();
        bloquear();
    }//GEN-LAST:event_modificarButtonActionPerformed

    private void tipoInsumoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoInsumoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoInsumoBoxActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
         int fila = tablaProveedores.getSelectedRow();
         

        if(fila>=0)
        {
            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el registro del proveedor?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(resp==0){
            
            String empresa = tablaProveedores.getValueAt(fila, 0).toString();
            
            ConexionMySQL mysql=new ConexionMySQL();       
            Connection cn=mysql.conectar();
            String instSql="DELETE FROM proveedor "
                    +"WHERE CONCAT(empresa) LIKE '%"+empresa+"%'";
        
            try 
            {
                PreparedStatement pst = cn.prepareStatement(instSql);
                pst.execute();
                buscarProveedor();
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
    JOptionPane.showMessageDialog(null, "Elija un proveedor de la tabla", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTry1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel detallesLabel;
    private javax.swing.JToggleButton eliminarButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JMenuItem mnDetalle;
    private javax.swing.JToggleButton modificarButton;
    private javax.swing.JLabel newProvLabel;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JComboBox<String> tipoInsumoBox;
    private javax.swing.JTextField txtCodProve;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtRSocial;
    private javax.swing.JTextField txtRepresentante;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
