
package modelovendas;
import crudclasse.CrudCliente;
import java.util.Scanner;


public class ModeloVendas { 
  public static void main(String[] args) { 
    int x = -1;
    Scanner scan = new Scanner(System.in);
    String nome;
    String chave;
    
    
    //
    
    CrudCliente cliente = new CrudCliente();
      while(x!=0){
            System.out.println("Digite o valor de x");
            System.out.println("1 Para CREAT    -");
            System.out.println("2 Para READ     -");
            System.out.println("3 Para UPDATE   -");
            x = scan.nextInt();
            switch(x){
                    case 1:
                        cliente.Adicionar();
                        break;
                    case 2:
                        cliente.Mostrar();
                        break;
                    case 3:
                        cliente.Update();
                        break;
        }
      }
   
  
  
  
  
  
  }
}