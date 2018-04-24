package validaClienteAdm;

import java.util.Scanner;
import crudclasse.CrudFuncionario;
import crudclasse.CrudCliente;
import crudclasse.CrudProduto;


public class Valida {
     int validaClienteAdm = -1;
    
    int x = -1;
    Scanner scan = new Scanner(System.in);
    
    
    
    //INICIO INSTANCIA CRUD
    
    CrudCliente cliente = new CrudCliente();
    CrudProduto produto = new CrudProduto();
    CrudFuncionario funcionario = new CrudFuncionario();
    
    
    public void val(){
      System.out.println("Você é cliente ou funcionario ? [1] cliente         -"
              + "                                         [2] funcionario     -");
      
      
      
      
      
      validaClienteAdm = scan.nextInt();
      
      switch(validaClienteAdm){
          case 1:
              if(cliente.validaCliente() == true){
                  System.out.println("Quem está lhe atendendo ? CHAVE-FUNCIONARIO");
                  
              }
              break;
          case 2:
              if(funcionario.validaFuncionario() == true){
                  produto.verProduto();
              }
              
              break;
      }
        
        
    }
}
