
package Comanda;

import BaseDatos.ConexionMySQL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;

public class PedidoNuevo extends javax.swing.JPanel {
    
    DefaultTableModel modelo;
    DefaultTableModel pedidos;
    DefaultListModel listaItems = new DefaultListModel();
    ArrayList<Float> total = new ArrayList();
    ArrayList<String> listaDetalle = new ArrayList();
    String codigoEmpleado;
    String codigoPedido;
    ConexionMySQL cn = new ConexionMySQL();

    public PedidoNuevo() {
        initComponents();
        cbxEmpleado.setSelectedItem(null);
        spinner1.setVisible(false);
        spinner2.setVisible(false);
        spinner3.setVisible(false);
        spinner4.setVisible(false);
        precioItem1.setVisible(false);
        precioItem2.setVisible(false);
        precioItem3.setVisible(false);
        precioItem4.setVisible(false);
        
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Categoria");
        modelo.addColumn("Detalle");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio c/u");
        modelo.addColumn("SubTotal");
        this.tablaOrden.setModel(modelo);
        
        
        pedidos = new DefaultTableModel();
        pedidos.addColumn("Cliente");
        pedidos.addColumn("Mesa");
        pedidos.addColumn("Atendido por");
        pedidos.addColumn("Detalle");
        pedidos.addColumn("Total");
        this.tablaPedidos.setModel(pedidos);
    }
    public void generarReporte(){
        try{
            JasperReport masterReport = null;
            String rutaInforme = "src\\Reportes\\report1.jasper";
            Map parametro = new HashMap();
            parametro.put("cod", codigoPedido);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme,parametro, cn.conectar());
            JasperViewer ventanaVisor = new JasperViewer(informe,false);
            ventanaVisor.setTitle("BOLETA DE VENTA");
            ventanaVisor.setVisible(true);
        }catch(JRException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void codigoEmpleado(){
        String ep=cbxEmpleado.getSelectedItem().toString(); 
        String asql = "";
        
        ConexionMySQL mysql=new ConexionMySQL();       
        Connection cn=mysql.conectar();
        
        asql="SELECT * FROM empleado "
                +"WHERE CONCAT(nombres) LIKE '%"+ep+"%'";
        
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);          
            while(rs.next()){
                codigoEmpleado = rs.getString("cod_empleado");
            }
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }      

    public void guardarPedido(){     
        //ENVIAR A LA BASE DE DATOS
        ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn=mysql.conectar();
        //SELECCIONAMOS LA FILA QUE VAMOS A OBETENER
        int fila = tablaPedidos.getRowCount();
               
        String asql="";
        String mensaje="";
        
        asql = "INSERT INTO pedido(cod_pedido,cliente,num_mesa,cod_empleado,detalle,total)"+
                "VALUES(? ,? ,? ,? ,? ,?)";
        
        mensaje="Los Datos se han guardado de manera Satisfactoria...";
        try{
            PreparedStatement pst = cn.prepareStatement(asql);
            for(int i = 0; i<fila;i++){
                //OBTENER VALORES DE LA TABLA
                String cli=tablaPedidos.getValueAt(i, 0).toString();
                String mes=tablaPedidos.getValueAt(i, 1).toString();
                String emp=tablaPedidos.getValueAt(i, 2).toString();
                String det=tablaPedidos.getValueAt(i, 3).toString();   
                String total=tablaPedidos.getValueAt(i, 4).toString();  
                pst.setString(1, codigoPedido);
                pst.setString(2, cli);
                pst.setString(3, mes);
                pst.setString(4, emp);
                pst.setString(5, det);
                pst.setString(6, total);
                int n=pst.executeUpdate();
                if(n>0){            
                JOptionPane.showMessageDialog(null,mensaje,"Guardando",JOptionPane.INFORMATION_MESSAGE);
                }
            }           
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        /*
        txtMesa.setText("");
        txtCliente.setText("");
        txtCodP.setText("");
        cbxEmpleado.setSelectedItem(null);*/
        this.tablaPedidos.removeAll();
        
    }
    public void guardarDetallePedido(){
        //ENVIAR A LA BASE DE DATOS
        ConexionMySQL  mysql=new ConexionMySQL();
        Connection cn=mysql.conectar();

        //SELECCIONAMOS LA FILA QUE VAMOS A OBETENER
        int fila = tablaOrden.getRowCount();
               
        String asql="";
        String mensaje="";
        
        asql = "INSERT INTO detalle_orden(cod_pedido,categoria_plato,platillo,cantidad,precio_uno,sub_total)"+
                "VALUES(? ,? ,? ,? ,? ,? )";
        
        mensaje="Los Datos se han guardado de manera Satisfactoria...";
        try{
            PreparedStatement pst = cn.prepareStatement(asql);
            for(int i = 0; i<fila;i++){
                //OBTENER VALORES DE LA TABLA
                String cat=tablaOrden.getValueAt(i, 0).toString();
                String pla=tablaOrden.getValueAt(i, 1).toString();
                String cant=tablaOrden.getValueAt(i, 2).toString();
                String pu=tablaOrden.getValueAt(i, 3).toString();   
                String st=tablaOrden.getValueAt(i, 4).toString();  
                pst.setString(1, codigoPedido);
                pst.setString(2, cat);
                pst.setString(3, pla);
                pst.setString(4, cant);
                pst.setString(5, pu);
                pst.setString(6, st);
                int n=pst.executeUpdate();
            }                              
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPedido = new javax.swing.JDialog();
        Panel = new javax.swing.JPanel();
        lbMesa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaOrden = new javax.swing.JTable();
        enviarTabla = new javax.swing.JButton();
        lbCliente = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbMesero = new javax.swing.JLabel();
        btnPostres = new javax.swing.JButton();
        btnEntradas = new javax.swing.JButton();
        btnSegundos = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        panelItems = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOpcionMenu = new javax.swing.JList<>();
        categoria = new javax.swing.JLabel();
        spinner4 = new javax.swing.JSpinner();
        spinner1 = new javax.swing.JSpinner();
        spinner2 = new javax.swing.JSpinner();
        spinner3 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        precioItem1 = new javax.swing.JLabel();
        precioItem2 = new javax.swing.JLabel();
        precioItem3 = new javax.swing.JLabel();
        precioItem4 = new javax.swing.JLabel();
        plataxD = new javax.swing.JLabel();
        precioTotal = new javax.swing.JLabel();
        precioItem7 = new javax.swing.JLabel();
        precioItem8 = new javax.swing.JLabel();
        precioItem9 = new javax.swing.JLabel();
        precioItem10 = new javax.swing.JLabel();
        enviarPedido = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        eliminarFila = new javax.swing.JLabel();
        Entradas = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Segundos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Bebidas = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Postres = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        btnFactura = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        txtMesa = new javax.swing.JTextField();
        cbxEmpleado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        mesa7 = new javax.swing.JButton();
        mesa1 = new javax.swing.JButton();
        mesa2 = new javax.swing.JButton();
        mesa3 = new javax.swing.JButton();
        mesa4 = new javax.swing.JButton();
        mesa5 = new javax.swing.JButton();
        mesa8 = new javax.swing.JButton();
        mesa6 = new javax.swing.JButton();
        btnVerMenus = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        btnAceptarOrden = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCodP = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        JDPedido.setMinimumSize(new java.awt.Dimension(830, 472));
        JDPedido.setUndecorated(true);

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setMaximumSize(new java.awt.Dimension(830, 472));
        Panel.setMinimumSize(new java.awt.Dimension(830, 472));
        Panel.setPreferredSize(new java.awt.Dimension(830, 472));
        Panel.setLayout(null);

        lbMesa.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbMesa.setText("#1");
        Panel.add(lbMesa);
        lbMesa.setBounds(460, 10, 50, 30);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tablaOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Detalle", "Cantidad", "Precio c/u", "Sub Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOrden.setGridColor(new java.awt.Color(255, 255, 255));
        tablaOrden.setSelectionBackground(new java.awt.Color(113, 194, 133));
        jScrollPane3.setViewportView(tablaOrden);
        if (tablaOrden.getColumnModel().getColumnCount() > 0) {
            tablaOrden.getColumnModel().getColumn(0).setHeaderValue("#Pedido");
        }

        Panel.add(jScrollPane3);
        jScrollPane3.setBounds(290, 250, 470, 140);

        enviarTabla.setBackground(new java.awt.Color(113, 194, 133));
        enviarTabla.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        enviarTabla.setForeground(new java.awt.Color(255, 255, 255));
        enviarTabla.setText("Anotar a la Lista");
        enviarTabla.setFocusable(false);
        enviarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarTablaActionPerformed(evt);
            }
        });
        Panel.add(enviarTabla);
        enviarTabla.setBounds(360, 200, 130, 30);

        lbCliente.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbCliente.setText("Nombre");
        Panel.add(lbCliente);
        lbCliente.setBounds(270, 10, 70, 30);

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel22.setText("Precio");
        Panel.add(jLabel22);
        jLabel22.setBounds(510, 50, 80, 30);

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setText("Importe");
        Panel.add(jLabel24);
        jLabel24.setBounds(610, 390, 60, 40);

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/multiplicar.png"))); // NOI18N
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        Panel.add(cerrar);
        cerrar.setBounds(800, 0, 50, 40);

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel25.setText("MESA");
        Panel.add(jLabel25);
        jLabel25.setBounds(410, 10, 50, 30);

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel28.setText("Mesero");
        Panel.add(jLabel28);
        jLabel28.setBounds(580, 10, 50, 30);

        lbMesero.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbMesero.setText("#1");
        Panel.add(lbMesero);
        lbMesero.setBounds(650, 10, 50, 30);

        btnPostres.setBackground(new java.awt.Color(113, 194, 133));
        btnPostres.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnPostres.setForeground(new java.awt.Color(255, 255, 255));
        btnPostres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/helado.png"))); // NOI18N
        btnPostres.setText("Postres");
        btnPostres.setToolTipText("");
        btnPostres.setBorder(null);
        btnPostres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPostres.setFocusPainted(false);
        btnPostres.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPostres.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostresActionPerformed(evt);
            }
        });
        Panel.add(btnPostres);
        btnPostres.setBounds(20, 340, 110, 80);

        btnEntradas.setBackground(new java.awt.Color(113, 194, 133));
        btnEntradas.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnEntradas.setForeground(new java.awt.Color(255, 255, 255));
        btnEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fideos-en-un-bol.png"))); // NOI18N
        btnEntradas.setText("Entradas");
        btnEntradas.setToolTipText("");
        btnEntradas.setBorder(null);
        btnEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradas.setFocusPainted(false);
        btnEntradas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntradas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });
        Panel.add(btnEntradas);
        btnEntradas.setBounds(20, 70, 110, 80);

        btnSegundos.setBackground(new java.awt.Color(113, 194, 133));
        btnSegundos.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnSegundos.setForeground(new java.awt.Color(255, 255, 255));
        btnSegundos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/comida.png"))); // NOI18N
        btnSegundos.setText("Platos/Segundo");
        btnSegundos.setToolTipText("");
        btnSegundos.setBorder(null);
        btnSegundos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSegundos.setFocusPainted(false);
        btnSegundos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSegundos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSegundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSegundosActionPerformed(evt);
            }
        });
        Panel.add(btnSegundos);
        btnSegundos.setBounds(20, 160, 110, 80);

        btnBebidas.setBackground(new java.awt.Color(113, 194, 133));
        btnBebidas.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnBebidas.setForeground(new java.awt.Color(255, 255, 255));
        btnBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vaso-de-agua (1).png"))); // NOI18N
        btnBebidas.setText("Bebidas");
        btnBebidas.setToolTipText("");
        btnBebidas.setBorder(null);
        btnBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBebidas.setFocusPainted(false);
        btnBebidas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBebidas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });
        Panel.add(btnBebidas);
        btnBebidas.setBounds(20, 250, 110, 80);

        panelItems.setBackground(new java.awt.Color(255, 255, 255));
        panelItems.setMaximumSize(new java.awt.Dimension(130, 350));
        panelItems.setMinimumSize(new java.awt.Dimension(130, 350));
        panelItems.setPreferredSize(new java.awt.Dimension(130, 350));
        panelItems.setLayout(null);
        Panel.add(panelItems);
        panelItems.setBounds(150, 70, 130, 350);

        listOpcionMenu.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        listOpcionMenu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "        ::  SAZON FISI  ::" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listOpcionMenu.setToolTipText("");
        listOpcionMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listOpcionMenu.setFocusable(false);
        listOpcionMenu.setSelectionBackground(new java.awt.Color(113, 194, 133));
        listOpcionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listOpcionMenuMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listOpcionMenu);

        Panel.add(jScrollPane2);
        jScrollPane2.setBounds(300, 90, 170, 90);

        categoria.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        categoria.setText("Selecciona tu opcion...");
        Panel.add(categoria);
        categoria.setBounds(300, 50, 170, 30);
        Panel.add(spinner4);
        spinner4.setBounds(630, 150, 29, 20);
        Panel.add(spinner1);
        spinner1.setBounds(630, 90, 29, 20);
        Panel.add(spinner2);
        spinner2.setBounds(630, 110, 29, 20);
        Panel.add(spinner3);
        spinner3.setBounds(630, 130, 29, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sape.png"))); // NOI18N
        Panel.add(jLabel5);
        jLabel5.setBounds(710, 70, 70, 80);

        jLabel38.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel38.setText("Cantidad");
        Panel.add(jLabel38);
        jLabel38.setBounds(600, 50, 60, 30);

        precioItem1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem1.setText("0.00");
        Panel.add(precioItem1);
        precioItem1.setBounds(530, 90, 30, 30);

        precioItem2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem2.setText("0.00");
        Panel.add(precioItem2);
        precioItem2.setBounds(530, 110, 60, 30);

        precioItem3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem3.setText("0.00");
        Panel.add(precioItem3);
        precioItem3.setBounds(530, 130, 60, 30);

        precioItem4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem4.setText("0.00");
        Panel.add(precioItem4);
        precioItem4.setBounds(530, 150, 60, 30);

        plataxD.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        plataxD.setText("S/.");
        Panel.add(plataxD);
        plataxD.setBounds(490, 150, 30, 30);

        precioTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioTotal.setText("0.00");
        Panel.add(precioTotal);
        precioTotal.setBounds(710, 390, 40, 40);

        precioItem7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem7.setText("S/.");
        Panel.add(precioItem7);
        precioItem7.setBounds(490, 110, 30, 30);

        precioItem8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem8.setText("S/.");
        Panel.add(precioItem8);
        precioItem8.setBounds(490, 130, 30, 30);

        precioItem9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem9.setText("S/.");
        Panel.add(precioItem9);
        precioItem9.setBounds(490, 90, 30, 30);

        precioItem10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioItem10.setText("S/.");
        Panel.add(precioItem10);
        precioItem10.setBounds(670, 390, 30, 40);

        enviarPedido.setBackground(new java.awt.Color(113, 194, 133));
        enviarPedido.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        enviarPedido.setForeground(new java.awt.Color(255, 255, 255));
        enviarPedido.setText("CONFIRMAR COMANDA");
        enviarPedido.setFocusable(false);
        enviarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarPedidoActionPerformed(evt);
            }
        });
        Panel.add(enviarPedido);
        enviarPedido.setBounds(350, 410, 160, 30);

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setText("Captura de productos");
        Panel.add(jLabel23);
        jLabel23.setBounds(10, 10, 170, 30);

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel30.setText("CLIENTE");
        Panel.add(jLabel30);
        jLabel30.setBounds(190, 10, 70, 30);

        eliminarFila.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        eliminarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        eliminarFila.setText("Eliminar peticion");
        eliminarFila.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarFilaMousePressed(evt);
            }
        });
        Panel.add(eliminarFila);
        eliminarFila.setBounds(530, 200, 150, 40);

        JDPedido.getContentPane().add(Panel, java.awt.BorderLayout.CENTER);

        Entradas.setBackground(new java.awt.Color(255, 255, 255));
        Entradas.setMaximumSize(new java.awt.Dimension(130, 350));
        Entradas.setMinimumSize(new java.awt.Dimension(130, 350));
        Entradas.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ceviche mixto.png"))); // NOI18N
        jLabel8.setText("CEVICHE MIXTO");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Entradas.add(jLabel8);
        jLabel8.setBounds(20, 250, 100, 100);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caldo_gallina.png"))); // NOI18N
        jLabel9.setText("CALDO DE GALLINA");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Entradas.add(jLabel9);
        jLabel9.setBounds(10, -10, 130, 120);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ocopa.png"))); // NOI18N
        jLabel10.setText("OCOPA AREQUIPEÑA");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Entradas.add(jLabel10);
        jLabel10.setBounds(10, 70, 130, 120);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tequenos.png"))); // NOI18N
        jLabel11.setText("TEQUEÑOS");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Entradas.add(jLabel11);
        jLabel11.setBounds(30, 170, 80, 100);

        Segundos.setBackground(new java.awt.Color(255, 255, 255));
        Segundos.setMaximumSize(new java.awt.Dimension(130, 350));
        Segundos.setMinimumSize(new java.awt.Dimension(130, 350));
        Segundos.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tallarinverde.png"))); // NOI18N
        jLabel13.setText("TALLARINES VERDES");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Segundos.add(jLabel13);
        jLabel13.setBounds(10, 250, 130, 100);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/secocabrito.png"))); // NOI18N
        jLabel14.setText("SECO DE CABRITO");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Segundos.add(jLabel14);
        jLabel14.setBounds(20, 0, 110, 100);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ajigallina.png"))); // NOI18N
        jLabel15.setText("AJI DE GALLINA");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Segundos.add(jLabel15);
        jLabel15.setBounds(20, 90, 100, 100);

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrozconpollo.png"))); // NOI18N
        jLabel26.setText("ARROZ CON POLLO");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Segundos.add(jLabel26);
        jLabel26.setBounds(10, 170, 120, 100);

        Bebidas.setBackground(new java.awt.Color(255, 255, 255));
        Bebidas.setMaximumSize(new java.awt.Dimension(130, 350));
        Bebidas.setMinimumSize(new java.awt.Dimension(130, 350));
        Bebidas.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pilsen_1.png"))); // NOI18N
        jLabel27.setText("CERVEZA PILSEN");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Bebidas.add(jLabel27);
        jLabel27.setBounds(20, 120, 100, 100);

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cocacola.png"))); // NOI18N
        jLabel29.setText("COCA COLA");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Bebidas.add(jLabel29);
        jLabel29.setBounds(30, 20, 130, 84);

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/frugo_1.png"))); // NOI18N
        jLabel31.setText("FRUGOS");
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel31.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Bebidas.add(jLabel31);
        jLabel31.setBounds(40, 240, 80, 100);

        Postres.setBackground(new java.awt.Color(255, 255, 255));
        Postres.setMaximumSize(new java.awt.Dimension(130, 350));
        Postres.setMinimumSize(new java.awt.Dimension(130, 350));
        Postres.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flan.png"))); // NOI18N
        jLabel32.setText("FLAN");
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel32.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Postres.add(jLabel32);
        jLabel32.setBounds(30, 230, 100, 100);

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/helado_1.jpg"))); // NOI18N
        jLabel33.setText("HELADO");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Postres.add(jLabel33);
        jLabel33.setBounds(30, 10, 70, 90);

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tortahelada.png"))); // NOI18N
        jLabel34.setText("TORTA HELADA");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel34.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Postres.add(jLabel34);
        jLabel34.setBounds(20, 70, 130, 120);

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gelatinadecolores.png"))); // NOI18N
        jLabel35.setText("GELATINA");
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Postres.add(jLabel35);
        jLabel35.setBounds(30, 150, 80, 100);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 520));
        setMinimumSize(new java.awt.Dimension(790, 520));
        setPreferredSize(new java.awt.Dimension(790, 520));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(null);

        lbTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbTotal.setText("0.00");
        add(lbTotal);
        lbTotal.setBounds(680, 390, 50, 30);

        btnFactura.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnFactura.setText("FACTURA/BOLETA");
        btnFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFacturaMouseClicked(evt);
            }
        });
        add(btnFactura);
        btnFactura.setBounds(460, 430, 160, 30);
        add(jSeparator15);
        jSeparator15.setBounds(560, 270, 0, 2);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Atiende:");
        add(jLabel7);
        jLabel7.setBounds(390, 160, 50, 20);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("N° ");
        add(jLabel12);
        jLabel12.setBounds(580, 20, 20, 30);
        add(jSeparator18);
        jSeparator18.setBounds(600, 40, 70, 10);

        txtMesa.setBorder(null);
        txtMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesaActionPerformed(evt);
            }
        });
        add(txtMesa);
        txtMesa.setBounds(470, 70, 40, 20);

        String asql="";
        String nom="";

        ConexionMySQL mysql=new ConexionMySQL();
        Connection cn=mysql.conectar();

        asql="SELECT * FROM empleado";

        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(asql);

            while(rs.next()){
                nom = rs.getString("nombres");
                cbxEmpleado.addItem(nom);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        cbxEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEmpleadoItemStateChanged(evt);
            }
        });
        cbxEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxEmpleadoMouseClicked(evt);
            }
        });
        cbxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpleadoActionPerformed(evt);
            }
        });
        add(cbxEmpleado);
        cbxEmpleado.setBounds(470, 160, 180, 20);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setText("DETALLE DEL PEDIDO");
        add(jLabel2);
        jLabel2.setBounds(390, 20, 180, 30);

        mesa7.setBackground(new java.awt.Color(113, 194, 133));
        mesa7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa7.setForeground(new java.awt.Color(255, 255, 255));
        mesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa7.setText("MESA 7");
        mesa7.setToolTipText("");
        mesa7.setBorder(null);
        mesa7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa7.setFocusPainted(false);
        mesa7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa7ActionPerformed(evt);
            }
        });
        add(mesa7);
        mesa7.setBounds(20, 320, 90, 80);

        mesa1.setBackground(new java.awt.Color(113, 194, 133));
        mesa1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa1.setForeground(new java.awt.Color(255, 255, 255));
        mesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa1.setText("MESA 1");
        mesa1.setToolTipText("");
        mesa1.setBorder(null);
        mesa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa1.setFocusPainted(false);
        mesa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa1ActionPerformed(evt);
            }
        });
        add(mesa1);
        mesa1.setBounds(20, 50, 90, 80);

        mesa2.setBackground(new java.awt.Color(113, 194, 133));
        mesa2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa2.setForeground(new java.awt.Color(255, 255, 255));
        mesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa2.setText("MESA 2");
        mesa2.setToolTipText("");
        mesa2.setBorder(null);
        mesa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa2.setFocusPainted(false);
        mesa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa2ActionPerformed(evt);
            }
        });
        add(mesa2);
        mesa2.setBounds(120, 50, 90, 80);

        mesa3.setBackground(new java.awt.Color(113, 194, 133));
        mesa3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa3.setForeground(new java.awt.Color(255, 255, 255));
        mesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa3.setText("MESA 3");
        mesa3.setToolTipText("");
        mesa3.setBorder(null);
        mesa3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa3.setFocusPainted(false);
        mesa3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa3ActionPerformed(evt);
            }
        });
        add(mesa3);
        mesa3.setBounds(20, 140, 90, 80);

        mesa4.setBackground(new java.awt.Color(113, 194, 133));
        mesa4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa4.setForeground(new java.awt.Color(255, 255, 255));
        mesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa4.setText("MESA 4");
        mesa4.setToolTipText("");
        mesa4.setBorder(null);
        mesa4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa4.setFocusPainted(false);
        mesa4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa4ActionPerformed(evt);
            }
        });
        add(mesa4);
        mesa4.setBounds(120, 140, 90, 80);

        mesa5.setBackground(new java.awt.Color(113, 194, 133));
        mesa5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa5.setForeground(new java.awt.Color(255, 255, 255));
        mesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa5.setText("MESA 5");
        mesa5.setToolTipText("");
        mesa5.setBorder(null);
        mesa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa5.setFocusPainted(false);
        mesa5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa5ActionPerformed(evt);
            }
        });
        add(mesa5);
        mesa5.setBounds(20, 230, 90, 80);

        mesa8.setBackground(new java.awt.Color(113, 194, 133));
        mesa8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa8.setForeground(new java.awt.Color(255, 255, 255));
        mesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa8.setText("MESA 8");
        mesa8.setToolTipText("");
        mesa8.setBorder(null);
        mesa8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa8.setFocusPainted(false);
        mesa8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa8ActionPerformed(evt);
            }
        });
        add(mesa8);
        mesa8.setBounds(120, 320, 90, 80);

        mesa6.setBackground(new java.awt.Color(113, 194, 133));
        mesa6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        mesa6.setForeground(new java.awt.Color(255, 255, 255));
        mesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cubiertos.png"))); // NOI18N
        mesa6.setText("MESA 6");
        mesa6.setToolTipText("");
        mesa6.setBorder(null);
        mesa6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mesa6.setFocusPainted(false);
        mesa6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mesa6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa6ActionPerformed(evt);
            }
        });
        add(mesa6);
        mesa6.setBounds(120, 230, 90, 80);

        btnVerMenus.setBackground(new java.awt.Color(113, 194, 133));
        btnVerMenus.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnVerMenus.setForeground(new java.awt.Color(255, 255, 255));
        btnVerMenus.setText("VER COMIDAS");
        btnVerMenus.setFocusable(false);
        btnVerMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMenusActionPerformed(evt);
            }
        });
        add(btnVerMenus);
        btnVerMenus.setBounds(420, 210, 160, 30);

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel36.setText("Cliente:");
        add(jLabel36);
        jLabel36.setBounds(390, 110, 70, 30);

        txtCliente.setBorder(null);
        add(txtCliente);
        txtCliente.setBounds(470, 110, 90, 20);
        add(jSeparator19);
        jSeparator19.setBounds(470, 130, 90, 10);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sape.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(290, 70, 70, 80);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Mesa", "Atendido por", "Detalle", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPedidos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaPedidos.setSelectionBackground(new java.awt.Color(113, 194, 133));
        jScrollPane4.setViewportView(tablaPedidos);

        add(jScrollPane4);
        jScrollPane4.setBounds(260, 250, 480, 130);

        btnAceptarOrden.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        btnAceptarOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/confirmar.png"))); // NOI18N
        btnAceptarOrden.setText("Realizar Orden");
        btnAceptarOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarOrdenMouseClicked(evt);
            }
        });
        add(btnAceptarOrden);
        btnAceptarOrden.setBounds(290, 430, 160, 30);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("MESAS");
        add(jLabel3);
        jLabel3.setBounds(90, 10, 60, 30);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuadrado rojo.png"))); // NOI18N
        jLabel17.setText("Ocupada");
        add(jLabel17);
        jLabel17.setBounds(70, 450, 70, 30);

        txtCodP.setBorder(null);
        txtCodP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPActionPerformed(evt);
            }
        });
        add(txtCodP);
        txtCodP.setBounds(600, 20, 70, 20);
        add(jSeparator20);
        jSeparator20.setBounds(470, 90, 40, 10);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel16.setText("N° de mesa:");
        add(jLabel16);
        jLabel16.setBounds(390, 70, 70, 30);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel18.setText("TOTAL   S/.");
        add(jLabel18);
        jLabel18.setBounds(590, 390, 70, 30);

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuadrado verde.png"))); // NOI18N
        jLabel19.setText("Disponible");
        add(jLabel19);
        jLabel19.setBounds(70, 420, 90, 30);
    }// </editor-fold>//GEN-END:initComponents
    
    private void enviarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarTablaActionPerformed
            
        //ENVIO DE ELEMENTOS A LA TABLA
        String datoCategoria = categoria.getText(); //primer elemento de la tabla
        int cantidad1 = (int) spinner1.getValue();
        int cantidad2 = (int) spinner2.getValue();
        int cantidad3 = (int) spinner3.getValue();
        int cantidad4 = (int) spinner4.getValue();
        String detalle = listOpcionMenu.getSelectedValue();//segundo elemento de la tabla
        listaDetalle.add(detalle);
        int cantidad=0; // tecer elemento de la tabla
        float precio=0; //cuarto elemento de la tabla
        float subtotal=0; //quinto elemento d ela tabla
        
        
        String Datos[] = new String[5]; //Dode se guardar una fila de la tabla
        
        if(cantidad1!=0){
            float precio1 = Float.parseFloat(precioItem1.getText());
            subtotal=precio1*cantidad1;
            precio = precio1;
            cantidad = cantidad1;
        }
        if(cantidad2!=0){
            float precio2 = Float.parseFloat(precioItem2.getText());
            subtotal=precio2*cantidad1;
            precio = precio2;
            cantidad = cantidad2;
        }
        if(cantidad3!=0){
            float precio3 = Float.parseFloat(precioItem3.getText());
            subtotal=precio3*cantidad1;
            precio = precio3;
            cantidad = cantidad3;
            
        }
        if(cantidad4!=0){
            float precio4 = Float.parseFloat(precioItem4.getText());
            subtotal=precio4*cantidad1;
            precio = precio4;
            cantidad = cantidad4;
            
        }
        
        subtotal = precio*cantidad;
        Datos[0] = datoCategoria;
        Datos[1] = detalle;
        Datos[2] = Integer.toString(cantidad);
        Datos[3] = Float.toString(precio);
        Datos[4] = Float.toString(subtotal);
        
        modelo.addRow(Datos);
        
        //Calculando monto total y actualizarlo
        total.add(subtotal);
        float suma=0;
        for (int i = 0; i < total.size(); i++) {
            suma = suma + total.get(i);
        }
        precioTotal.setText(Float.toString(suma));
        lbTotal.setText(Float.toString(suma));
        
        
    }//GEN-LAST:event_enviarTablaActionPerformed

    private void mesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa7ActionPerformed
        mesa7.setBackground(new Color(218, 31, 38));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa2.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        txtMesa.setText("7");
    }//GEN-LAST:event_mesa7ActionPerformed

    private void mesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa1ActionPerformed
        mesa1.setBackground(new Color(218, 31, 38));
        mesa7.setBackground(new Color(113, 194, 133));
        mesa2.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        txtMesa.setText("1");
    }//GEN-LAST:event_mesa1ActionPerformed

    private void mesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa2ActionPerformed
        mesa7.setBackground(new Color(113, 194, 133));
        mesa2.setBackground(new Color(218, 31, 38));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        txtMesa.setText("2");
    }//GEN-LAST:event_mesa2ActionPerformed

    private void mesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa3ActionPerformed
        mesa7.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(218, 31, 38));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa2.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        txtMesa.setText("3");
    }//GEN-LAST:event_mesa3ActionPerformed

    private void mesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa4ActionPerformed
        mesa7.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(218, 31, 38));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa2.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        txtMesa.setText("4");
    }//GEN-LAST:event_mesa4ActionPerformed

    private void mesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa5ActionPerformed
        mesa2.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(218, 31, 38));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa7.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        txtMesa.setText("5");
    }//GEN-LAST:event_mesa5ActionPerformed

    private void mesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa8ActionPerformed
        mesa7.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(218, 31, 38));
        mesa2.setBackground(new Color(113, 194, 133));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(113, 194, 133));
        txtMesa.setText("8");
    }//GEN-LAST:event_mesa8ActionPerformed

    private void mesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa6ActionPerformed
        mesa7.setBackground(new Color(113, 194, 133));
        mesa6.setBackground(new Color(218, 31, 38));
        mesa2.setBackground(new Color(113, 194, 133));
        mesa1.setBackground(new Color(113, 194, 133));
        mesa3.setBackground(new Color(113, 194, 133));
        mesa4.setBackground(new Color(113, 194, 133));
        mesa5.setBackground(new Color(113, 194, 133));
        mesa8.setBackground(new Color(113, 194, 133));
        txtMesa.setText("6");
    }//GEN-LAST:event_mesa6ActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        JDPedido.dispose();
    }//GEN-LAST:event_cerrarMouseClicked

    private void btnPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostresActionPerformed
        Postres.setSize(130, 350);
        Postres.setLocation(0, 0);
        panelItems.removeAll();
        panelItems.add(Postres, BorderLayout.CENTER);
        panelItems.revalidate(); 
        panelItems.repaint();
        spinner1.setVisible(false);
        spinner2.setVisible(false);
        spinner3.setVisible(false);
        spinner4.setVisible(false);
        precioItem1.setVisible(true);
        precioItem2.setVisible(true);
        precioItem3.setVisible(true);
        precioItem4.setVisible(true);
        plataxD.setVisible(true);
        
        categoria.setText("POSTRES");
        precioItem1.setText("1.00");
        precioItem2.setText("1.50");
        precioItem3.setText("1.00");
        precioItem4.setText("1.00");
        
        String Datos[] = new String[4];
        Datos[0]="Helado";
        Datos[1]="Torta Helada";
        Datos[2]="Gelatina";
        Datos[3]="Flan";
        listaItems.clear();
        for(int i = 0; i<4; i++){
            listaItems.addElement(Datos[i]);
        }
        listOpcionMenu.setModel(listaItems);
        
    }//GEN-LAST:event_btnPostresActionPerformed

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        
        Entradas.setSize(130, 350);
        Entradas.setLocation(0, 0);
        panelItems.removeAll();
        panelItems.add(Entradas, BorderLayout.CENTER);
        panelItems.revalidate(); 
        panelItems.repaint();
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
        spinner4.setValue(0);
        spinner1.setVisible(false);
        spinner2.setVisible(false);
        spinner3.setVisible(false);
        spinner4.setVisible(false);
        precioItem1.setVisible(true);
        precioItem2.setVisible(true);
        precioItem3.setVisible(true);
        precioItem4.setVisible(true);
        plataxD.setVisible(true);
        
        categoria.setText("ENTRADAS");
        precioItem1.setText("2.50");
        precioItem2.setText("2.00");
        precioItem3.setText("2.00");
        precioItem4.setText("3.00");
        
        String Datos[] = new String[4];
        Datos[0]="Caldo de gallina";
        Datos[1]="Ocopa Arequipeña";
        Datos[2]="Tequeños";
        Datos[3]="Ceviche Mixto";
        listaItems.clear();
        for(int i = 0; i<4; i++){
            listaItems.addElement(Datos[i]);
        }
        listOpcionMenu.setModel(listaItems);
        
        
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void btnSegundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSegundosActionPerformed
        Segundos.setSize(130, 350);
        Segundos.setLocation(0, 0);
        panelItems.removeAll();
        panelItems.add(Segundos, BorderLayout.CENTER);
        panelItems.revalidate(); 
        panelItems.repaint();
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
        spinner4.setValue(0);
        spinner1.setVisible(false);
        spinner2.setVisible(false);
        spinner3.setVisible(false);
        spinner4.setVisible(false);
        precioItem1.setVisible(true);
        precioItem2.setVisible(true);
        precioItem3.setVisible(true);
        precioItem4.setVisible(true);
        plataxD.setVisible(true);
        
        categoria.setText("SEGUNDOS");
        precioItem1.setText("6.00");
        precioItem2.setText("6.00");
        precioItem3.setText("6.00");
        precioItem4.setText("6.00");
        
        
        String Datos[] = new String[4];
        Datos[0]="Seco de cabrito";
        Datos[1]="Aji de gallina";
        Datos[2]="Arroz con pollo";
        Datos[3]="Tallarin verde";
        listaItems.clear();
        for(int i = 0; i<4; i++){
            listaItems.addElement(Datos[i]);
        }
        listOpcionMenu.setModel(listaItems);
        
    }//GEN-LAST:event_btnSegundosActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        
        
        Bebidas.setSize(130, 350);
        Bebidas.setLocation(0, 0);
        panelItems.removeAll();
        panelItems.add(Bebidas, BorderLayout.CENTER);
        panelItems.revalidate(); 
        panelItems.repaint();
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
        spinner4.setValue(0);
        spinner1.setVisible(false);
        spinner2.setVisible(false);
        spinner3.setVisible(false);
        spinner4.setVisible(false);
        precioItem1.setVisible(true);
        precioItem2.setVisible(true);
        precioItem3.setVisible(true);
        precioItem4.setVisible(false);
        plataxD.setVisible(false);
        
        categoria.setText("BEBIDAS");
        precioItem1.setText("5.00");
        precioItem2.setText("4.00");
        precioItem3.setText("2.00");
        
        
        String Datos[] = new String[3];
        Datos[0]="Coca cola (2L)";
        Datos[1]="Cerveza Pilsen";
        Datos[2]="Frugo";
        listaItems.clear();
        for(int i = 0; i<3; i++){
            listaItems.addElement(Datos[i]);
        }
        listOpcionMenu.setModel(listaItems);
        
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnVerMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMenusActionPerformed
        try{
            
            lbMesa.setText(txtMesa.getText());
            lbMesero.setText(cbxEmpleado.getSelectedItem().toString());
            lbCliente.setText(txtCliente.getText());
            JDPedido.setVisible(true);
            JDPedido.setLocationRelativeTo(null);
            JDPedido.setResizable(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Completa todos los campos!");
        }
        codigoEmpleado();
        codigoPedido = txtCodP.getText();
    }//GEN-LAST:event_btnVerMenusActionPerformed

    private void listOpcionMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOpcionMenuMousePressed
        if(listOpcionMenu.isSelectedIndex(0)){
            spinner1.setVisible(true);
            spinner2.setVisible(false);
            spinner3.setVisible(false);
            spinner4.setVisible(false);
        }
        if(listOpcionMenu.isSelectedIndex(1)){
            spinner2.setVisible(true);
            spinner1.setVisible(false);
            spinner3.setVisible(false);
            spinner4.setVisible(false);
        }
        if(listOpcionMenu.isSelectedIndex(2)){
            spinner3.setVisible(true);
            spinner2.setVisible(false);
            spinner4.setVisible(false);
            spinner1.setVisible(false);
        }
        if(listOpcionMenu.isSelectedIndex(3)){
            spinner4.setVisible(true);
            spinner1.setVisible(false);
            spinner2.setVisible(false);
            spinner3.setVisible(false);
        }
    }//GEN-LAST:event_listOpcionMenuMousePressed

    private void enviarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarPedidoActionPerformed
        String Datos[] = new String[5];
        Datos[0] = txtCliente.getText();
        Datos[1] = txtMesa.getText();
        Datos[2] = cbxEmpleado.getSelectedItem().toString();
        
        
        
        String detalles="Pedido:";
        for (int i = 0; i < listaDetalle.size(); i++) {
            detalles = detalles+listaDetalle.get(i)+", ";
        }
        Datos[3]=detalles;
        
        float suma=0;
        for (int i = 0; i < total.size(); i++) {
            suma = suma + total.get(i);
        }
        precioTotal.setText(Float.toString(suma));
        Datos[4] = Float.toString(suma);
        
        pedidos.addRow(Datos);
        
        JDPedido.dispose();
        guardarDetallePedido();
    }//GEN-LAST:event_enviarPedidoActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
    }//GEN-LAST:event_formMouseDragged

    private void eliminarFilaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarFilaMousePressed
        int filaseleccionada = tablaOrden.getSelectedRow();
        
        if(filaseleccionada>=0){
            try{
                modelo.removeRow(filaseleccionada);
            }catch(Exception e){
                System.out.println("Problemas al borar fila");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
        }
        
    }//GEN-LAST:event_eliminarFilaMousePressed

    private void cbxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpleadoActionPerformed
        
    }//GEN-LAST:event_cbxEmpleadoActionPerformed

    private void btnAceptarOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarOrdenMouseClicked
        guardarPedido();
    }//GEN-LAST:event_btnAceptarOrdenMouseClicked

    private void cbxEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEmpleadoMouseClicked
        
    }//GEN-LAST:event_cbxEmpleadoMouseClicked

    private void cbxEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEmpleadoItemStateChanged
        
    }//GEN-LAST:event_cbxEmpleadoItemStateChanged

    private void txtMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesaActionPerformed

    private void txtCodPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodPActionPerformed

    private void btnFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturaMouseClicked
        generarReporte();
    }//GEN-LAST:event_btnFacturaMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bebidas;
    private javax.swing.JPanel Entradas;
    private javax.swing.JDialog JDPedido;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Postres;
    private javax.swing.JPanel Segundos;
    private javax.swing.JLabel btnAceptarOrden;
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnEntradas;
    private javax.swing.JLabel btnFactura;
    private javax.swing.JButton btnPostres;
    private javax.swing.JButton btnSegundos;
    private javax.swing.JButton btnVerMenus;
    private javax.swing.JLabel categoria;
    private javax.swing.JComboBox<String> cbxEmpleado;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel eliminarFila;
    private javax.swing.JButton enviarPedido;
    private javax.swing.JButton enviarTabla;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbMesa;
    private javax.swing.JLabel lbMesero;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JList<String> listOpcionMenu;
    private javax.swing.JButton mesa1;
    private javax.swing.JButton mesa2;
    private javax.swing.JButton mesa3;
    private javax.swing.JButton mesa4;
    private javax.swing.JButton mesa5;
    private javax.swing.JButton mesa6;
    private javax.swing.JButton mesa7;
    private javax.swing.JButton mesa8;
    private javax.swing.JPanel panelItems;
    private javax.swing.JLabel plataxD;
    private javax.swing.JLabel precioItem1;
    private javax.swing.JLabel precioItem10;
    private javax.swing.JLabel precioItem2;
    private javax.swing.JLabel precioItem3;
    private javax.swing.JLabel precioItem4;
    private javax.swing.JLabel precioItem7;
    private javax.swing.JLabel precioItem8;
    private javax.swing.JLabel precioItem9;
    private javax.swing.JLabel precioTotal;
    private javax.swing.JSpinner spinner1;
    private javax.swing.JSpinner spinner2;
    private javax.swing.JSpinner spinner3;
    private javax.swing.JSpinner spinner4;
    private javax.swing.JTable tablaOrden;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodP;
    private javax.swing.JTextField txtMesa;
    // End of variables declaration//GEN-END:variables
}
