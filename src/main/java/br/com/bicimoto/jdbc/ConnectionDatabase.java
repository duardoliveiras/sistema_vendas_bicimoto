/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Eduar
 */

/*
para criar a conexao com o banco eh necessario configurar essa classe de forma separada do DAO
OBS: tem que ser configurado dessa forma static para evitar erros de conexao fechada
O objeto dataSource armazena os dados do banco que sao definidos por constantes static
*/
public class ConnectionDatabase {
    
        private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bicimoto";
        private static final String USER = "eduardo";
        private static final String PASSWORD = "123456";
        private static final DataSource dataSource;
        
        static{
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        dataSource = ds;
        }
       
       
        public static Connection getConnection() throws SQLException{
              return dataSource.getConnection();
        }
    
}
