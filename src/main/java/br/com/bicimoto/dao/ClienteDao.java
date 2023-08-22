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
            
            
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void deleteCliente(ClienteModel cliente){
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            String sql = "delete from cliente where cd_cliente = ?";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cliente.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Deletado", 2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateCliente(ClienteModel cliente){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "UPDATE public.cliente" +
"SET nm_cliente= ?, ds_telefone= ?, dt_nascimento= ?, ds_cpf= ?, ds_email= ?, ds_cep= ?, ds_endereco= ?, ds_cidade= ?, ds_bairro= ?, ds_estado= ? " +
"WHERE cd_cliente= ? ";
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
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso","Atualização",2);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public List<ClienteModel> selectCliente(String nm_cliente){
        List<ClienteModel> lista_cliente = new ArrayList<ClienteModel>();
        ResultSet result;
        String sql;
        try(Connection connDb = ConnectionDatabase.getConnection()){
            if(nm_cliente != null){
                sql =  "select * from cliente where nm_cliente like ? ";
                PreparedStatement stmt = connDb.prepareStatement(sql);
                stmt.setString(1, "%"+nm_cliente+"%");
                result = stmt.executeQuery();
            }else{
                sql =  "select * from cliente";
                Statement stmt = connDb.createStatement();
                result = stmt.executeQuery(sql);
            }

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

    public int selectLastId(){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            Statement stmt = connDb.createStatement();
            String sql = "select nextval('cliente_cd_cliente_seq'::regclass) ";
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

