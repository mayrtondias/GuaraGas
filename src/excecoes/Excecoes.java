/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * @author aluno
 */
public class Excecoes extends Exception{
    private String evento;

    public Excecoes(){
        this("");
    }
    
    public Excecoes(String evento) {
        this.evento = evento;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    
    
    public String trataExcecoes(){
        return evento;
    }
    
    
    
    
}
