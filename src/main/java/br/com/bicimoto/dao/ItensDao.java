/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.ItensModel;
import br.com.bicimoto.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class ItensDao {
    
    
    private final ProdutoDao produtoDao = new ProdutoDao();
    
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
    
    public List<ItensModel> selectTodosItens(Long cd_venda){
        List<ItensModel> lista = new ArrayList<>();
        String sql = "select qt_produto, cd_produto, vl_subtotal from venda_item where cd_venda =?";
        ResultSet result;
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_venda);
            
            result = stmt.executeQuery();
            
            while(result.next()){
                ItensModel item = new ItensModel();
                ProdutoModel produto = produtoDao.selectProdutoId(result.getLong("cd_produto"));
                
                item.setProduto(produto);
                item.setQuantidade(result.getInt("qt_produto"));
                item.setSubtotal(result.getFloat("vl_subtotal"));
                
                lista.add(item);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
            
        
        return lista;
    }
    
}
