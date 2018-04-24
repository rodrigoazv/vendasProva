package crudclasse;


import java.util.List;
import redis.clients.jedis.Jedis; 
import classmodelos.ClienteJava;
import java.util.Scanner;


public class CrudCliente {
    
    
    ClienteJava client = new ClienteJava();
    
    Scanner scan = new Scanner(System.in);
    
    Jedis jedis = new Jedis("localhost"); 
    
    
    public void Adicionar(){
        System.out.print("Digite a chave :: -- ");
        client.setChave(scan.next());
        System.out.print("Digite o nome  :: -- ");
        client.setNome(scan.next());
        jedis.set(client.getChave() , client.getNome());
    }
    public void Mostrar(){
        System.out.print("Digite a chave para mostrar :: -- ");
        client.setChave(scan.next());
        System.out.println("A Chave "+ client.getChave() +" É do cliente "+ jedis.get(client.getChave()));
    }
    public void Update(){
        System.out.print("Digite a chava que deseja alterar  :: -- ");
        client.setChave(scan.next());
        System.out.println("Digite o nome que deseja alterar :: -- ");
        client.setNome(scan.next());
        jedis.set(client.getChave() , client.getNome());
    }

    
    
    
}
