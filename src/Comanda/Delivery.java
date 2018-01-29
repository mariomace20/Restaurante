
package Comanda;

import BaseDatos.ConexionMySQL;
import Registro.SubEmpleados;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Delivery extends javax.swing.JPanel {

    DefaultTableModel tablaDelivery;
    ArrayList<Float> total = new ArrayList();
    ArrayList<String> listaDetalle = new ArrayList();
    
    public Delivery() {
        initComponents();
        
        tablaDelivery = new DefaultTableModel();
        tablaDelivery.addColumn("Categoria");
        tablaDelivery.addColumn("Cantidad");
        tablaDelivery.addColumn("Detalle");
        tablaDelivery.addColumn("SubTotal");
        this.tblDelivery.setModel(tablaDelivery);
    }
    
    public void agregarDelivery(){
        ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn=mysql.conectar();
        
        String nom,dir,det,ct,t;

        nom = txtNombre.getText();
        dir = txtDireccion.getText();
        det = txtDetallePedido.getText();
        ct = lbCantidad.getText();
        t = duplicarTotal.getText();
        
        String asql="";
        String mensaje="";
        
        asql = "INSERT INTO delivery(nom_cliente,direccion,detalle,cantidad,total)"+
                "VALUES(? ,? ,? ,? ,? )";
        
        mensaje="Los Datos se han guardado de manera Satisfactoria...";
        try{
            PreparedStatement pst = cn.prepareStatement(asql);
            pst.setString(1, nom);
            pst.setString(2, dir);
            pst.setString(3, det);
            pst.setString(4, ct);
            pst.setString(5, t);
            
            int n=pst.executeUpdate();           
            if(n>0){            
                JOptionPane.showMessageDialog(null,mensaje,"Guardando",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        borrarFila = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDetallePedido = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDelivery = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        precioItem1 = new javax.swing.JLabel();
        precioTotal = new javax.swing.JLabel();
        precioItem9 = new javax.swing.JLabel();
        precioItem10 = new javax.swing.JLabel();
        addCombo1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        precioItem11 = new javax.swing.JLabel();
        addCombo2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        precioItem5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        precioItem6 = new javax.swing.JLabel();
        precioItem12 = new javax.swing.JLabel();
        addCombo3 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        realizarDelivery = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        lbCantidad = new javax.swing.JLabel();
        precioItem13 = new javax.swing.JLabel();
        duplicarTotal = new javax.swing.JLabel();
        confirmarDelivery = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 520));
        setMinimumSize(new java.awt.Dimension(790, 520));
        setPreferredSize(new java.awt.Dimension(790, 520));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel1.setText("Detalle del pedido");
        add(jLabel1);
        jLabel1.setBounds(490, 20, 140, 40);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel16.setText("Cargo total:");
        add(jLabel16);
        jLabel16.setBounds(470, 420, 80, 30);

        borrarFila.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        borrarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar_3.png"))); // NOI18N
        borrarFila.setText("Eliminar Seleccion");
        borrarFila.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrarFila.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                borrarFilaMousePressed(evt);
            }
        });
        add(borrarFila);
        borrarFila.setBounds(620, 230, 150, 40);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("Detalle del pedido:");
        add(jLabel12);
        jLabel12.setBounds(470, 360, 110, 30);
        add(jSeparator18);
        jSeparator18.setBounds(590, 320, 140, 10);

        txtNombre.setBorder(null);
        add(txtNombre);
        txtNombre.setBounds(590, 300, 140, 20);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel13.setText("Nombre");
        add(jLabel13);
        jLabel13.setBounds(470, 300, 70, 30);

        txtDetallePedido.setBorder(null);
        txtDetallePedido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDetallePedido.setEnabled(false);
        add(txtDetallePedido);
        txtDetallePedido.setBounds(590, 360, 140, 20);
        add(jSeparator19);
        jSeparator19.setBounds(590, 380, 140, 10);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel14.setText("Cantidad:");
        add(jLabel14);
        jLabel14.setBounds(470, 390, 70, 30);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tblDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Combo", "Cantidad", "Detalle", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDelivery.setGridColor(new java.awt.Color(255, 255, 255));
        tblDelivery.setSelectionBackground(new java.awt.Color(113, 194, 133));
        jScrollPane7.setViewportView(tblDelivery);

        add(jScrollPane7);
        jScrollPane7.setBounds(470, 60, 300, 140);

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel22.setText("Super Combo Familiar");
        add(jLabel22);
        jLabel22.setBounds(30, 290, 140, 30);

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setText("Importe");
        add(jLabel24);
        jLabel24.setBounds(630, 190, 60, 40);

        precioItem1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem1.setText("27.50");
        add(precioItem1);
        precioItem1.setBounds(390, 220, 40, 30);

        precioTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioTotal.setText("0.00");
        add(precioTotal);
        precioTotal.setBounds(730, 190, 40, 40);

        precioItem9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem9.setText("S/.");
        add(precioItem9);
        precioItem9.setBounds(370, 90, 30, 30);

        precioItem10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem10.setText("S/.");
        add(precioItem10);
        precioItem10.setBounds(690, 190, 30, 40);

        addCombo1.setBackground(new java.awt.Color(113, 194, 133));
        addCombo1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        addCombo1.setForeground(new java.awt.Color(255, 255, 255));
        addCombo1.setText("Agregar");
        addCombo1.setFocusable(false);
        addCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCombo1ActionPerformed(evt);
            }
        });
        add(addCombo1);
        addCombo1.setBounds(300, 120, 100, 30);

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setText("Precio");
        add(jLabel23);
        jLabel23.setBounds(380, 70, 80, 20);

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("Ceviche de pescado");
        add(jLabel25);
        jLabel25.setBounds(210, 90, 150, 30);

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel28.setText("Combo para dos");
        add(jLabel28);
        jLabel28.setBounds(30, 150, 110, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cmaspedidos.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(50, 70, 140, 80);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cparados.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(50, 180, 130, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cfamiliar1.png"))); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(40, 320, 130, 80);

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel30.setText("Los mas pedidos");
        add(jLabel30);
        jLabel30.setBounds(30, 40, 110, 30);

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel36.setText("Combo #1");
        add(jLabel36);
        jLabel36.setBounds(200, 50, 150, 30);

        precioItem11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem11.setText("S/.");
        add(precioItem11);
        precioItem11.setBounds(360, 220, 30, 30);

        addCombo2.setBackground(new java.awt.Color(113, 194, 133));
        addCombo2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        addCombo2.setForeground(new java.awt.Color(255, 255, 255));
        addCombo2.setText("Agregar");
        addCombo2.setFocusable(false);
        addCombo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCombo2ActionPerformed(evt);
            }
        });
        add(addCombo2);
        addCombo2.setBounds(300, 260, 100, 30);

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel26.setText("Precio");
        add(jLabel26);
        jLabel26.setBounds(370, 200, 80, 20);

        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel37.setText("Combo #2");
        add(jLabel37);
        jLabel37.setBounds(200, 160, 180, 30);

        precioItem5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem5.setText("15.00");
        add(precioItem5);
        precioItem5.setBounds(400, 90, 50, 30);

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setText("2 Lomo saltado");
        add(jLabel29);
        jLabel29.setBounds(210, 190, 150, 30);

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setText("2 Papa a la Huacaina");
        add(jLabel31);
        jLabel31.setBounds(210, 210, 150, 30);

        precioItem6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem6.setText("45.50");
        add(precioItem6);
        precioItem6.setBounds(140, 430, 50, 30);

        precioItem12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem12.setText("S/.");
        add(precioItem12);
        precioItem12.setBounds(110, 430, 30, 30);

        addCombo3.setBackground(new java.awt.Color(113, 194, 133));
        addCombo3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        addCombo3.setForeground(new java.awt.Color(255, 255, 255));
        addCombo3.setText("Agregar");
        addCombo3.setFocusable(false);
        addCombo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCombo3ActionPerformed(evt);
            }
        });
        add(addCombo3);
        addCombo3.setBounds(300, 450, 100, 30);

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel32.setText("Precio");
        add(jLabel32);
        jLabel32.setBounds(120, 410, 80, 20);

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setText("-Arroz Chaufa");
        add(jLabel33);
        jLabel33.setBounds(230, 410, 110, 20);

        jLabel39.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel39.setText("Combo #3");
        add(jLabel39);
        jLabel39.setBounds(200, 300, 180, 30);

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 153, 153));
        jLabel34.setText("1 Piqueo + 3 Platos de fondo");
        add(jLabel34);
        jLabel34.setBounds(210, 330, 190, 30);

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("-Lomo Saltado");
        add(jLabel35);
        jLabel35.setBounds(230, 370, 100, 20);

        jLabel40.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setText("-Spagetthi verde con Bisteck");
        add(jLabel40);
        jLabel40.setBounds(230, 390, 190, 20);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel6.setText("DELIVERY");
        add(jLabel6);
        jLabel6.setBounds(20, 0, 140, 40);

        realizarDelivery.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        realizarDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/confirmar.png"))); // NOI18N
        realizarDelivery.setText("Realizar delivery");
        realizarDelivery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        realizarDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                realizarDeliveryMousePressed(evt);
            }
        });
        add(realizarDelivery);
        realizarDelivery.setBounds(540, 460, 160, 30);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel15.setText("Direccion:");
        add(jLabel15);
        jLabel15.setBounds(470, 330, 70, 30);

        txtDireccion.setBorder(null);
        add(txtDireccion);
        txtDireccion.setBounds(590, 330, 140, 20);
        add(jSeparator21);
        jSeparator21.setBounds(590, 350, 140, 10);

        lbCantidad.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbCantidad.setText("0");
        add(lbCantidad);
        lbCantidad.setBounds(590, 390, 40, 30);

        precioItem13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem13.setText("S/.");
        add(precioItem13);
        precioItem13.setBounds(580, 420, 30, 40);

        duplicarTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        duplicarTotal.setText("0.00");
        add(duplicarTotal);
        duplicarTotal.setBounds(620, 420, 40, 40);

        confirmarDelivery.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        confirmarDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/confirmar.png"))); // NOI18N
        confirmarDelivery.setText("Confirmar");
        confirmarDelivery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmarDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmarDeliveryMousePressed(evt);
            }
        });
        add(confirmarDelivery);
        confirmarDelivery.setBounds(490, 230, 90, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void addCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCombo1ActionPerformed
        String Datos[] = new String[4];
        
        Datos[0] = "Combo 1";
        Datos[1] = "1";
        Datos[2] = "Personal: Ceviche de pescado";
        Datos[3] = "15.00";
        
        listaDetalle.add(Datos[2]);
        
        float precio = Float.parseFloat(Datos[3]);
        total.add(precio);
        float suma=0;
        for (int i = 0; i < total.size(); i++) {
            suma = suma + total.get(i);
        }
        precioTotal.setText(String.valueOf(suma));
        
        tablaDelivery.addRow(Datos);
        
    }//GEN-LAST:event_addCombo1ActionPerformed

    private void addCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCombo2ActionPerformed
        String Datos[] = new String[4];
        
        Datos[0] = "Combo 2";
        Datos[1] = "1";
        Datos[2] = "Para dos: 2 Lomos 2 Papa Huancaina";
        Datos[3] = "27.50";
        
        listaDetalle.add(Datos[2]);
        
        float precio = Float.parseFloat(Datos[3]);
        total.add(precio);
        float suma=0;
        for (int i = 0; i < total.size(); i++) {
            suma = suma + total.get(i);
        }
        precioTotal.setText(String.valueOf(suma));
        
        tablaDelivery.addRow(Datos);
    }//GEN-LAST:event_addCombo2ActionPerformed

    private void addCombo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCombo3ActionPerformed
        String Datos[] = new String[4];
        
        Datos[0] = "Combo 3";
        Datos[1] = "1";
        Datos[2] = "Familiar: 1 Piqueo 3 Platos de Fondo";
        Datos[3] = "45.50";
        
        listaDetalle.add(Datos[2]);
        
        float precio = Float.parseFloat(Datos[3]);
        total.add(precio);
        float suma=0;
        for (int i = 0; i < total.size(); i++) {
            suma = suma + total.get(i);
        }
        precioTotal.setText(String.valueOf(suma));
        
        tablaDelivery.addRow(Datos);
    }//GEN-LAST:event_addCombo3ActionPerformed

    private void borrarFilaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarFilaMousePressed
        int filaseleccionada = tblDelivery.getSelectedRow();
        
        if(filaseleccionada>=0){
            try{
                tablaDelivery.removeRow(filaseleccionada);
            }catch(Exception e){
                System.out.println("Problemas al borrar seleccion");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
        }
        
    }//GEN-LAST:event_borrarFilaMousePressed

    private void confirmarDeliveryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarDeliveryMousePressed
        int filas = tblDelivery.getRowCount();
        lbCantidad.setText(String.valueOf(filas));
        String detalle = "";
        for (int i = 0; i < listaDetalle.size(); i++) {
            detalle = detalle + listaDetalle.get(i)+" + ";
        }
        txtDetallePedido.setText(detalle);
        duplicarTotal.setText(precioTotal.getText());
    }//GEN-LAST:event_confirmarDeliveryMousePressed

    private void realizarDeliveryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarDeliveryMousePressed
        agregarDelivery();
    }//GEN-LAST:event_realizarDeliveryMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCombo1;
    private javax.swing.JButton addCombo2;
    private javax.swing.JButton addCombo3;
    private javax.swing.JLabel borrarFila;
    private javax.swing.JLabel confirmarDelivery;
    private javax.swing.JLabel duplicarTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel precioItem1;
    private javax.swing.JLabel precioItem10;
    private javax.swing.JLabel precioItem11;
    private javax.swing.JLabel precioItem12;
    private javax.swing.JLabel precioItem13;
    private javax.swing.JLabel precioItem5;
    private javax.swing.JLabel precioItem6;
    private javax.swing.JLabel precioItem9;
    private javax.swing.JLabel precioTotal;
    private javax.swing.JLabel realizarDelivery;
    private javax.swing.JTable tblDelivery;
    private javax.swing.JTextField txtDetallePedido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
