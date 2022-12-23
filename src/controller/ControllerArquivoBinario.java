package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 * @author Luan
 */
public class ControllerArquivoBinario extends ControllerArquivo {
    
//    public ArrayList <Object> lista = new  ArrayList ();


    public ObjectInputStream leitor = null;
    public ObjectOutputStream escritor = null;

    
    public boolean escrever(Object lista, boolean append) {
        if (arquivo != null) {
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append = false));
                escritor.writeObject(lista);
                escritor.close();
                return true;
            } catch (IOException erro) {
                 JOptionPane.showMessageDialog(null, "Erro ao escrever arquivo binário",
                        "Falha ao escrever arquivo",
                        JOptionPane.ERROR_MESSAGE); 
                return false;
            }
        } else {
            return false;
        }
    }
    
}
