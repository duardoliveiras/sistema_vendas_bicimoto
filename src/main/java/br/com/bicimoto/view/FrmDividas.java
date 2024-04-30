/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.bicimoto.view;

import br.com.bicimoto.dao.VendasPrazoDao;
import br.com.bicimoto.model.ClienteModel;
import br.com.bicimoto.dao.ItensDao;
import br.com.bicimoto.dao.VendasDao;
import br.com.bicimoto.model.ItensModel;
import br.com.bicimoto.model.VendasPrazoModel;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author G15
 */
public class FrmDividas extends javax.swing.JFrame {
    Long id_cliente;
    String nome_cliente;
    private final VendasPrazoDao vendasPrazoDao = new VendasPrazoDao();
    /**
     * Creates new form FrmDividas
     */
    public FrmDividas() {
        initComponents();
        optionAberto.setSelected(true);
    }
    
    public void setCliente(Long id_cliente, String nome_cliente){
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        
        listarDividas("aberto");
        btnRestaurar.setVisible(false);
        txtCliente.setText(nome_cliente);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCDividas = new javax.swing.JTable();
        btnRestaurar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        optionAberto = new javax.swing.JRadioButton();
        optionPago = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtTotalSelecionado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCItens = new javax.swing.JTable();
        txtVlPagamento = new javax.swing.JFormattedTextField();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Johnny Torch", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dividas");

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        tblCDividas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCDividas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Venda", "N. Parcela", "Valor Parcela", "Valor Pago", "Valor Restante", "Data de Vencimento", "Juros", "Cód."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCDividas.setColumnSelectionAllowed(true);
        tblCDividas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCDividasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCDividas);
        tblCDividas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnRestaurar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Cliente:");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        optionAberto.setText("Aberto");
        optionAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionAbertoActionPerformed(evt);
            }
        });

        optionPago.setText("Pago");
        optionPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionPagoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Restante:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtTotalSelecionado.setEditable(false);
        txtTotalSelecionado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalSelecionadoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total Selecionado:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Valor Pagamento:");

        tblCItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantidade", "Produto", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tblCItens);

        txtVlPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtVlPagamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/payment-method.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTotalSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtVlPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(optionAberto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optionPago)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(651, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionAberto)
                    .addComponent(optionPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtVlPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRestaurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(373, Short.MAX_VALUE)
                    .addComponent(btnPagar)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        FrmCliente frmCliente = new FrmCliente();
        frmCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        try {
            int selectedRow = tblCDividas.getSelectedRow();
            if (selectedRow != -1) { 
                 long cd_venda_prazo = Long.parseLong(tblCDividas.getModel().getValueAt(selectedRow, 7).toString());
                 vendasPrazoDao.resetarVendaPrazo(cd_venda_prazo);
                 listarDividas("pago");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um item da tabela.", "Nenhum item selecionado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao obter o valor da tabela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void optionAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionAbertoActionPerformed
        optionPago.setSelected(false);
        listarDividas("aberto");
        
        if(optionAberto.isSelected()){
            btnRestaurar.setVisible(false);
            btnPagar.setVisible(true);
            txtVlPagamento.setEditable(true);
        }
    }//GEN-LAST:event_optionAbertoActionPerformed

    private void txtTotalSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalSelecionadoActionPerformed
        
    }//GEN-LAST:event_txtTotalSelecionadoActionPerformed

    private void optionPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionPagoActionPerformed
        optionAberto.setSelected(false);
        listarDividas("pago");
        
        if(optionPago.isSelected()){
            btnRestaurar.setVisible(true);
            btnPagar.setVisible(false);
            txtVlPagamento.setEditable(false);
        }
    }//GEN-LAST:event_optionPagoActionPerformed
    private final ItensDao itensDao = new ItensDao();
    private void geraItens(){
        DefaultTableModel dadosItens = (DefaultTableModel) tblCItens.getModel();
        dadosItens.setNumRows(0);
        
        try {
            Long cd_venda = Long.parseLong(tblCDividas.getValueAt(tblCDividas.getSelectedRow(), 0).toString());
            
            txtTotalSelecionado.setText( tblCDividas.getValueAt(tblCDividas.getSelectedRow(), 4).toString());
            
            List<ItensModel> lista = itensDao.selectTodosItens(cd_venda);


            for(ItensModel item : lista){
                dadosItens.addRow(new Object[]{
                    item.getQuantidade(),
                    item.getProduto().getNm_produto(),
                    item.getSubtotal()
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void tblCDividasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCDividasMouseClicked
        geraItens();
    }//GEN-LAST:event_tblCDividasMouseClicked

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
               
        
        if(txtVlPagamento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe um valor", "Campos vazios", 0);
            return;
        }
        
        float vlPagamento = Float.parseFloat(txtVlPagamento.getText());
        
        try {
            int selectedRow = tblCDividas.getSelectedRow();
            if (selectedRow != -1) { 
                 long cd_venda_prazo = Long.parseLong(tblCDividas.getModel().getValueAt(selectedRow, 7).toString());
                 vendasPrazoDao.updateVendaPrazo(cd_venda_prazo, vlPagamento);
                 listarDividas("aberto");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um item da tabela.", "Nenhum item selecionado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao obter o valor da tabela. Por favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
        
    }//GEN-LAST:event_btnPagarActionPerformed

    public final VendasDao vendasDao = new VendasDao();
    
    public void listarDividas(String status){
        txtTotalSelecionado.setText("");
        txtVlPagamento.setText("");
        if(status.equals("aberto")){
            optionAberto.setSelected(true);
            optionPago.setSelected(false);
        }
        DefaultTableModel dadosDivida = (DefaultTableModel) tblCDividas.getModel();
        
        dadosDivida.setNumRows(0);
        
        List<VendasPrazoModel> lista = vendasPrazoDao.selectVendasPorCliente(this.id_cliente, status);
       
        Date sysdate = vendasDao.getSysdate();
        
        float cTotal = 0;
        for(VendasPrazoModel venda : lista){
       
            float taxa = (float) (0.5/100);
            long diasAtraso = ((sysdate.getTime() - venda.getDt_vencimento().getTime())/(24*60*60*1000));
            double vl_juros = 0;

            if(diasAtraso > 0 && venda.getStatus_pagamento().equals("aberto")) {
               vl_juros  = (venda.getVl_parcela() * Math.pow(1 + taxa, (diasAtraso)) - venda.getVl_parcela());
            }
            
            DecimalFormat df = new DecimalFormat("#.## R$");
            df.setMaximumFractionDigits(2);
            
            double vlRestanteDouble = (venda.getVl_parcela() - venda.getVl_pago());
            
            String totalComJuros = df.format(vl_juros + venda.getVl_parcela());
            String juros = df.format(vl_juros);
            String vlRestante = df.format(vlRestanteDouble >= 0 ? vlRestanteDouble : 0);
            String vlPago = df.format(venda.getVl_pago());
            
            cTotal += (vlRestanteDouble >= 0 ? vlRestanteDouble : 0);
            dadosDivida.addRow(new Object[]{
                venda.getCd_venda(),
                venda.getNm_parcela(),
                totalComJuros,
                vlPago,
                vlRestante,
                venda.getDt_vencimento(),
                juros,
                venda.getCd_venda_prazo()
                
            });
            
        }
        txtTotal.setText(String.valueOf(cTotal));
   

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDividas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDividas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDividas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDividas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDividas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton optionAberto;
    private javax.swing.JRadioButton optionPago;
    private javax.swing.JTable tblCDividas;
    private javax.swing.JTable tblCItens;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalSelecionado;
    private javax.swing.JFormattedTextField txtVlPagamento;
    // End of variables declaration//GEN-END:variables
}
