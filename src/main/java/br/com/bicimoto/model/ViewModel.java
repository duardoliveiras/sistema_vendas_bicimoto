/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bicimoto.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eduar
 */

// Classe para criar metodos que atuam na classe de view
public class ViewModel {
    
    public void limparDados(JPanel painel){
        Component components[] = painel.getComponents(); // um vetor de componentes presente no painel
        for(Component component : components){ // for each
            if(component instanceof JTextField){ // se o component for um jtext
                ((JTextField)component).setText("");  // esvazie-o
            }
        }
        
    }
}
