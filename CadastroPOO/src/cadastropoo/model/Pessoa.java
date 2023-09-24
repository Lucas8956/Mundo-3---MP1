package cadastropoo.model;

import java.io.Serializable;

public class Pessoa implements Serializable{
    // Atributos
    private int id;
    private String nome;
    
    // Construtor
    public Pessoa(){}
    
    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    // getters e setters
    public void set_id(int id){
        this.id = id;
        //System.out.println("Id atualizado");
    }
    public int get_id(){
        return id;
    }
    public void set_nome(String nome){
        this.nome = nome;
        //System.out.println("Nome atualizado");
    }
    public String get_nome(){
        return nome;
    }
    
    // Métodos
    public void exibir(){
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
    }
}