
package model;
/**
 *
 * @author Luan Riechi
 */


public class Cliente implements java.io.Serializable {
    
    private int idcliente;
    private String nome;
    private String cpf;
    private String email;

    public Cliente(int idcliente, String nome, String cpf, String email){
        
       this.idcliente = idcliente;
       this.nome = nome;
       this.cpf = cpf;
       this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
