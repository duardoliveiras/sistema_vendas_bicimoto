/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.test;

import br.com.bicimoto.dao.ItensDao;
import br.com.bicimoto.model.ItensModel;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Eduar
 */


public class ItemTest {
    
    private final ItensDao itensDao = new ItensDao();
    
    
    @Before
    public void setUp(){
      
        
    }
    
    @Test
    public void selectItens(){
    
        List<ItensModel> lista = itensDao.selectTodosItens((long) 14);
        
        for(ItensModel item : lista){
            System.out.println(item);
        }
        
    }
    
}
