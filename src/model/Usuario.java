/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Usuario {
    private String nome;
    private int senha;
    private String cpf;
    
    public Usuario(){
        this("",0,"");
    }
    
    public Usuario(String nome, int senha,String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome = " + nome + ", senha = " + senha + ", cpf = " + cpf + '}' + "\n";
    }
    
    

    
    
    
}
