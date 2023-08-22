/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.bicimoto.test;

import br.com.bicimoto.dao.ClienteDao;
import br.com.bicimoto.model.ApiCep;
import br.com.bicimoto.model.ClienteModel;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Eduar
 */
public class ClienteTeste {
    private ClienteModel cliente;
    private ClienteDao clienteDao;
    private ApiCep apiCep;
    
    @Before
    public void setUp(){
      cliente = new ClienteModel();
      clienteDao = new ClienteDao();
      apiCep = new ApiCep();
    }
    @Test
    public void testSetData(){
        cliente.setDt_nascimento("06/06/2001");        
        System.out.println(cliente.getString_nascimento());
        System.out.println(cliente.getDt_nascimento());
    }
    @Test
    public void testSelectLastId(){
        System.out.println(clienteDao.selectLastId());
    }
    @Test
    public void testSelectAll(){
        List<ClienteModel> lista = clienteDao.selectCliente("");
        for(ClienteModel cliente : lista){
            System.out.println(cliente.getNome());
        }
    }
    @Test
    public void testApiCep() throws IOException{
        apiCep.getEndereco("78025300");
       
    }
}
