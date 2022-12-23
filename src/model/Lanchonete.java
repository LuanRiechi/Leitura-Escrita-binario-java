/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luan Riechi
 */
public class Lanchonete implements java.io.Serializable {
    private String cnpj;
    private String nome;
    private int numerofunc;
    
    public Lanchonete (String cnpj, String nome, int numerofunc){
        this.cnpj = cnpj;
        this.nome = nome;
        this.numerofunc = numerofunc;

    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numerofunc
     */
    public int getNumerofunc() {
        return numerofunc;
    }

    /**
     * @param numerofunc the numerofunc to set
     */
    public void setNumerofunc(int numerofunc) {
        this.numerofunc = numerofunc;
    }
}
