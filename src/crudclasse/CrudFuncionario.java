package crudclasse;

import classmodelos.FuncionarioJava;
import java.util.Scanner;
import redis.clients.jedis.Jedis;

public class CrudFuncionario {
    FuncionarioJava funcionario = new FuncionarioJava();
    Scanner scan = new Scanner(System.in);
    
    Jedis jefuncionario = new Jedis("localhost");
    public void adicionarFuncionario(){
        System.out.print("Digite a chave :: -- ");
        funcionario.setChave(scan.next());
        System.out.print("Digite o nome  :: -- ");
        funcionario.setNome(scan.next());
        jefuncionario.set(funcionario.getChave() ,funcionario.getNome());
    }
    public void mostrarFuncionario(){
        System.out.print("Digite a chave para mostrar :: -- ");
        funcionario.setChave(scan.next());
        System.out.println("A Chave "+ funcionario.getChave() +" É do cliente "+ jefuncionario.get(funcionario.getChave()));
    }
    public void updateFuncionario(){
        System.out.print("Digite a chava que deseja alterar  :: -- ");
        funcionario.setChave(scan.next());
        System.out.println("Digite o nome que deseja alterar :: -- ");
        funcionario.setNome(scan.next());
        jefuncionario.set(funcionario.getChave() , funcionario.getNome());
    }
    public void deleteFuncionario(){
        System.out.println("Digite a Chave que deseja deletar :: -- ");
        funcionario.setChave(scan.next());
        
        jefuncionario.del(funcionario.getChave());
    }
    public boolean validaFuncionario(){
        System.out.println("Digite a sua chave");
        funcionario.setChave(scan.next());
        System.out.println("Digite seu nome ");
        funcionario.setNome(scan.next());
        if(jefuncionario.get(funcionario.getChave()).equals(funcionario.getNome())){
            System.out.println("OK !");
            return true;
        }
        else{
            System.out.println("ERRO!");
            return false;
        }
    }
    public String retFunc(String chave){
        
            funcionario.setChave(chave);
            return jefuncionario.get(funcionario.getChave());
            
        }
    
    
}
