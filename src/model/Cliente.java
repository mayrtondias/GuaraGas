/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
//classe responsavel pelas propriedades do cliente
public class Cliente {
    private String nome;
    private String codigo;

    public Cliente(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome = " + nome + ", codigo = " + codigo + '}' + "\n";
    }
    
    
    
}
