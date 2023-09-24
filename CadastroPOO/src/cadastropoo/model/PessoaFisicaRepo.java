package cadastropoo.model;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class PessoaFisicaRepo {
    // Atributos
    private ArrayList<PessoaFisica> lista = new ArrayList<PessoaFisica>();
    
    // Métodos
    public void inserir(PessoaFisica pessoa){
        lista.add(pessoa);
        //System.out.println("Pessoa adicionada a lista");
    }
    public void alterar(int id, PessoaFisica pessoa){
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
    public PessoaFisica obter(int id){
        for(PessoaFisica pessoa : lista){
            if(pessoa.get_id() == id){
                return pessoa;
            }
        }
        return null;
    }
    public ArrayList<PessoaFisica> obterTodos(){
        return lista;
    }
    public void persistir(String arquivo) throws IOException{
        PrintWriter gravar = new PrintWriter(arquivo);
        for(PessoaFisica pessoa : lista){
            gravar.println(pessoa.get_id() + "," + pessoa.get_nome() + "," + pessoa.get_cpf() + "," + pessoa.get_idade());
        }
        gravar.close();
        System.out.println("Dados de Pessoa Física Armazenados");
    }
    public void recuperar(String arquivo) throws IOException{
        Scanner leitor = new Scanner(new File(arquivo));
        while(leitor.hasNext()){
            String linha = leitor.nextLine();
            String[] palavras = linha.split(",");
            PessoaFisica pessoa = new PessoaFisica(Integer.parseInt(palavras[0]), palavras[1], palavras[2], Integer.parseInt(palavras[3]));
            lista.add(pessoa);
        }
        leitor.close();
        System.out.println("Dados de Pessoa Física Recuperados");
    }
}