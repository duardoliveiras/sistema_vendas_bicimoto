/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduar
 */
public class ProdutoModel {
    
    private Long cd_produto;
    private String nm_produto;
    private String ds_produto;
    private float vl_inicial;
    private float vl_final;
    private int qt_produto;
    private Long cd_fornecedor;
    private Date dt_atualizacao;
    private FornecedorModel fornecedorModel;
    
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public FornecedorModel getFornecedorModel() {
        return fornecedorModel;
    }

    public void setFornecedorModel(FornecedorModel fornecedorModel) {
        this.fornecedorModel = fornecedorModel;
    }
    
    
    public Long getCd_produto() {
        return cd_produto;
    }

    public void setCd_produto(Long cd_produto) {
        this.cd_produto = cd_produto;
    }

    public String getNm_produto() {
        return nm_produto;
    }

    public void setNm_produto(String nm_produto) {
        this.nm_produto = nm_produto;
    }

    public String getDs_produto() {
        return ds_produto;
    }

    public void setDs_produto(String ds_produto) {
        this.ds_produto = ds_produto;
    }

    public float getVl_inicial() {
        return vl_inicial;
    }

    public void setVl_inicial(float vl_inicial) {
        this.vl_inicial = vl_inicial;
    }

    public float getVl_final() {
        return vl_final;
    }

    public void setVl_final(float vl_final) {
        this.vl_final = vl_final;
    }

    public int getQt_produto() {
        return qt_produto;
    }

    public void setQt_produto(int qt_produto) {
        this.qt_produto = qt_produto;
    }

    public Long getCd_fornecedor() {
        return cd_fornecedor;
    }

    public void setCd_fornecedor(Long cd_fornecedor) {
        this.cd_fornecedor = cd_fornecedor;
    }

    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }
    
    public String getString_atualizacao() {
        String string_dt = "";
        try {
            string_dt = formatter.format(this.dt_atualizacao);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return string_dt;
    }

    public void setDt_atualizacao(String data) {
        try{
        java.util.Date data_formatada = formatter.parse(data);
        this.dt_atualizacao = new Date(data_formatada.getTime());
        }catch(ParseException e){
            e.printStackTrace();
        }
        
    }
    
    public void setDt_atualizacao(Date data){
        this.dt_atualizacao = data;
    }
    
}
