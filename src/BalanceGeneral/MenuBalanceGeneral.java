
package BalanceGeneral;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;


public class MenuBalanceGeneral extends javax.swing.JPanel {

    public MenuBalanceGeneral() {
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

        panelTituloPedido = new javax.swing.JPanel();
        btnIngresos = new javax.swing.JButton();
        btnEgresos = new javax.swing.JButton();
        btnSaldos = new javax.swing.JButton();
        panelPedidos = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(790, 570));
        setMinimumSize(new java.awt.Dimension(790, 570));
        setPreferredSize(new java.awt.Dimension(790, 570));
        setLayout(null);

        panelTituloPedido.setBackground(new java.awt.Color(255, 255, 255));
        panelTituloPedido.setMinimumSize(new java.awt.Dimension(690, 50));
        panelTituloPedido.setPreferredSize(new java.awt.Dimension(690, 50));

        btnIngresos.setBackground(new java.awt.Color(33, 169, 155));
        btnIngresos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnIngresos.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido nuevo.png"))); // NOI18N
        btnIngresos.setText(" Ingresos");
        btnIngresos.setBorder(null);
        btnIngresos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresos.setFocusPainted(false);
        btnIngresos.setMaximumSize(new java.awt.Dimension(64, 16));
        btnIngresos.setMinimumSize(new java.awt.Dimension(64, 16));
        btnIngresos.setPreferredSize(new java.awt.Dimension(64, 16));
        btnIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosActionPerformed(evt);
            }
        });

        btnEgresos.setBackground(new java.awt.Color(33, 169, 155));
        btnEgresos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnEgresos.setForeground(new java.awt.Color(255, 255, 255));
        btnEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido ver.png"))); // NOI18N
        btnEgresos.setText(" Egresos");
        btnEgresos.setBorder(null);
        btnEgresos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEgresos.setFocusPainted(false);
        btnEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresosActionPerformed(evt);
            }
        });

        btnSaldos.setBackground(new java.awt.Color(33, 169, 155));
        btnSaldos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnSaldos.setForeground(new java.awt.Color(255, 255, 255));
        btnSaldos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido ver.png"))); // NOI18N
        btnSaldos.setText(" Saldos / Utilidades");
        btnSaldos.setBorder(null);
        btnSaldos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaldos.setFocusPainted(false);
        btnSaldos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTituloPedidoLayout = new javax.swing.GroupLayout(panelTituloPedido);
        panelTituloPedido.setLayout(panelTituloPedidoLayout);
        panelTituloPedidoLayout.setHorizontalGroup(
            panelTituloPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEgresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTituloPedidoLayout.setVerticalGroup(
            panelTituloPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTituloPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panelTituloPedido);
        panelTituloPedido.setBounds(0, 0, 790, 50);

        panelPedidos.setBackground(new java.awt.Color(255, 255, 255));
        panelPedidos.setMaximumSize(new java.awt.Dimension(690, 410));
        panelPedidos.setMinimumSize(new java.awt.Dimension(690, 410));
        panelPedidos.setPreferredSize(new java.awt.Dimension(690, 410));

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        add(panelPedidos);
        panelPedidos.setBounds(0, 50, 790, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosActionPerformed
        setBotonColor(btnIngresos);
        resetBotonColor(btnEgresos);
        resetBotonColor(btnSaldos);
        
        SubIngresos p1 = new SubIngresos();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelPedidos.removeAll();
        panelPedidos.add(p1,BorderLayout.CENTER);
        panelPedidos.revalidate(); 
        panelPedidos.repaint();
    }//GEN-LAST:event_btnIngresosActionPerformed

    private void btnEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresosActionPerformed
        setBotonColor(btnEgresos);
        resetBotonColor(btnIngresos);
        resetBotonColor(btnSaldos);
        
        SubEgresos p1 = new SubEgresos();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelPedidos.removeAll();
        panelPedidos.add(p1,BorderLayout.CENTER);
        panelPedidos.revalidate(); 
        panelPedidos.repaint();
    }//GEN-LAST:event_btnEgresosActionPerformed

    private void btnSaldosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldosActionPerformed
        setBotonColor(btnSaldos);
        resetBotonColor(btnIngresos);
        resetBotonColor(btnEgresos);
        
        SubSaldos p1 = new SubSaldos();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelPedidos.removeAll();
        panelPedidos.add(p1,BorderLayout.CENTER);
        panelPedidos.revalidate(); 
        panelPedidos.repaint();
    }//GEN-LAST:event_btnSaldosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEgresos;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnSaldos;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JPanel panelTituloPedido;
    // End of variables declaration//GEN-END:variables
}
