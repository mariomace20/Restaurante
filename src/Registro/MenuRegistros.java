
package Registro;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

public class MenuRegistros extends javax.swing.JPanel {

    public MenuRegistros() {
        initComponents();
    }
    
    public void setBotonColor(JButton jbtn){
        jbtn.setBackground(new Color(89, 170, 51));
    }
    
    public void resetBotonColor(JButton jbtn){
        jbtn.setBackground(new Color(33,169,155));
    }                                     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRegistros = new javax.swing.JPanel();
        btnEmpleado = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 570));
        setMinimumSize(new java.awt.Dimension(790, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(790, 570));
        jPanel1.setMinimumSize(new java.awt.Dimension(790, 570));
        jPanel1.setPreferredSize(new java.awt.Dimension(790, 570));

        panelRegistros.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistros.setMaximumSize(new java.awt.Dimension(790, 520));
        panelRegistros.setMinimumSize(new java.awt.Dimension(790, 520));

        javax.swing.GroupLayout panelRegistrosLayout = new javax.swing.GroupLayout(panelRegistros);
        panelRegistros.setLayout(panelRegistrosLayout);
        panelRegistrosLayout.setHorizontalGroup(
            panelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        panelRegistrosLayout.setVerticalGroup(
            panelRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        btnEmpleado.setBackground(new java.awt.Color(33, 169, 155));
        btnEmpleado.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/persona-de-negocios-silueta-con-corbata.png"))); // NOI18N
        btnEmpleado.setText("Empleados");
        btnEmpleado.setBorder(null);
        btnEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleado.setFocusPainted(false);
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });

        btnInventario.setBackground(new java.awt.Color(33, 169, 155));
        btnInventario.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fabrica-casa-con-inventario.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setFocusPainted(false);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(33, 169, 155));
        btnProveedores.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dar-la-mano.png"))); // NOI18N
        btnProveedores.setText("Provedores");
        btnProveedores.setBorder(null);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setFocusPainted(false);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(panelRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        setBotonColor(btnEmpleado);
        resetBotonColor(btnInventario);
        resetBotonColor(btnProveedores);
        
        SubEmpleados p1 = new SubEmpleados();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelRegistros.removeAll();
        panelRegistros.add(p1,BorderLayout.CENTER);
        panelRegistros.revalidate(); 
        panelRegistros.repaint();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        setBotonColor(btnProveedores);
        resetBotonColor(btnInventario);
        resetBotonColor(btnEmpleado);
        
        SubProveedores p1 = new SubProveedores();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelRegistros.removeAll();
        panelRegistros.add(p1,BorderLayout.CENTER);
        panelRegistros.revalidate(); 
        panelRegistros.repaint();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        setBotonColor(btnInventario);
        resetBotonColor(btnProveedores);
        resetBotonColor(btnEmpleado);
        
        SubInventario p1 = new SubInventario();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelRegistros.removeAll();
        panelRegistros.add(p1,BorderLayout.CENTER);
        panelRegistros.revalidate(); 
        panelRegistros.repaint();
    }//GEN-LAST:event_btnInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelRegistros;
    // End of variables declaration//GEN-END:variables
}
