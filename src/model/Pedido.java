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
public class Pedido implements java.io.Serializable {
    private int id;
    private String lanche;
    private String adicional;
    private float preco;
    
    public Pedido (int id, String lanche, String adicional, float preco){
        this.id = id;
        this.lanche = lanche;
        this.adicional = adicional;
        this.preco = preco;
   }

    /**
     * @return the lanche
     */
    public String getLanche() {
        return lanche;
    }

    /**
     * @param lanche the lanche to set
     */
    public void setLanche(String lanche) {
        this.lanche = lanche;
    }

    /**
     * @return the adicional
     */
    public String getAdicional() {
        return adicional;
    }

    /**
     * @param adicional the adicional to set
     */
    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
