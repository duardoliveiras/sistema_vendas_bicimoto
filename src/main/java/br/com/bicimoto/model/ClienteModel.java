/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Eduar
 */

/*
Modelo do cliente, possui como atributos todas as colunas da tabela
e tambem os metodos get e set
*/
public class ClienteModel {
    
     private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
     private Long id;
     private String nome;
     private String email;
     private String endereco;
     private String bairro;
     private String telefone;
     private String cpf;
     private Date dt_nascimento;
     private String cep;
     private String cidade;
     private String estado;
     
     public ClienteModel(){
         
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDt_nascimento(){
        return this.dt_nascimento;
    }
    public String getString_nascimento(){
        String data = "";
        try{
            data = formatter.format(dt_nascimento);
        }
        catch(Exception e){ 
            e.getStackTrace();
        }
        // formata o datesql em String
        return data;
    }
    /* crio um util.date que recebe a string formata em data
    depois passo para a variavel datesql o util.date
    */
    public void setDt_nascimento(String string_data) {
        try { 
            java.util.Date data_formatada = formatter.parse(string_data);
            this.dt_nascimento = new Date(data_formatada.getTime());
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void setDt_nascimento(Date dt_nascimento){
        this.dt_nascimento = dt_nascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

     
     
          
     
         
    
}
