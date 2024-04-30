/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.dao;

import br.com.bicimoto.jdbc.ConnectionDatabase;
import br.com.bicimoto.model.VendasPrazoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public void updateVendaPrazo(Long cd_venda_prazo, float vl_pago){
        String sql = "UPDATE public.vendas_prazo\n" +
                    "SET vl_pago=vl_pago + ?\n" +
                    "WHERE cd_venda_prazo=?";
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            
            stmt.setFloat(1, vl_pago);
            stmt.setLong(2, cd_venda_prazo);
            
            stmt.execute();
            stmt.close();
            connDb.close();
            
            JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso!");

            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void resetarVendaPrazo(Long cd_venda_prazo){
        String sql = "UPDATE public.vendas_prazo\n" +
                    "SET vl_pago=0\n" +
                    "WHERE cd_venda_prazo=?";
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            
            stmt.setLong(1, cd_venda_prazo);
            
            stmt.execute();
            stmt.close();
            connDb.close();
            
            JOptionPane.showMessageDialog(null, "Pagamento desfeito!");

            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public List<VendasPrazoModel> selectVendasPorCliente(Long cd_cliente, String status){
        List<VendasPrazoModel> lista = new ArrayList<>();
        
        String sql = 
                "select \n" +
                "vp.status_pagamento, \n" +
                "vp.cd_venda_prazo, \n" +
                "vp.cd_venda, \n" +
                "vp.nm_parcela, \n" +
                "vp.vl_parcela, \n" +
                "vp.vl_pago, \n" +
                "vp.dt_vencimento\n" +
                "from cliente c, venda v, vendas_prazo vp  \n" +
                "where v.cd_cliente = c.cd_cliente \n" +
                "and v.cd_cliente = ? \n" +
                "and vp.status_pagamento = ?::status_pagamento\n" +
                "and v.cd_venda = vp.cd_venda\n" +
                "order by vp.dt_vencimento asc";
        
        ResultSet result;
        
        try(Connection connDb = ConnectionDatabase.getConnection()){
            PreparedStatement stmt = connDb.prepareStatement(sql);
            stmt.setLong(1, cd_cliente);
            stmt.setString(2, status);
            result = stmt.executeQuery();
            
            while(result.next()){
                VendasPrazoModel vendaPrazo = new VendasPrazoModel();
                vendaPrazo.setStatus_pagamento(result.getString("status_pagamento"));
                vendaPrazo.setCd_venda_prazo(result.getLong("cd_venda_prazo"));
                vendaPrazo.setCd_venda(result.getLong("cd_venda"));
                vendaPrazo.setNm_parcela(result.getInt("nm_parcela"));
                vendaPrazo.setVl_parcela(result.getFloat("vl_parcela"));
                vendaPrazo.setVl_pago(result.getFloat("vl_pago"));
                vendaPrazo.setDt_vencimento(result.getDate("dt_vencimento"));

                lista.add(vendaPrazo);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }

        return lista;
    }
    
}
