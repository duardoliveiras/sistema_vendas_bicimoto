/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.ClienteModel;
import br.com.bicimoto.model.VendasModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class VendasDao {
    
    private final ClienteDao clienteDao = new ClienteDao();
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public Date getSysdate(){
        String sql = "select now()";
        Date sysdate;
        ResultSet result;
        try(Connection connDb = ConnectionDatabase.getConnection()) {
            PreparedStatement stmt = connDb.prepareStatement(sql);
            result = stmt.executeQuery();
            
            
            if(result.next()){
                sysdate = result.getDate(1);
                return sysdate;
            }
            
        } catch (SQLException e) {
           
        }
        return null;
       
    }
    
    public void insertVenda(VendasModel venda){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            String sql = "insert into venda(cd_cliente, dt_venda, vl_total, ds_pagamento, ds_observacao, tipo_venda) values(?,now(),?,?,?,?::tipo_venda)";
            
            PreparedStatement stmt = connDb.prepareStatement(sql);
            
            stmt.setLong(1, venda.getCliente().getId());
            stmt.setFloat(2, venda.getVl_total());
            stmt.setString(3, venda.getDs_pagemento());
            stmt.setString(4, venda.getDs_observacao());
            stmt.setString(5, venda.getTipo_venda());
            
            
            stmt.execute();
            stmt.close();
            connDb.close();
            
            JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Long selectUltimaVenda(){
        String sql = "select max(cd_venda) from venda";
        ResultSet result;
        Long cd_venda = (long) 0;
        try(Connection connDb = ConnectionDatabase.getConnection()){
                Statement stmt = connDb.createStatement();
                result = stmt.executeQuery(sql);
                
                if(result.next()){
                    cd_venda = result.getLong(1);
                }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return cd_venda;
    }
    
    public List<VendasModel> selectTodasVendas(String sDt_inicial, String sDt_final) throws ParseException{
        
        // Primeiro converto a String em java.Date
        java.util.Date fdt_inicial = formatter.parse(sDt_inicial);
        java.util.Date fdt_final = formatter.parse(sDt_final);
        
        // depois converto o java.Date para sql.Date
        Date dt_inicial = new Date(fdt_inicial.getTime());
        Date dt_final = new Date(fdt_final.getTime());
        
        List<VendasModel> lista = new ArrayList<>();
        String sql = "SELECT cd_venda, cd_cliente, dt_venda, vl_total, ds_pagamento, ds_observacao, tipo_venda from venda where dt_venda between ? and ?";
        ResultSet result;
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setDate(1, dt_inicial);
            stmt.setDate(2, dt_final);
            result = stmt.executeQuery();
            
            while(result.next()){
                VendasModel venda = new VendasModel();
                ClienteModel cliente = clienteDao.selectClienteId(result.getLong("cd_cliente"));
                venda.setCliente(cliente);
                
                venda.setCd_venda(result.getLong("cd_venda"));
                venda.setDs_observacao(result.getString("ds_observacao"));
                venda.setDs_pagemento(result.getString("ds_pagamento"));
                venda.setVl_total(result.getFloat("vl_total"));
                venda.setDt_venda(result.getDate("dt_venda"));
                venda.setTipo_venda(result.getString("tipo_venda"));
                
                lista.add(venda);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return lista;
    }
    
    public void deletarItens(Long cd_venda){
        try(Connection connDb = ConnectionDatabase.getConnection()){
            
            String sql = "delete from venda_item where cd_venda=?";
            
            
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_venda);
            
            int rows = stmt.executeUpdate();
            stmt.close();
            connDb.close();
            if(rows > 0){
                deletarVenda(cd_venda);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao deletar itens", "Erro", 0);
            }
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void deletarVenda(Long cd_venda){
        
        try(Connection connDb = ConnectionDatabase.getConnection()){
            
            String sql = "delete from venda where cd_venda=?";
            
            
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_venda);
            
            int rows = stmt.executeUpdate();
            stmt.close();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao deletar itens", "Erro", 0);
            }
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
            
     
    
}
