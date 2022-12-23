/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author Luan
 */
public class ControllerCliente extends ControllerArquivoBinario {
    public ArrayList <Cliente> lista = new  ArrayList ();
    
    
    public ArrayList <Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList <Cliente> lista) {
        this.lista = lista;
    }
    
    public void addCliente (int idcliente, String nome, String cpf, String email)throws NumberFormatException{
        lista.add(new Cliente (idcliente, nome, cpf, email));
    }
    public Cliente pesquisaCliente (String cpf)throws NumberFormatException{
            for (int i = 0; i<this.lista.size(); i++){
                if(this.lista.get(i).getCpf().equals(cpf)){
                    return this.lista.get(i);
                }              
            }
        return null;  
    }
    
    public void editarCliente(String cpf,int idcliente, String nome, String email)throws NumberFormatException {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCpf().equals(cpf)) {
                lista.get(i).setIdcliente(idcliente);
                lista.get(i).setNome(nome);
                lista.get(i).setEmail(email);
            }
        }
    }
    
    public void excluirCliente(String cpf)throws NumberFormatException {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCpf().equals(cpf)) {
                lista.remove(i);
            }
        }
    }    
    public boolean vereficarCliente (String cpf)throws NumberFormatException{
        boolean clienteExiste = false;
        for (int i=0; i<lista.size();i++){
            if(lista.get(i).getCpf().equals(cpf)){
                clienteExiste = true;
            } 
        }
        return clienteExiste;
    }

    public void gravar(){
        setArquivo("Salvar");
        escrever(lista, false);
    }
    public boolean ler() {
      if(arquivo != null){  
        try {
            leitor = new ObjectInputStream(new FileInputStream(arquivo));
            lista = (ArrayList) leitor.readObject();
            leitor.close();
            return true;
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada",
                        "Falha ao Ler arquivo",
                        JOptionPane.ERROR_MESSAGE);
            return false;
            } catch (IOException erro) {
                 JOptionPane.showMessageDialog(null, "Erro ao ler arquivo binário",
                        "Falha ao Ler arquivo",
                        JOptionPane.ERROR_MESSAGE);  

           return false;
           }
      } else {
       return false;
      }
    }
    public void lerArquivo()throws IOException, ClassCastException{
        setArquivo("Abrir");
        ler();
    }    
}
