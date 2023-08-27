/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.ItensModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class ItensDao {
    
    public void insertItens(ItensModel item){
        String sql = "INSERT INTO venda_item (qt_produto, vl_subtotal, cd_produto, cd_venda) values (?,?,?,?)"; 
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidade());
            stmt.setFloat(2, item.getSubtotal());
            stmt.setLong(3, item.getProduto().getCd_produto());
            stmt.setLong(4, item.getVenda().getCd_venda());
            
            stmt.execute();
            
            stmt.close();
            connDb.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
