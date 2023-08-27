/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

import java.sql.Date;

/**
 *
 * @author Eduar
 */
public class VendasModel {
    
    private Long cd_venda;
    private float vl_total;
    private ClienteModel cliente;
    private String ds_pagemento;
    private String ds_observacao;

    public String getDs_observacao() {
        return ds_observacao;
    }

    public void setDs_observacao(String ds_observacao) {
        this.ds_observacao = ds_observacao;
    }
    
    

    public String getDs_pagemento() {
        return ds_pagemento;
    }

    public void setDs_pagemento(String ds_pagemento) {
        this.ds_pagemento = ds_pagemento;
    }
    
    

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cd_cliente) {
        this.cliente = cd_cliente;
    }

    public Long getCd_venda() {
        return cd_venda;
    }

    public void setCd_venda(Long cd_venda) {
        this.cd_venda = cd_venda;
    }


    public float getVl_total() {
        return vl_total;
    }

    public void setVl_total(float vl_total) {
        this.vl_total = vl_total;
    }

}
