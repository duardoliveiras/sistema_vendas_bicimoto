/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.VendasModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class VendasDao {
    
    
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
            String sql = "insert into venda(cd_cliente, dt_venda, vl_total, ds_pagamento) values(?,now(),?,?)";
            PreparedStatement stmt = connDb.prepareStatement(sql);
            
            stmt.setLong(1, venda.getCliente().getId());
            stmt.setFloat(2, venda.getVl_total());
            stmt.setString(3, venda.getDs_pagemento());
            
            stmt.execute();
            stmt.close();
            connDb.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    
}
