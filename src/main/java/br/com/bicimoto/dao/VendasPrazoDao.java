/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.VendasPrazoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author G15
 */
public class VendasPrazoDao {
    
    public void insertVendaPrazo(VendasPrazoModel vendaPrazo){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "insert into vendas_prazo(cd_venda, nm_parcela, vl_parcela, dt_vencimento, status_pagamento, vl_pago) values (?, ?, ?, ?, ?::status_pagamento, ?)";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            
            stmt.setLong(1, vendaPrazo.getCd_venda());
            stmt.setInt(2, vendaPrazo.getNm_parcela());
            stmt.setFloat(3, vendaPrazo.getVl_parcela());
            stmt.setDate(4, vendaPrazo.getDt_vencimento());
            stmt.setString(5, vendaPrazo.getStatus_pagamento());
            stmt.setFloat(6, vendaPrazo.getVl_pago());
   
            stmt.execute();
            stmt.close();
            connDb.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
