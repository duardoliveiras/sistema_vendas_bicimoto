/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.FornecedorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class FornecedorDao {
    
    public void insertFornecedor(FornecedorModel fornecedor){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "insert into fornecedor(nm_fornecedor, ds_telefone, ds_endereco, ds_cnpj, ds_email, ds_cep, ds_cidade, ds_estado, ds_bairro) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1,fornecedor.getNm_fornecedor());
            stmt.setString(2,fornecedor.getDs_telefone());
            stmt.setString(3, fornecedor.getDs_endereco());
            stmt.setString(4,fornecedor.getDs_cnpj());
            stmt.setString(5,fornecedor.getDs_email());
            stmt.setString(6,fornecedor.getDs_cep());
            stmt.setString(7,fornecedor.getDs_cidade());
            stmt.setString(8,fornecedor.getDs_estado());
            stmt.setString(9,fornecedor.getDs_bairro());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!", "Cadastro", 1);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void deleteFornecedor(Long cd_fornecedor){
        String sql = "delete from fornecedor where cd_fornecedor = ?";
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_fornecedor);
            int rows = stmt.executeUpdate();
            stmt.close();
            if(rows > 0){
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Deletado", 1);
            }else{
            JOptionPane.showMessageDialog(null, "Código de cliente não encontrado!", "Aviso", 2);    
            }
            stmt.close();
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void updateFornecedor(FornecedorModel fornecedor){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "update fornecedor set nm_fornecedor=?, ds_telefone=?, ds_endereco=?, ds_cnpj=?, ds_email=?, ds_cep=?, ds_cidade=?, ds_estado=?, ds_bairro=? where cd_fornecedor=?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1,fornecedor.getNm_fornecedor());
            stmt.setString(2,fornecedor.getDs_telefone());
            stmt.setString(3, fornecedor.getDs_endereco());
            stmt.setString(4,fornecedor.getDs_cnpj());
            stmt.setString(5,fornecedor.getDs_email());
            stmt.setString(6,fornecedor.getDs_cep());
            stmt.setString(7,fornecedor.getDs_cidade());
            stmt.setString(8,fornecedor.getDs_estado());
            stmt.setString(9,fornecedor.getDs_bairro());
            stmt.setLong(10, fornecedor.getCd_fornecedor());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!", "Cadastro", 1);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public List<FornecedorModel> selectFornecedor(String nome){
        List<FornecedorModel> lista = new ArrayList<FornecedorModel>();
        String sql;
        ResultSet result;
        
        try(Connection connDb = ConnectionDatabase.getConnection()){
            if(nome != null){
             sql = "select cd_fornecedor, nm_fornecedor, ds_telefone, ds_endereco, ds_cnpj, ds_email, ds_cep, ds_cidade, ds_estado, ds_bairro from fornecedor where lower(nm_fornecedor) like lower(?)";
             PreparedStatement stmt = connDb.prepareStatement(sql);
             stmt.setString(1, "%" + nome + "%");
             result = stmt.executeQuery();
            }else{
             sql = "select cd_fornecedor, nm_fornecedor, ds_telefone, ds_endereco, ds_cnpj, ds_email, ds_cep, ds_cidade, ds_estado, ds_bairro from fornecedor";
             Statement stmt = connDb.createStatement();
             result = stmt.executeQuery(sql);
            }
            
            while(result.next()){
                FornecedorModel fornecedor = new FornecedorModel();
                
                fornecedor.setCd_fornecedor(result.getLong("cd_fornecedor"));
                fornecedor.setDs_bairro(result.getString("ds_bairro"));
                fornecedor.setDs_cep(result.getString("ds_cep"));
                fornecedor.setDs_cidade(result.getString("ds_cidade"));
                fornecedor.setDs_cnpj(result.getString("ds_cnpj"));
                fornecedor.setDs_email(result.getString("ds_email"));
                fornecedor.setDs_endereco(result.getString("ds_endereco"));
                fornecedor.setDs_estado(result.getString("ds_estado"));
                fornecedor.setDs_telefone(result.getString("ds_telefone"));
                fornecedor.setNm_fornecedor(result.getString("nm_fornecedor"));
                
                lista.add(fornecedor);
            }
            
           result.close();
           connDb.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
    public FornecedorModel selectOneFornecedor(String nome){
        
        FornecedorModel f = new FornecedorModel();
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "select cd_fornecedor, nm_fornecedor, ds_telefone, ds_endereco, ds_cnpj, ds_email, ds_cep, ds_cidade, ds_estado, ds_bairro from fornecedor where nm_fornecedor =?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet result = stmt.executeQuery();
            
            
            
            if(result.next()){
                f.setCd_fornecedor(result.getLong("cd_fornecedor"));
                f.setDs_bairro(result.getString("ds_bairro"));
                f.setDs_cep(result.getString("ds_cep"));
                f.setDs_cidade(result.getString("ds_cidade"));
                f.setDs_cnpj(result.getString("ds_cnpj"));
                f.setDs_email(result.getString("ds_email"));
                f.setDs_endereco(result.getString("ds_endereco"));
                f.setDs_estado(result.getString("ds_estado"));
                f.setDs_telefone(result.getString("ds_telefone"));
                f.setNm_fornecedor(result.getString("nm_fornecedor"));
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return f;
    }
    
        public FornecedorModel selectOneFornecedor(Long cd_fornecedor){
        
        FornecedorModel f = new FornecedorModel();
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "select cd_fornecedor, nm_fornecedor, ds_telefone, ds_endereco, ds_cnpj, ds_email, ds_cep, ds_cidade, ds_estado, ds_bairro from fornecedor where cd_fornecedor =?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_fornecedor);
            ResultSet result = stmt.executeQuery();
            
            
            
            if(result.next()){
                f.setCd_fornecedor(result.getLong("cd_fornecedor"));
                f.setDs_bairro(result.getString("ds_bairro"));
                f.setDs_cep(result.getString("ds_cep"));
                f.setDs_cidade(result.getString("ds_cidade"));
                f.setDs_cnpj(result.getString("ds_cnpj"));
                f.setDs_email(result.getString("ds_email"));
                f.setDs_endereco(result.getString("ds_endereco"));
                f.setDs_estado(result.getString("ds_estado"));
                f.setDs_telefone(result.getString("ds_telefone"));
                f.setNm_fornecedor(result.getString("nm_fornecedor"));
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return f;
    }
    
    
    
    
    
}
