/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.test;


import br.com.bicimoto.dao.VendasDao;
import br.com.bicimoto.model.ClienteModel;
import br.com.bicimoto.model.VendasModel;
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
    private Date data;
    private SimpleDateFormat formatter;

     @Before
    public void setUp(){
        vendasDao = new VendasDao();
        venda = new VendasModel();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
    }
    @Test
    public void testSetData(){

        data = vendasDao.getSysdate();
        System.out.println(data);
    }
    
    /*
    @Test
    public void testInsert(){
       
        ClienteModel cliente = new ClienteModel();
        
        cliente.setId((long) 99);
        venda.setCliente(cliente);
        venda.setCd_venda((long) 1);
        venda.setDs_pagemento("Pix");
        venda.setVl_total((float) 255.63);
        
        vendasDao.insertVenda(venda);
        Long cd_venda = vendasDao.selectUltimaVenda();
        System.out.println(cd_venda);
    }
    */
    
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
    
}

