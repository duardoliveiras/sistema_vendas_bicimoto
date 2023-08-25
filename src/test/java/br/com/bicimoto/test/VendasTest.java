/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.test;


import br.com.bicimoto.dao.VendasDao;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Eduar
 */

public class VendasTest {
    
    private VendasDao vendasDao;
    private Date data;
    
     @Before
    public void setUp(){
        vendasDao = new VendasDao();
    }
    @Test
    public void testSetData(){

        data = vendasDao.getSysdate();
        System.out.println(data);
    }
 
    
}
