/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduar
 */

/*
Essa classe eh para podermos realizar um GET em uma api publica
que retorna um JSON com os dados do endereco a partir de uma entrada CEP
*/
public class ApiCep {
    

    public Endereco getEndereco(String cep) throws IOException{
        Endereco endereco = new Endereco();
        try {
            // cria a string URL de acesso
            String url = " https://viacep.com.br/ws/" + cep +"/json/";
            
            // objeto URL
            URL url_obj = new URL(url);
            
            // abre a conexao http
            HttpURLConnection conn = (HttpURLConnection) url_obj.openConnection();
            
            
            // armazena o codigo de resposta da requisicao 200 ok 400 bad
            int responseCode = conn.getResponseCode();
            
            // http_ok = 200
            if(responseCode == HttpURLConnection.HTTP_OK){
                // ler a resposta
                BufferedReader in = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String jsonString = "";
                String line = "";
                
                // percorre todas as linhas do buffer ate acabar
                // armazena o resultado de cada linha no jsonString
                while((line = in.readLine())!= null){
                    jsonString += line;
                    
                }
                // fecha o buffer
                in.close();
                
                // cria um objeto Gson, para trabalhar com Json e Objetos
                Gson gson = new Gson();
                
                // o objeto endereco representa os dados do Json
                // aqui esta sendo instanciado um endereco com os dados lidos do json
                endereco = gson.fromJson(jsonString, Endereco.class);
                
            }else{
                System.out.println("A resposta falhou. Codigo: "+ responseCode);
            }
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ApiCep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }
    
}
