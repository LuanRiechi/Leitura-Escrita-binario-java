package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pedido;



public class ControllerPedido extends ControllerArquivoBinario {
    
    public ArrayList <Pedido> lista = new ArrayList ();

 
        
    public Pedido pesquisapedido (int id) throws NumberFormatException{
        try{
            for (int i = 0; i<this.lista.size(); i++){
                if(this.lista.get(i).getId() == id){
                    return this.lista.get(i);
                }              
            }
        }
        catch (NullPointerException nexc){
            return null;
        }
       
        return null;
      
    }
    
    public void editarPedido(int id, String lanche, String adicional, float preco) throws NumberFormatException {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == (id)) {
                lista.get(i).setLanche(lanche);
                lista.get(i).setAdicional(adicional);
                lista.get(i).setPreco(preco);
            }
        }
    }
    
    public void excluirPedido(int id) throws NumberFormatException {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getId() == (id)) {
                lista.remove(i);
            }
        }
    }     
   
    public ArrayList <Pedido> getLista() {
        return lista;
    }

    public void setLista(ArrayList <Pedido> lista) {
        this.lista = lista;
    }
    
    public void addPedido (int id, String lanche, String adicional, float preco)throws NumberFormatException {
        lista.add(new Pedido (id,lanche,adicional,preco));
    }
    public boolean vereficarPedido (int id)throws NumberFormatException{
        boolean pedidoExiste = false;
        for (int i=0; i<lista.size();i++){
            if(lista.get(i).getId() == (id)){
                pedidoExiste = true;
            } 
        }
        return pedidoExiste;
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
