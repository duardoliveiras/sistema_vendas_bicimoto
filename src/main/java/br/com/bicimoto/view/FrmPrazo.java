/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.bicimoto.view;

import br.com.bicimoto.dao.ItensDao;
import br.com.bicimoto.dao.ProdutoDao;
import br.com.bicimoto.dao.VendasDao;
import br.com.bicimoto.dao.VendasPrazoDao;
import br.com.bicimoto.model.ClienteModel;
import br.com.bicimoto.model.ItensModel;
import br.com.bicimoto.model.ProdutoModel;
import br.com.bicimoto.model.VendasModel;
import br.com.bicimoto.model.VendasPrazoModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author G15
 */
public class FrmPrazo extends javax.swing.JFrame {
    float entrada = 0;
    float total;
    
    DefaultTableModel itens;
    ClienteModel cliente = new ClienteModel();
    /**
     * Creates new form FrmPrazo
     */
    public FrmPrazo() {
        initComponents();
        
        
        opcaoGroup.add(parcelado);
        opcaoGroup.add(opcao15Dias);
        opcaoGroup.add(opcao30Dias);
        opcaoGroup.add(opcao45Dias);
        
        txtEntrada.setText(String.valueOf(entrada));
        txtEntrada.selectAll();
        
        ActionListener radioListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                opcaoGroup.clearSelection();
                ((JRadioButton) e.getSource()).setSelected(true);
                qtdParcela.setEnabled(parcelado.isSelected());
            }
        };
        
        parcelado.addActionListener(radioListener);
        opcao15Dias.addActionListener(radioListener);
        opcao30Dias.addActionListener(radioListener);
        opcao45Dias.addActionListener(radioListener);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcaoGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        opcao30Dias = new javax.swing.JRadioButton();
        opcao45Dias = new javax.swing.JRadioButton();
        opcao15Dias = new javax.swing.JRadioButton();
        parcelado = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        qtdParcela = new javax.swing.JSpinner();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Johnny Torch", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRAZO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("ENTRADA:");

        txtEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
        });

        opcao30Dias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcao30Dias.setText("30 Dias");

        opcao45Dias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcao45Dias.setText("45 Dias");
        opcao45Dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcao45DiasActionPerformed(evt);
            }
        });

        opcao15Dias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        opcao15Dias.setText("15 Dias");

        parcelado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        parcelado.setText("Parcelado:");
        parcelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parceladoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Selecione uma opção:");

        qtdParcela.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        qtdParcela.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        qtdParcela.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcao15Dias)
                            .addComponent(opcao45Dias)
                            .addComponent(opcao30Dias)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(parcelado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qtdParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(64, 64, 64))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(opcao15Dias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao30Dias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcao45Dias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parcelado)
                    .addComponent(qtdParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("TOTAL:");

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("OBS.:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/payment-method.png"))); // NOI18N
        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaActionPerformed
    
    private void calculaTotal(){
        this.entrada = txtEntrada.getText().isEmpty() ? 0 : Float.valueOf(txtEntrada.getText());
        txtTotal.setText(String.valueOf(this.total - this.entrada));
    }
    
    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            calculaTotal();
        }
    }//GEN-LAST:event_txtEntradaKeyPressed

    private final VendasDao vendasDao = new VendasDao();
    private final ItensDao itensDao = new ItensDao();
    private final ProdutoDao produtoDao = new ProdutoDao();
    private final VendasPrazoDao vendasPrazoDao = new VendasPrazoDao();
    private VendasModel venda;
    private ItensModel item;
    private ProdutoModel produto;
    private VendasPrazoModel vendaPrazo;
    private Calendar cal;
    
    private int getDiasVencimento(){
        if(opcao15Dias.isSelected()){
            return 15;
        }else if(opcao30Dias.isSelected()){
            return 30;
        }else if(opcao45Dias.isSelected()){
            return 45;
        }else{
            return 0;
        }
    }
    
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        int dias = this.getDiasVencimento();
        String descricao;
        
        if(dias == 0){
            descricao = "Parcelado em: " + qtdParcela.getValue() + " vezes";
        }else{
            descricao = "Prazo de: " + dias + " dias";
        }
        
        venda = new VendasModel();
        venda.setCliente(this.cliente);
        venda.setVl_total(this.total);
        venda.setDs_pagemento(descricao);
        venda.setDs_observacao(txtObs.getText());
        venda.setTipo_venda("prazo");
        
        vendasDao.insertVenda(venda);
        
        venda.setCd_venda(vendasDao.selectUltimaVenda());

        if(this.entrada > 0){
            vendaPrazo = new VendasPrazoModel();
            vendaPrazo.setCd_venda(venda.getCd_venda());
            vendaPrazo.setVl_parcela(entrada);
            vendaPrazo.setVl_pago(entrada);
            vendaPrazo.setDt_vencimento(vendasDao.getSysdate());
            vendaPrazo.setNm_parcela(0);
            vendaPrazo.setStatus_pagamento("pago");

            vendasPrazoDao.insertVendaPrazo(vendaPrazo);
            
        }
        
        float restante = this.total - this.entrada;
        if(dias > 0){
            // Adicionando o restante.            
            // Colocando prazo no vencimento
            Date sysdate = vendasDao.getSysdate();
            java.util.Date dataUtil = new java.util.Date(sysdate.getTime());
            cal = Calendar.getInstance();
            cal.setTime(dataUtil);
            cal.add(Calendar.DAY_OF_MONTH, dias);
            Date dt_vencimento = new Date(cal.getTimeInMillis());
            
            
            
            vendaPrazo = new VendasPrazoModel();
            vendaPrazo.setCd_venda(venda.getCd_venda());
            vendaPrazo.setVl_parcela(restante);
            vendaPrazo.setVl_pago(0);
            vendaPrazo.setDt_vencimento(dt_vencimento);
            vendaPrazo.setNm_parcela(1);
            vendaPrazo.setStatus_pagamento("aberto");
            
            vendasPrazoDao.insertVendaPrazo(vendaPrazo);
 
        }else if(dias == 0){
            
            int parcelas = Integer.parseInt(this.qtdParcela.getValue().toString());
            
            Date sysdate = vendasDao.getSysdate();
            java.util.Date dataUtil = new java.util.Date(sysdate.getTime());
            cal = Calendar.getInstance();
            
            float vl_parcela = restante / parcelas;
            
            for(int j = 1; j <= parcelas; j++){
                cal.setTime(dataUtil);
                cal.add(Calendar.DAY_OF_MONTH, 30 * j);
                Date dt_vencimento = new Date(cal.getTimeInMillis());
                
                vendaPrazo = new VendasPrazoModel();
                vendaPrazo.setCd_venda(venda.getCd_venda());
                vendaPrazo.setVl_parcela(vl_parcela);
                vendaPrazo.setVl_pago(0);
                vendaPrazo.setDt_vencimento(dt_vencimento);
                vendaPrazo.setNm_parcela(j);
                vendaPrazo.setStatus_pagamento("aberto");

                vendasPrazoDao.insertVendaPrazo(vendaPrazo);
            }
        }

        for(int i = 0; i < itens.getRowCount(); i++){
            item = new ItensModel();
            produto = new ProdutoModel();

            produto.setCd_produto(Long.parseLong(itens.getValueAt(i, 0).toString()));

            item.setQuantidade( Integer.parseInt(itens.getValueAt(i, 2).toString()));
            item.setSubtotal(Float.parseFloat(itens.getValueAt(i, 4).toString()));
            item.setVenda(venda);
            item.setProduto(produto);

            produtoDao.atualizaEstoque(produto, item.getQuantidade());
            itensDao.insertItens(item);
        }
        
        FrmMenu frmMenu = new FrmMenu();
        frmMenu.setVisible(true);
        this.dispose();
        

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void opcao45DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcao45DiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcao45DiasActionPerformed

    private void parceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parceladoActionPerformed

  
    }//GEN-LAST:event_parceladoActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrazo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrazo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrazo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrazo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrazo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opcao15Dias;
    private javax.swing.JRadioButton opcao30Dias;
    private javax.swing.JRadioButton opcao45Dias;
    private javax.swing.ButtonGroup opcaoGroup;
    private javax.swing.JRadioButton parcelado;
    private javax.swing.JSpinner qtdParcela;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtObs;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
