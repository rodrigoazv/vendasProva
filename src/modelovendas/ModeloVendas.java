
package modelovendas;
import crudclasse.CrudCliente;
import crudclasse.CrudProduto;
import java.util.Scanner;


public class ModeloVendas { 
  public static void main(String[] args) { 
    int x = -1;
    Scanner scan = new Scanner(System.in);
    String nome;
    String chave;
    
    
    //
    
    CrudCliente cliente = new CrudCliente();
    CrudProduto produto = new CrudProduto();
    //
      while(x!=0){
            System.out.println("Digite o valor de x");
            System.out.println("1 Para CREAT    -");
            System.out.println("2 Para READ     -");
            System.out.println("3 Para UPDATE   -");
            System.out.println("4 Para deletar  -");
            System.out.println("5 Para Adicionar produto - ");
            System.out.println("6 Para ver dados produto -");
            System.out.println("7 Para ver produto -");
            x = scan.nextInt();
            switch(x){
                    case 1:
                        cliente.adicionarCliente();
                        break;
                    case 2:
                        cliente.mostrarCliente();
                        break;
                    case 3:
                        cliente.updateCliente();
                        break;
                    case 4:
                        cliente.deleteCliente();
                        break;
                    case 5:
                        produto.adicionarProduto();
                        break;
                    case 6:
                        produto.verProduto();
                        break;
                    case 7:
                        produto.updateProduto();
                        break;
                        
        }
      }
   
  
  
  
  
  
  }
}