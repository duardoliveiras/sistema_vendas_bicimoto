/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
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
           JOptionPane.showMessageDialog(null, e);
        }
        return null;
       
    }
     
    
}
