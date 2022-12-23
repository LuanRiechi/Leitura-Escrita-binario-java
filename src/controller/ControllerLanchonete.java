package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Lanchonete;



public class ControllerLanchonete extends ControllerArquivoBinario {
    
    public ArrayList <Lanchonete> lista = new ArrayList ();
     
    public Lanchonete pesquisaLanchonete (String cnpj)throws NumberFormatException{
        try{
            for (int i = 0; i<this.lista.size(); i++){
                if(this.lista.get(i).getCnpj().equals(cnpj)){
                    return this.lista.get(i);
                }              
            }
        }
        catch (NullPointerException nexc){
            return null;
        }
       
        return null;
      
    }
    
    public void editarLanchonete(String cnpj, String nome,int numerofunc)throws NumberFormatException {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCnpj().equals(cnpj)) {
                lista.get(i).setNome(nome);
                lista.get(i).setNumerofunc(numerofunc);
            }
        }
    }
    
    public void excluirLanchonete(String cnpj)throws NumberFormatException {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCnpj().equals(cnpj)) {
                lista.remove(i);
            }
        }
    }     
   
    public ArrayList <Lanchonete> getLista() {
        return lista;
    }

    public void setLista(ArrayList <Lanchonete> lista) {
        this.lista = lista;
    }
    
    public void addLanchonete (String cnpj, String nome, int numerofunc){
        lista.add(new Lanchonete (cnpj, nome, numerofunc));
    }
    public boolean vereficarLanchonete (String cnpj)throws NumberFormatException{
        boolean LanchoneteExiste = false;
        for (int i=0; i<lista.size();i++){
            if(lista.get(i).getCnpj().equals(cnpj)){
                LanchoneteExiste = true;
            } 
        }
        return LanchoneteExiste;
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
