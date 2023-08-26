/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

/**
 *
 * @author Eduar
 */
public class ItensModel {
    
    private Long cd_item;
    private VendasModel venda;
    private ProdutoModel produto;
    private int quantidade;
    private float subtotal;

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    
    
    public Long getCd_item() {
        return cd_item;
    }

    public void setCd_item(Long cd_item) {
        this.cd_item = cd_item;
    }

    public VendasModel getVenda() {
        return venda;
    }

    public void setVenda(VendasModel venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
