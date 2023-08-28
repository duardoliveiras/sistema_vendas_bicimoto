/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.FornecedorModel;
import br.com.bicimoto.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

/**
 *
 * @author Eduar
 */
public class ProdutoDao {
    
    private final FornecedorDao fornecedorDao = new FornecedorDao();
    
    public void insertProduto(ProdutoModel produto){
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            String sql = "insert into produto(nm_produto, ds_produto, vl_inicial, vl_final, qt_produto, cd_fornecedor, dt_atualizacao) values(?,?,?,?,?,?, now() )";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, produto.getNm_produto());
            stmt.setString(2, produto.getDs_produto());
            stmt.setFloat(3, produto.getVl_inicial());
            stmt.setFloat(4,produto.getVl_final());
            stmt.setInt(5,produto.getQt_produto());
            stmt.setLong(6, produto.getFornecedorModel().getCd_fornecedor());
            
            stmt.execute();
            stmt.close();
            connDb.close();
            
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!", "Cadastro", 1);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e, "Cadastro", 2);
        }
        
        
    }
    
    public void updateProduto(ProdutoModel produto){
         try(Connection connDb = ConnectionDatabase.getConnection()) {
            String sql = "update produto set nm_produto=?, ds_produto=?, vl_inicial=?, vl_final=?, qt_produto=?, dt_atualizacao=now() where cd_produto=?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, produto.getNm_produto());
            stmt.setString(2, produto.getDs_produto());
            stmt.setFloat(3, produto.getVl_inicial());
            stmt.setFloat(4,produto.getVl_final());
            stmt.setInt(5,produto.getQt_produto());
            stmt.setLong(6, produto.getCd_produto());
            
            int rows = stmt.executeUpdate();
            stmt.close();
            connDb.close();
            if(rows > 0){
              JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Cadastro", 1);
            }else{
              JOptionPane.showMessageDialog(null, "Erro ao atualizar", "Cadastro", 2);
            }
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e, "Cadastro", 2);
        }
        
        
    }
    
    public void deleteProduto(Long cd_produto){
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            String sql = "delete from produto where cd_produto=?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_produto);
            int rows = stmt.executeUpdate();
            stmt.close();
            connDb.close();
            if(rows > 0){
              JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!", "Cadastro", 1);
            }else{
              JOptionPane.showMessageDialog(null, "Erro ao deletar", "Cadastro", 2);
            }   
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e, "Cadastro", 2);
        }
        
    }
    
    public void adicionarEstoque(int quantidade, Long cd_produto){
        String sql = "update produto set qt_produto = ?, dt_atualizacao=now() where cd_produto=?";
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setLong(2,cd_produto);
            int rows = stmt.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!", "Cadastro", 1);
            }else{
              JOptionPane.showMessageDialog(null, "Erro ao adicionar", "Cadastro", 2);
            }   
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Cadastro", 2);
        }
    }
    
    public List<ProdutoModel> selectProduto(String nm_produto){
        List<ProdutoModel> lista = new ArrayList<ProdutoModel>(); 
        String sql;
        ResultSet result;
        try(Connection connDb = ConnectionDatabase.getConnection()){
            if(nm_produto != null){
                sql = "select a.cd_produto, a.nm_produto, b.nm_fornecedor, a.qt_produto, a.dt_atualizacao, a.vl_inicial, a.vl_final, a.ds_produto from produto a inner join fornecedor b on a.cd_fornecedor = b.cd_fornecedor where lower(nm_produto) like lower(?) ";
                PreparedStatement stmt = connDb.prepareStatement(sql);
                stmt.setString(1, "%" + nm_produto + "%");
                result = stmt.executeQuery();
                
            }else{
                sql = "select a.cd_produto, a.nm_produto, b.nm_fornecedor, b.qt_produto, a.dt_atualizacao, a.vl_inicial, a.vl_final, a.ds_produto from produto a inner join fornecedor on a.cd_fornecedor = b.cd_fornecedor";
                Statement stmt = connDb.createStatement();
                result = stmt.executeQuery(sql);
            }
           while(result.next()){
               ProdutoModel produtoModel = new ProdutoModel();           
               FornecedorModel fornecedor = new FornecedorModel();
               fornecedor.setNm_fornecedor(result.getString("nm_fornecedor"));
               
               produtoModel.setCd_produto(result.getLong("cd_produto"));
               produtoModel.setNm_produto(result.getString("nm_produto"));
               produtoModel.setQt_produto(result.getInt("qt_produto"));
               produtoModel.setDt_atualizacao(result.getDate("dt_atualizacao"));
               produtoModel.setVl_inicial(result.getFloat("vl_inicial"));
               produtoModel.setVl_final(result.getFloat("vl_final"));
               produtoModel.setDs_produto(result.getString("ds_produto"));
               
               produtoModel.setFornecedorModel(fornecedor);
               lista.add(produtoModel);
           }
           
           result.close();
           connDb.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Erro Consulta", 2);
        }
        return lista;
        
    }
    
    public ProdutoModel selectProdutoNome(String nm_produto){
        ProdutoModel produtoModel = new ProdutoModel();
        String sql = "SELECT cd_produto, nm_produto, ds_produto, vl_inicial, vl_final, qt_produto, cd_fornecedor, dt_atualizacao from produto where nm_produto =?";
        ResultSet result;
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, nm_produto );
            result = stmt.executeQuery();
            if(result.next()){
               produtoModel.setCd_produto(result.getLong("cd_produto"));
               produtoModel.setNm_produto(result.getString("nm_produto"));
               produtoModel.setQt_produto(result.getInt("qt_produto"));
               produtoModel.setDt_atualizacao(result.getDate("dt_atualizacao"));
               produtoModel.setVl_inicial(result.getFloat("vl_inicial"));
               produtoModel.setVl_final(result.getFloat("vl_final"));
               produtoModel.setDs_produto(result.getString("ds_produto"));
               produtoModel.setCd_fornecedor(result.getLong("cd_fornecedor"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro Consulta", 2);
        }
        return produtoModel;
    }
    
        public ProdutoModel selectProdutoId(Long id){
        ProdutoModel produtoModel = new ProdutoModel();
        String sql = "SELECT cd_produto, nm_produto, ds_produto, vl_inicial, vl_final, qt_produto, cd_fornecedor, dt_atualizacao from produto where cd_produto =?";
        ResultSet result;
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, id );
            result = stmt.executeQuery();
            if(result.next()){
               FornecedorModel fornecedor = fornecedorDao.selectOneFornecedor(result.getLong("cd_fornecedor"));
               produtoModel.setFornecedorModel(fornecedor);
               produtoModel.setCd_produto(result.getLong("cd_produto"));
               produtoModel.setNm_produto(result.getString("nm_produto"));
               produtoModel.setQt_produto(result.getInt("qt_produto"));
               produtoModel.setDt_atualizacao(result.getDate("dt_atualizacao"));
               produtoModel.setVl_inicial(result.getFloat("vl_inicial"));
               produtoModel.setVl_final(result.getFloat("vl_final"));
               produtoModel.setDs_produto(result.getString("ds_produto"));
               produtoModel.setCd_fornecedor(result.getLong("cd_fornecedor"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro Consulta", 2);
        }
        return produtoModel;
    }
        
        public void atualizaEstoque(ProdutoModel produto, int quantidade){
            String sql = "update produto set qt_produto=qt_produto-? where cd_produto =?";
            try(Connection connDb = ConnectionDatabase.getConnection()){
                PreparedStatement stmt = connDb.prepareStatement(sql);
                
                stmt.setInt(1, quantidade);
                stmt.setLong(2, produto.getCd_produto());
                
                int rows = stmt.executeUpdate();
                
                if(rows == 0){
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque", "Erro", 2);
                }
                stmt.close();
                connDb.close();
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e, "Erro", 2);
            }
        }
    
}
