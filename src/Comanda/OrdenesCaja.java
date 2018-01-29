
package Comanda;

import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrdenesCaja extends javax.swing.JPanel {

    public OrdenesCaja() {
        initComponents();
        pedidoMesa();
        pedidoDelivery();
        listaTotal();
        generarTotal();
    }
    
    public void generarTotal(){
        int fila = tablaGeneral.getRowCount();
        float suma = 0;
        for(int i = 0; i<fila;i++){
            //OBTENER VALORES DE LA TABLA
            String st=tablaGeneral.getValueAt(i, 2).toString();
            float subtotal = Float.parseFloat(st);
            suma = suma +subtotal;
        }
        lblTotal.setText(""+suma+"");
    }
    public void pedidoMesa(){    
        String[] registro=new String[4];      
        String asql="";
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("N° Pedido");
        modelo.addColumn("N° Mesa");
        modelo.addColumn("Detalle de Pedido");
        modelo.addColumn("Total");
        tablaPedido.setModel(modelo);
        
        ConexionMySQL mysql=new ConexionMySQL(); 
        Connection cn=mysql.conectar();
        
        asql="SELECT * FROM pedido";
        
        try 
        {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);
            
            while(rs.next())
            {
                registro[0]=rs.getString("cod_pedido");
                registro[1]=rs.getString("num_mesa");
                registro[2]=rs.getString("detalle");
                registro[3]=rs.getString("total");
                
                modelo.addRow(registro);
            }
            tablaPedido.setModel(modelo);
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    public void pedidoDelivery(){    
        String[] registro=new String[4];      
        String asql="";
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("N° Pedido");
        modelo.addColumn("Direccion");
        modelo.addColumn("Detalle de Pedido");
        modelo.addColumn("Total");
        tablaDelivery.setModel(modelo);
        
        ConexionMySQL mysql=new ConexionMySQL(); 
        Connection cn=mysql.conectar();
        
        asql="SELECT * FROM delivery";
        
        try 
        {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);
            
            while(rs.next())
            {
                registro[0]=rs.getString("num_delivery");
                registro[1]=rs.getString("direccion");
                registro[2]=rs.getString("detalle");
                registro[3]=rs.getString("total");
                
                modelo.addRow(registro);
            }
            tablaDelivery.setModel(modelo);
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void listaTotal(){
        String[] registro=new String[3];
        String[] registro2=new String[3];
        String asql="",bsql="";
        
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("N° Pedido");
        modelo.addColumn("Cliente");
        modelo.addColumn("Monto");
        tablaGeneral.setModel(modelo);
        
        ConexionMySQL mysql=new ConexionMySQL(); 
        Connection cn=mysql.conectar();
        
        asql="SELECT * FROM pedido";
        bsql="SELECT * FROM delivery";
        try{   
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);
            
            while(rs.next())
            {
                registro[0]=rs.getString("cod_pedido");
                registro[1]=rs.getString("cliente");
                registro[2]=rs.getString("total");               
                modelo.addRow(registro);
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        try{   
            Statement st=cn.createStatement();
            ResultSet rs2=st.executeQuery(bsql);
            
            while(rs2.next())
            {
                registro2[0]=rs2.getString("num_delivery");
                registro2[1]=rs2.getString("nom_cliente");
                registro2[2]=rs2.getString("total");                
                modelo.addRow(registro2);
                
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        tablaGeneral.setModel(modelo);
    }
    
    public void editarPedido(){       
        int fila = tablaPedido.getSelectedRow();
        if(fila>=0)
        {
            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el registro del pedido?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(resp==0){
                try{
                    String cod = tablaPedido.getValueAt(fila, 0).toString();
                    String dir = tablaPedido.getValueAt(fila, 1).toString();
                    String det = tablaPedido.getValueAt(fila, 2).toString();
                    String tot = tablaPedido.getValueAt(fila, 3).toString();
                    
                    ConexionMySQL mysql=new ConexionMySQL();       
                    Connection cn=mysql.conectar();
                    String instSql="UPDATE pedido SET "
                        + "num_mesa = ?,"
                        + "detalle = ?,"
                        + "total = ?"
                        + " WHERE cod_pedido = '"+cod+"'";
                    
                    PreparedStatement pst = cn.prepareStatement(instSql);
                    pst.setString(1, dir);
                    pst.setString(2, det);
                    pst.setString(3, tot);
                    int n= pst.executeUpdate();
                    String mensaje="Los datos han sido modificados de manera satisfactoria";
                    if(n>0){            
                        JOptionPane.showMessageDialog(null,mensaje,"Actualizar",JOptionPane.INFORMATION_MESSAGE);
                    }
                    pedidoDelivery();
                    listaTotal();
                    generarTotal();
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }
      /*  int fila2 = tablaDelivery.getSelectedRow();
        if(fila2>0){
            int resp2 = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el registro del delivery?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(resp2==0){
                                
                try{
                    String num = tablaDelivery.getValueAt(fila2, 0).toString();
                    String dire = tablaDelivery.getValueAt(fila2, 1).toString();
                    String deta = tablaDelivery.getValueAt(fila2, 2).toString();
                    String tota = tablaDelivery.getValueAt(fila2, 3).toString();
                    
                    ConexionMySQL mysql=new ConexionMySQL();       
                    Connection cn2=mysql.conectar();
                    String instSql="UPDATE delivery SET "
                        + "direccion = ?,"
                        + "detalle = ?,"
                        + "total = ?"
                        + " WHERE num_delivery = '"+num+"'";
                    
                    PreparedStatement pst = cn2.prepareStatement(instSql);
                    pst.setString(1, dire);
                    pst.setString(2, deta);
                    pst.setString(3, tota);
                    int n= pst.executeUpdate();
                    String mensaje="Los datos han sido modificados de manera satisfactoria";
                    if(n>0){            
                        JOptionPane.showMessageDialog(null,mensaje,"Actualizar",JOptionPane.INFORMATION_MESSAGE);
                    }
                    pedidoDelivery();
                    listaTotal();
                    generarTotal();
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }*/
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGeneral = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDelivery = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnProveedores1 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jTextField3 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 520));
        setMinimumSize(new java.awt.Dimension(790, 520));
        setPreferredSize(new java.awt.Dimension(790, 520));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("LISTA DE ORDENES");
        add(jLabel1);
        jLabel1.setBounds(130, 20, 150, 21);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comprobante.png"))); // NOI18N
        jLabel4.setText("Realizar comprobante");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jLabel4);
        jLabel4.setBounds(570, 430, 160, 40);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir-punto-de-anclaje.png"))); // NOI18N
        jLabel5.setText("Modificar orden");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        add(jLabel5);
        jLabel5.setBounds(80, 440, 160, 40);

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pedido", "N° Mesa", "Estado", "Hora realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPedido);
        if (tablaPedido.getColumnModel().getColumnCount() > 0) {
            tablaPedido.getColumnModel().getColumn(1).setHeaderValue("N° Mesa");
            tablaPedido.getColumnModel().getColumn(2).setHeaderValue("Estado");
            tablaPedido.getColumnModel().getColumn(3).setHeaderValue("Hora realizada");
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 80, 390, 150);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        jLabel6.setText("Eliminar Orden");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        add(jLabel6);
        jLabel6.setBounds(250, 440, 120, 40);

        tablaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pedido", "Cliente", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaGeneral);

        add(jScrollPane3);
        jScrollPane3.setBounds(450, 90, 320, 290);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel9.setText("Deliverys");
        add(jLabel9);
        jLabel9.setBounds(20, 240, 120, 19);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel8.setText("CAJA");
        add(jLabel8);
        jLabel8.setBounds(580, 20, 50, 20);

        tablaDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pedido", "N° Mesa", "Estado", "Hora realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaDelivery);
        if (tablaDelivery.getColumnModel().getColumnCount() > 0) {
            tablaDelivery.getColumnModel().getColumn(1).setHeaderValue("N° Mesa");
            tablaDelivery.getColumnModel().getColumn(2).setHeaderValue("Estado");
            tablaDelivery.getColumnModel().getColumn(3).setHeaderValue("Hora realizada");
        }

        add(jScrollPane4);
        jScrollPane4.setBounds(30, 270, 390, 150);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel10.setText("S/.");
        add(jLabel10);
        jLabel10.setBounds(680, 390, 40, 19);

        btnProveedores1.setBackground(new java.awt.Color(245, 156, 26));
        btnProveedores1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnProveedores1.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores1.setText("Consultar");
        btnProveedores1.setBorder(null);
        btnProveedores1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores1.setFocusPainted(false);
        btnProveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedores1ActionPerformed(evt);
            }
        });
        add(btnProveedores1);
        btnProveedores1.setBounds(690, 50, 80, 30);

        jTextField11.setForeground(new java.awt.Color(204, 204, 204));
        jTextField11.setText("Antes 04/12/17");
        jTextField11.setBorder(null);
        add(jTextField11);
        jTextField11.setBounds(590, 60, 80, 20);
        add(jSeparator18);
        jSeparator18.setBounds(590, 80, 80, 10);

        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setText("Desde 03/12/17");
        jTextField3.setBorder(null);
        add(jTextField3);
        jTextField3.setBounds(470, 60, 80, 20);
        add(jSeparator7);
        jSeparator7.setBounds(470, 80, 80, 10);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario.png"))); // NOI18N
        add(jLabel21);
        jLabel21.setBounds(570, 50, 30, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario.png"))); // NOI18N
        add(jLabel11);
        jLabel11.setBounds(450, 50, 30, 40);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel12.setText("Pedidos en Mesa");
        add(jLabel12);
        jLabel12.setBounds(20, 50, 120, 19);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel13.setText("TOTAL DEL DIA:");
        add(jLabel13);
        jLabel13.setBounds(470, 390, 120, 19);

        lblTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lblTotal.setText("0.00");
        add(lblTotal);
        lblTotal.setBounds(730, 390, 40, 19);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedores1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedores1ActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        int fila = tablaPedido.getSelectedRow();
        int fila2 = tablaDelivery.getSelectedRow();
        if(fila>=0)
        {
            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el registro del pedido?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(resp==0){
                String cod = tablaPedido.getValueAt(fila, 0).toString();

                ConexionMySQL mysql=new ConexionMySQL();       
                Connection cn=mysql.conectar();
                String instSql="DELETE FROM pedido "
                        +"WHERE CONCAT(cod_pedido) LIKE '%"+cod+"%'";

                try{
                    PreparedStatement pst = cn.prepareStatement(instSql);
                    pst.execute();
                    pedidoMesa();
                    listaTotal();
                    generarTotal();
                    JOptionPane.showMessageDialog(null, "Elemento eliminado con éxito");
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }
        
        if(fila2>0){
            int resp2 = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere borrar el registro del delivery?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
            if(resp2==0){
                String num = tablaDelivery.getValueAt(fila2, 0).toString();

                ConexionMySQL mysql=new ConexionMySQL();       
                Connection cn=mysql.conectar();
                String instSql="DELETE FROM delivery "
                        +"WHERE CONCAT(num_delivery) LIKE '%"+num+"%'";

                try{
                    PreparedStatement pst = cn.prepareStatement(instSql);
                    pst.execute();
                    pedidoDelivery();
                    listaTotal();
                    generarTotal();
                    JOptionPane.showMessageDialog(null, "Elemento eliminado con éxito");
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        }    
        
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        editarPedido();
    }//GEN-LAST:event_jLabel5MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProveedores1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaDelivery;
    private javax.swing.JTable tablaGeneral;
    private javax.swing.JTable tablaPedido;
    // End of variables declaration//GEN-END:variables
}
