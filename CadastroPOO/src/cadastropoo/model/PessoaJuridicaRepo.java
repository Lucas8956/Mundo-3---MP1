package cadastropoo.model;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class PessoaJuridicaRepo {
    // Atributos
    private ArrayList<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
    
    // Métodos
    public void inserir(PessoaJuridica pessoa){
        lista.add(pessoa);
        //System.out.println("Pessoa adicionada a lista");
    }
    public void alterar(int id, PessoaJuridica pessoa){
        int quantidade = lista.size();
        excluir(id);
        if(lista.size() == quantidade - 1){
            inserir(pessoa);
        }
    }
    public void excluir(int id){
        boolean operacao = false;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).get_id() == id){
                lista.remove(i);
                operacao = true;
                break;
                //System.out.println("Pessoa removida");
            }
        }
        if (!operacao){
            System.out.println("Pessoa não encontrada");
        }
    }
    public PessoaJuridica obter(int id){
        for(PessoaJuridica pessoa : lista){
            if(pessoa.get_id() == id){
                return pessoa;
            }
        }
        return null;
    }
    public ArrayList<PessoaJuridica> obterTodos(){
        return lista;
    }
    public void persistir(String arquivo) throws IOException{
        PrintWriter gravar = new PrintWriter(arquivo);
        for(PessoaJuridica pessoa : lista){
            gravar.println(pessoa.get_id() + "," + pessoa.get_nome() + "," + pessoa.get_cnpj());
        }
        gravar.close();
        System.out.println("Dados de Pessoa Jurídica Armazenados");
    }
    public void recuperar(String arquivo) throws IOException{
        Scanner leitor = new Scanner(new File(arquivo));
        while(leitor.hasNext()){
            String linha = leitor.nextLine();
            String[] palavras = linha.split(",");
            PessoaJuridica pessoa = new PessoaJuridica(Integer.parseInt(palavras[0]), palavras[1], palavras[2]);
            lista.add(pessoa);
        }
        leitor.close();
        System.out.println("Dados de Pessoa Juridica Recuperados");
    } 
}