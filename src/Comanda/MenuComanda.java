
package Comanda;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

public class MenuComanda extends javax.swing.JPanel {

    public MenuComanda() {
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
        btnNuevoPedido = new javax.swing.JButton();
        btnDelivery = new javax.swing.JButton();
        btnOrdenesCaja = new javax.swing.JButton();
        panelPedidos = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(790, 570));
        setMinimumSize(new java.awt.Dimension(790, 570));
        setPreferredSize(new java.awt.Dimension(790, 570));
        setLayout(null);

        panelTituloPedido.setBackground(new java.awt.Color(255, 255, 255));
        panelTituloPedido.setMinimumSize(new java.awt.Dimension(690, 50));
        panelTituloPedido.setPreferredSize(new java.awt.Dimension(690, 50));

        btnNuevoPedido.setBackground(new java.awt.Color(33, 169, 155));
        btnNuevoPedido.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnNuevoPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido nuevo.png"))); // NOI18N
        btnNuevoPedido.setText("Nuevo Pedido");
        btnNuevoPedido.setBorder(null);
        btnNuevoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoPedido.setFocusPainted(false);
        btnNuevoPedido.setMaximumSize(new java.awt.Dimension(64, 16));
        btnNuevoPedido.setMinimumSize(new java.awt.Dimension(64, 16));
        btnNuevoPedido.setPreferredSize(new java.awt.Dimension(64, 16));
        btnNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoActionPerformed(evt);
            }
        });

        btnDelivery.setBackground(new java.awt.Color(33, 169, 155));
        btnDelivery.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnDelivery.setForeground(new java.awt.Color(255, 255, 255));
        btnDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delivery2.png"))); // NOI18N
        btnDelivery.setText("Delivery");
        btnDelivery.setBorder(null);
        btnDelivery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelivery.setFocusPainted(false);
        btnDelivery.setMaximumSize(new java.awt.Dimension(64, 16));
        btnDelivery.setMinimumSize(new java.awt.Dimension(64, 16));
        btnDelivery.setPreferredSize(new java.awt.Dimension(64, 16));
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        btnOrdenesCaja.setBackground(new java.awt.Color(33, 169, 155));
        btnOrdenesCaja.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnOrdenesCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenesCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido ver.png"))); // NOI18N
        btnOrdenesCaja.setText("Ordenes/Caja");
        btnOrdenesCaja.setBorder(null);
        btnOrdenesCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenesCaja.setFocusPainted(false);
        btnOrdenesCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenesCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTituloPedidoLayout = new javax.swing.GroupLayout(panelTituloPedido);
        panelTituloPedido.setLayout(panelTituloPedidoLayout);
        panelTituloPedidoLayout.setHorizontalGroup(
            panelTituloPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenesCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelTituloPedidoLayout.setVerticalGroup(
            panelTituloPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTituloPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenesCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(panelTituloPedido);
        panelTituloPedido.setBounds(0, 0, 790, 50);

        panelPedidos.setBackground(new java.awt.Color(255, 255, 255));
        panelPedidos.setMaximumSize(new java.awt.Dimension(710, 500));
        panelPedidos.setMinimumSize(new java.awt.Dimension(710, 500));
        panelPedidos.setPreferredSize(new java.awt.Dimension(710, 500));

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

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
        setBotonColor(btnNuevoPedido);
        resetBotonColor(btnOrdenesCaja);
        resetBotonColor(btnDelivery);
        
        PedidoNuevo p1 = new PedidoNuevo();
        p1.setSize(790, 520);
        p1.setLocation(0, 0);
        panelPedidos.removeAll();
        panelPedidos.add(p1,BorderLayout.CENTER);
        panelPedidos.revalidate(); 
        panelPedidos.repaint();
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed

    private void btnOrdenesCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesCajaActionPerformed
        setBotonColor(btnOrdenesCaja);
        resetBotonColor(btnNuevoPedido);
        resetBotonColor(btnDelivery);
        
        OrdenesCaja p1 = new OrdenesCaja();
        p1.setSize(790, 520);
        p1.setLocation(5, 5);
        panelPedidos.removeAll();
        panelPedidos.add(p1,BorderLayout.CENTER);
        panelPedidos.revalidate(); 
        panelPedidos.repaint();
    }//GEN-LAST:event_btnOrdenesCajaActionPerformed

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        // TODO add your handling code here:
        setBotonColor(btnDelivery);
        resetBotonColor(btnOrdenesCaja);
        resetBotonColor(btnNuevoPedido);
        
        Delivery p1 = new Delivery();
        p1.setSize(790, 520);
        p1.setLocation(0, 0);
        panelPedidos.removeAll();
        panelPedidos.add(p1,BorderLayout.CENTER);
        panelPedidos.revalidate(); 
        panelPedidos.repaint();
    }//GEN-LAST:event_btnDeliveryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnNuevoPedido;
    private javax.swing.JButton btnOrdenesCaja;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JPanel panelTituloPedido;
    // End of variables declaration//GEN-END:variables
}
