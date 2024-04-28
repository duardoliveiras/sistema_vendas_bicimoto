/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

import java.sql.Date;

/**
 *
 * @author G15
 */
public class VendasPrazoModel {
    private Long cd_venda_prazo;
    private Long cd_venda;
    private int nm_parcela;
    private float vl_parcela;
    private String status_pagamento;
    private float vl_pago;
    private Date dt_vencimento;

    public Long getCd_venda_prazo() {
        return cd_venda_prazo;
    }

    public void setCd_venda_prazo(Long cd_venda_prazo) {
        this.cd_venda_prazo = cd_venda_prazo;
    }

    public Long getCd_venda() {
        return cd_venda;
    }

    public void setCd_venda(Long cd_venda) {
        this.cd_venda = cd_venda;
    }

    public int getNm_parcela() {
        return nm_parcela;
    }

    public void setNm_parcela(int nm_parcela) {
        this.nm_parcela = nm_parcela;
    }

    public float getVl_parcela() {
        return vl_parcela;
    }

    public void setVl_parcela(float vl_parcela) {
        this.vl_parcela = vl_parcela;
    }

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public float getVl_pago() {
        return vl_pago;
    }

    public void setVl_pago(float vl_pago) {
        this.vl_pago = vl_pago;
    }

    public Date getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    @Override
    public String toString() {
        return "VendasPrazoModel{" + "cd_venda_prazo=" + cd_venda_prazo + ", cd_venda=" + cd_venda + ", nm_parcela=" + nm_parcela + ", vl_parcela=" + vl_parcela + ", status_pagamento=" + status_pagamento + ", vl_pago=" + vl_pago + ", dt_vencimento=" + dt_vencimento + '}';
    }
    
}
