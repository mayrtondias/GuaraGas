/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
//classe responsável pelas propriedades do Funcionario
public class Funcionario {
    private String nome;
    private String codigo;

    public Funcionario(String nome, String codigo) {
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
        return "Funcionario{" + "nome = " + nome + ", codigo = " + codigo + '}' + "\n";
    }
    
    
    
    
}
