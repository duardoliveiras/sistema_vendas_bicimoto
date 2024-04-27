/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.test;


import br.com.bicimoto.dao.VendasPrazoDao;
import br.com.bicimoto.dao.VendasDao;
import br.com.bicimoto.model.ClienteModel;
import br.com.bicimoto.model.VendasModel;
import br.com.bicimoto.model.VendasPrazoModel;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Eduar
 */

public class VendasTest {
    
    private VendasModel venda;
    private VendasDao vendasDao;
    private VendasPrazoDao vendasPrazoDao;
    private Date data;
    private SimpleDateFormat formatter;

    @Before
    public void setUp(){
        vendasDao = new VendasDao();
        vendasPrazoDao = new VendasPrazoDao();
        venda = new VendasModel();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
    }
    @Test
    public void testSetData(){

        data = vendasDao.getSysdate();
        System.out.println(data);
    }
    
    
//    @Test
//    public void testInsert() throws ParseException{
//       
//        ClienteModel cliente = new ClienteModel();
//        
//        cliente.setId((long) 1);
//        venda.setCliente(cliente);
//        venda.setCd_venda((long) 1);
//        venda.setDs_pagemento("Pix");
//        venda.setVl_total((float) 255.63);
//        
//        vendasDao.insertVenda(venda);
//        Long cd_venda = vendasDao.selectUltimaVenda();
//        
//        
//        VendasPrazoModel vendaPrazo = new VendasPrazoModel();
//        
//        String data = "25/05/2024";
//        java.util.Date data_formatada = formatter.parse(data);
//        
//        
//        vendaPrazo.setCd_venda(cd_venda);
//        vendaPrazo.setDt_vencimento(new Date(data_formatada.getTime()));
//        vendaPrazo.setNm_parcela(1);
//        vendaPrazo.setStatus_pagamento("aberto");
//        vendaPrazo.setVl_pago(0);
//        vendaPrazo.setVl_parcela((float)10.56);
//        
//        vendasPrazoDao.insertVendaPrazo(vendaPrazo);
//    }
    
    
    @Test
    public void testSelectAll(){
        try { 
            String sDt_inicial = "26/08/2023";
            String sDt_final = "26/08/2023";
            
            List<VendasModel> lista =  vendasDao.selectTodasVendas(sDt_inicial, sDt_final);    
            
            for(VendasModel venda : lista){
                System.out.println(venda.toString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
               
    }
    
    @Test
    public void testSelectVendaPrazo(){
      
        Long cd_cliente = (long) 1;
        List<VendasPrazoModel> lista = vendasPrazoDao.selectVendasPorCliente(cd_cliente, "aberto");
        
        for(VendasPrazoModel venda : lista){
            System.out.println(venda.toString());
        }
        
    }
    
}

