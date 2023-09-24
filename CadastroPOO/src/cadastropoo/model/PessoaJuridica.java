package cadastropoo.model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable{
    // Atributos
    private String cnpj;
    
    // Construtor
    public PessoaJuridica(int id, String nome, String cnpj){
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    // getters e setters
    public void set_cnpj(String cnpj){
        this.cnpj = cnpj;
        //System.out,println("CNPJ atualixado");
    }
    public String get_cnpj(){
        return cnpj;
    }
    
    // Métodos
    public void exibir(){
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }
}