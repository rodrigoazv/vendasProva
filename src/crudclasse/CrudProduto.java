package crudclasse;

import java.util.Scanner;
import redis.clients.jedis.Jedis; 
import classmodelos.ProdutoJava;
import java.util.List;

public class CrudProduto {
    
    ProdutoJava produt = new ProdutoJava();
    
    Scanner scan = new Scanner(System.in);
    
    Jedis jeproduto = new Jedis("localhost");
    
    public void adicionarProduto(){
        System.out.print("Digite o codigo do produto :: - ");
        produt.setCodigo(scan.nextInt());
        System.out.print("Digite o nome do produto :: - ");
        produt.setNome(scan.next());
        System.out.println("Digite a quantidade de "+produt.getNome());
        produt.setQnt(scan.nextInt());
        System.out.println("Digite o valor de "+produt.getNome());
        produt.setValorU(scan.nextFloat());
        

        jeproduto.lpush(Integer.toString(produt.getCodigo()), produt.getNome() , Integer.toString(produt.getQnt()) , Float.toString(produt.getValorU()));
    }
    public void verProduto(){
        System.out.println("Digite o codigo do produto : - ");
        produt.setCodigo(scan.nextInt());
        List<String> list = jeproduto.lrange(Integer.toString(produt.getCodigo()), 0 ,2); 
        int i = 0;
        while(i<list.size()) { 
            System.out.println("Valor::                   --"+list.get(i)); 
            float p1=Float.parseFloat(list.get(i));
            i++;
            System.out.println("Quantidade::              --"+list.get(i));
            float p2=Float.parseFloat(list.get(i));
            i++;
            System.out.println("Nome::                    --"+list.get(i));
            i++;
            System.out.println("Valor para comprar todos  --"+ p1*p2);
        } 
    }
    public void updateProduto(){
        System.out.print("Digite o codigo do produto que deseja alterar:: - ");
        produt.setCodigo(scan.nextInt());
        System.out.println("<< DADOS >>");
        List<String> list = jeproduto.lrange(Integer.toString(produt.getCodigo()), 0 ,2); 
        int i = 0;
        while(i<list.size()) { 
            System.out.println("Valor::                   --"+list.get(i)); 
            float p1=Float.parseFloat(list.get(i));
            i++;
            System.out.println("Quantidade::              --"+list.get(i));
            float p2=Float.parseFloat(list.get(i));
            i++;
            System.out.println("Nome::                    --"+list.get(i));
            i++;
        } 
        System.out.print("Alterar valor      -:");
        produt.setValorU(scan.nextFloat());
        System.out.print("Alterar Quantidade -:");
        produt.setQnt(scan.nextInt());
        System.out.print("Alterar nome       -:");
        produt.setNome(scan.next());
        jeproduto.lpush(Integer.toString(produt.getCodigo()), produt.getNome(), Integer.toString(produt.getQnt()), Float.toString(produt.getValorU()));
        
    }
    public void deleteProduto(){
        System.out.print("Digite o codigo do produto que deseja deletar -:");
        produt.setCodigo(scan.nextInt());
        jeproduto.del(Integer.toString(produt.getCodigo()));        
    }
    
}
