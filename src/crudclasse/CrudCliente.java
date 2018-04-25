package crudclasse;



import redis.clients.jedis.Jedis; 
import classmodelos.ClienteJava;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CrudCliente {
    
    
    ClienteJava client = new ClienteJava();
    
    Scanner scan = new Scanner(System.in);
    
    Jedis jecliente = new Jedis("localhost"); 
    
    
    public void adicionarCliente(){
        System.out.print("Digite a chave :: -- ");
        client.setChave(scan.next());
        if(jecliente.get(client.getChave()) == null){
            System.out.print("Digite o nome  :: -- ");
            client.setNome(scan.next());
            jecliente.set(client.getChave() , client.getNome());
            
        }
        else{
            System.out.println("Chave em uso, tente outra!");
        }
    }
    public void mostrarCliente(){
        System.out.print("Digite a chave para mostrar :: -- ");
        client.setChave(scan.next());
        
        System.out.println("A Chave "+ client.getChave() +" É do cliente "+ jecliente.get(client.getChave())); 
        
    }
    public void updateCliente(){
        System.out.print("Digite a chava que deseja alterar  :: -- ");
        client.setChave(scan.next());
        System.out.println("Digite o nome que deseja alterar :: -- ");
        client.setNome(scan.next());
        jecliente.set(client.getChave() , client.getNome());
    }
    public void deleteCliente(){
        System.out.println("Digite a Chave que deseja deletar :: -- ");
        client.setChave(scan.next());
        
        jecliente.del(client.getChave());
    }
    public boolean validaCliente(){
        System.out.println("Digite a sua chave");
        client.setChave(scan.next());
        System.out.println("Digite seu nome ");
        client.setNome(scan.next());
        if(jecliente.get(client.getChave()).equals(client.getNome())){
            System.out.println("OK !");
            return true;
        }
        else{
            System.out.println("ERRO!");
            return false;
        }
        
        
                
    }
    public String retCli(String chave){
        
            client.setChave(chave);
            return jecliente.get(client.getChave());
            
        }

    
    
    
}
