package cadastropoo;

import cadastropoo.model.PessoaFisicaRepo;
import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaJuridica;
import cadastropoo.model.PessoaJuridicaRepo;
import java.util.Scanner;
/**
 *
 * @author lucas
 */
public class CadastroPOO {
    
    public static void main(String[] args) {
        boolean ligado = true;
        Scanner teclado = new Scanner(System.in);
        
        // Criar objetos
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
            
        while(ligado){
            // Display menu
            System.out.println("======================================================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Dados");
            System.out.println("6 - Pessistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("======================================================================");
            
            // Recebendo instruções
            int instrucao1 = Integer.parseInt(teclado.next());
            String tipo;
            if(instrucao1 > 0){
                while(true){
                    System.out.println("F - Pessoa Física  |  J - Pessoa Jurídica");
                    tipo = teclado.next();
                    if(tipo.equals("F") | tipo.equals("j")){
                        break;
                    }
                    else{
                        System.out.println("Não entendi, por favor tente de novo.");
                    }
                }
            }
            else{
                tipo = "?";
            }
            switch(instrucao1){
                case 1:{
                    System.out.println("Digite o Id da pessoa:");
                    int id = Integer.parseInt(teclado.next());
                    System.out.println("Digite o nome da pessoa:");
                    String nome = teclado.next();
                    if(tipo.equals("F")){
                        System.out.println("Digite o CPF da pessoa:");
                        String cpf = teclado.next();
                        System.out.println("Digite a idade da pessoa:");
                        int idade = Integer.parseInt(teclado.next());
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    }
                    else{
                        System.out.println("Digite o CNPJ da pessoa:");
                        String cnpj = teclado.next();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
                }
                
                case 2:{
                    System.out.println("Digite o Id da pessoa:");
                    int id = Integer.parseInt(teclado.next());
                    System.out.println("Inserir novos dados...");
                    System.out.println("Digite o nome da pessoa:");
                    String nome = teclado.next();
                    if(tipo.equals("F")){
                        System.out.println("Digite o CPF da pessoa:");
                        String cpf = teclado.next();
                        System.out.println("Digite a idade da pessoa:");
                        int idade = Integer.parseInt(teclado.next());
                        repoFisica.alterar(id, new PessoaFisica(id, nome, cpf, idade));
                    }
                    else{
                        System.out.println("Digite o CNPJ da pessoa:");
                        String cnpj = teclado.next();
                        repoJuridica.alterar(id, new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("Digite o Id da pessoa:");
                    int id = Integer.parseInt(teclado.next());
                    if(tipo.equals("F")){
                        repoFisica.excluir(id);
                    }
                    else{
                        repoJuridica.excluir(id);
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("Digite o Id da pessoa:");
                    int id = Integer.parseInt(teclado.next());
                    if(tipo.equals("F")){
                        try{
                            PessoaFisica pessoa = repoFisica.obter(id);
                            pessoa.exibir();
                        }
                        catch(Exception e){
                            System.out.println("Pessoa não encontrada");
                        }
                    }
                    else{
                        try{
                            PessoaJuridica pessoa = repoJuridica.obter(id);
                            pessoa.exibir();
                        }
                        catch(Exception e){
                            System.out.println("Pessoa não encontrada");
                        }
                    }
                    break;
                }
                
                case 5:{
                    if(tipo.equals("F")){
                        for(PessoaFisica pessoa : repoFisica.obterTodos()){
                            pessoa.exibir();
                        }
                    }
                    else{
                        for(PessoaJuridica pessoa : repoJuridica.obterTodos()){
                            pessoa.exibir();
                        }
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("Digite o nome do arquivo:");
                    String prefixo = teclado.next();
                    if(tipo.equals("F")){
                        try{
                            repoFisica.persistir(prefixo + ".fisica.bin");
                        }
                        catch(Exception e){
                            System.out.println("Não foi possível salvar arquivo");
                        }
                    }
                    else{
                        try{
                            repoJuridica.persistir(prefixo + ".juridica.bin");
                        }
                        catch(Exception e){
                            System.out.println("Não foi possível salvar arquivo");
                        }
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("Digite o nome do arquivo:");
                    String prefixo = teclado.next();
                    if(tipo.equals("F")){
                        try{
                            repoFisica.recuperar(prefixo + ".fisica.bin");
                        }
                        catch(Exception e){
                            System.out.println("Não foi possível encontrar arquivo");
                        }
                    }
                    else{
                        try{
                            repoJuridica.recuperar(prefixo + ".juridica.bin");
                        }
                        catch(Exception e){
                            System.out.println("Não foi possível encontrar arquivo");
                        }
                    }
                    break;
                }
                
                case 0:
                    ligado = false;
                    break;
                    
                default:
                    System.out.println("Não compreendi, por favor tente novamente.");
                    break;
            }
        }
        teclado.close();
    }
}