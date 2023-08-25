/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;
import br.com.bicimoto.model.ClienteModel;
import br.com.bicimoto.jdbc.ConnectionDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class ClienteDao {
    
    // utlizamos o prepared statement quando queremos inserir um paremetro na consulta sql
    public void insertCliente(ClienteModel cliente){
        
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            String sql = "INSERT INTO CLIENTE"
                    + " (nm_cliente,ds_telefone,dt_nascimento,ds_cpf,ds_email,ds_cep,ds_endereco,"
                    + "ds_cidade,ds_bairro,ds_estado) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setDate(3, cliente.getDt_nascimento());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getEndereco());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getEstado());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!", "Cadastro", 1);
            // biblioteca para exibir janelas
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void deleteCliente(Long id){
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            String sql = "delete from cliente where cd_cliente=?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, id);
            int rows = stmt.executeUpdate(); // o execute update retorna um inteiro que relaciona as linhas alteradas
            stmt.close();
            if(rows > 0){
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Deletado", 1);
            }else{
            JOptionPane.showMessageDialog(null, "Código de cliente não encontrado!", "Aviso", 2);    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void updateCliente(ClienteModel cliente){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "UPDATE cliente SET nm_cliente=?, ds_telefone=?, dt_nascimento=?, ds_cpf=?, ds_email=?, ds_cep=?, ds_endereco=?, ds_cidade=?, ds_bairro=?, ds_estado=? WHERE cd_cliente=?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setDate(3, cliente.getDt_nascimento());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getEndereco());
            stmt.setString(8, cliente.getCidade());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getEstado());
            stmt.setLong(11, cliente.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso","Atualização",1);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.toString());
        }
    }
    
    // lista executa um sql quando recebe null, ou um select com prepared statement (com um parametro nome)
    public List<ClienteModel> selectCliente(String nm_cliente){
        List<ClienteModel> lista_cliente = new ArrayList<ClienteModel>();
        ResultSet result; // um objeto que armazena os dados da consulta, como se fosse um cursor
        String sql;
        try(Connection connDb = ConnectionDatabase.getConnection()){
            if(nm_cliente != null){
                sql =  "select * from cliente where lower(nm_cliente) like lower(?) ";
                PreparedStatement stmt = connDb.prepareStatement(sql);
                stmt.setString(1, "%"+nm_cliente+"%"); // para usar o like '%edu%'
                result = stmt.executeQuery(); // salvo o cursor no objeto result 
            }else{
                sql =  "select * from cliente";
                Statement stmt = connDb.createStatement();
                result = stmt.executeQuery(sql);
            }

            // enquanto houver um proximo crie um objeto adicione as informacoes das colunas nos atributos e adicione esse objeto cliente na lista
            while(result.next()){ 
                ClienteModel cliente = new ClienteModel();
                
                cliente.setId(result.getLong("cd_cliente"));
                cliente.setNome(result.getString("nm_cliente"));
                cliente.setTelefone(result.getString("ds_telefone"));
                cliente.setCpf(result.getString("ds_cpf"));
                cliente.setBairro(result.getString("ds_bairro"));
                cliente.setEndereco(result.getString("ds_endereco"));
                cliente.setEmail(result.getString("ds_email"));
                cliente.setCep(result.getString("ds_cep"));
                cliente.setDt_nascimento(result.getDate("dt_nascimento"));
                cliente.setEstado(result.getString("ds_estado"));
                cliente.setCidade(result.getString("ds_cidade"));
                   
                lista_cliente.add(cliente);
            }
            result.close();
            connDb.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Consulta", 2);
        }
        return lista_cliente;
    }
    
    public ClienteModel selectClienteNome(String nome){
        String sql = "SELECT cd_cliente, nm_cliente, ds_telefone, dt_nascimento, ds_cpf, ds_email, ds_cep, ds_endereco, ds_cidade, ds_bairro, ds_estado from cliente where nm_cliente =?";
        ClienteModel cliente = new ClienteModel();
        ResultSet result;
        
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, nome);
            
            result = stmt.executeQuery();
            
            while(result.next()){
                cliente.setBairro(result.getString("ds_bairro"));
                cliente.setCep(result.getString("ds_cep"));
                cliente.setCidade(result.getString("ds_cidade"));
                cliente.setCpf(result.getString("ds_cpf"));
                cliente.setDt_nascimento(result.getDate("dt_nascimento"));                
                cliente.setEmail(result.getString("ds_email"));
                cliente.setEndereco(result.getString("ds_endereco"));
                cliente.setEstado(result.getString("ds_estado"));
                cliente.setId(result.getLong("cd_cliente"));
                cliente.setNome(result.getString("nm_cliente"));
                cliente.setTelefone(result.getString("ds_telefone"));
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Consulta", 2);
        }
        return cliente;
    }
    
    public ClienteModel selectClienteCpf(String cpf){
        String sql = "SELECT cd_cliente, nm_cliente, ds_telefone, dt_nascimento, ds_cpf, ds_email, ds_cep, ds_endereco, ds_cidade, ds_bairro, ds_estado from cliente where ds_cpf =?";
        ClienteModel cliente = new ClienteModel();
        ResultSet result;
        
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            result = stmt.executeQuery();
            
            if(result.next()){
                cliente.setBairro(result.getString("ds_bairro"));
                cliente.setCep(result.getString("ds_cep"));
                cliente.setCidade(result.getString("ds_cidade"));
                cliente.setCpf(result.getString("ds_cpf"));
                cliente.setDt_nascimento(result.getDate("dt_nascimento"));                
                cliente.setEmail(result.getString("ds_email"));
                cliente.setEndereco(result.getString("ds_endereco"));
                cliente.setEstado(result.getString("ds_estado"));
                cliente.setId(result.getLong("cd_cliente"));
                cliente.setNome(result.getString("nm_cliente"));
                cliente.setTelefone(result.getString("ds_telefone"));
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Consulta", 2);
        }
        return cliente;
    }
    

    // seleciona o ultimo proximo valor a ser cadastrado como cd_cliente
    public int selectLastId(){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            Statement stmt = connDb.createStatement();
            String sql = "SELECT (last_value+1) FROM cliente_cd_cliente_seq";
            ResultSet result = stmt.executeQuery(sql);
            if(result.next()){
                int lastId = result.getInt(1);
                return lastId;
            }else{
                return -1;
            }        
            
        }catch(SQLException e){
            e.getStackTrace();
        }
        return -1;
    }
    
}

