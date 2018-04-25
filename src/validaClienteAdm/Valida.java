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

    int val1 = -1, val2 = -1, val3 = -1, val4 = -1, valproduto = -1;
    String cli, func;

    public void val() {
        while (validaClienteAdm != 0) {
            System.out.println("Você é cliente ou funcionario ? [1] cliente         -"
                    + "                                         [2] funcionario     -"
                    + " [0] EXIT");

            validaClienteAdm = scan.nextInt();

            switch (validaClienteAdm) {
                case 1:

                    if (cliente.validaCliente() == true) {
                        System.out.println("Digite a chave para confirmar");
                        cli = cliente.retCli(scan.next());
                        System.out.println("Quem está lhe atendendo ? CHAVE-FUNCIONARIO");
                        if (funcionario.validaFuncionario() == true) {
                            System.out.println("Confirme a chave --- ");
                            func = funcionario.retFunc(scan.next());
                            while (valproduto != 2) {
                                System.out.println("DIgite a chave do produto que irá comprar");
                                produto.verProduto();
                                System.out.println(cli + " é esse o produto [1]SIM || [2]NÃO?");
                                valproduto = scan.nextInt();
                                if(valproduto==1){
                                    
                                }
                                else if (valproduto ==2){
                                    
                                }
                            }
                        }
                        //retorna todos os produtos e valida compra
                        //armazena dados da compra e gera cupom

                    }
                    break;
                case 2:
                    if (funcionario.validaFuncionario() == true) {
                        int flag2 = -1;

                        System.out.println("QUAL AÇÃO DESEJA REALIZAR?");
                        System.out.println("[1]- CRUD CLIENTE");
                        System.out.println("[2]- CRUD PRODUTOS");
                        x = scan.nextInt();
                        if (x == 1) {

                            while (val1 != 0) {
                                System.out.println("Você selecionou CRUD CLIENTE !");
                                System.out.println("[1] - PARA INSERIR CLIENTE");
                                System.out.println("[2] - PARA VER CLIENTE");
                                System.out.println("[3] - PARA ATUALIAR CLIENTE");
                                System.out.println("[4] - PARA DELETAR CLIENTE");
                                System.out.println("[5] - CRUD PRODUTO");
                                System.out.println("[0]EXIT");

                                val1 = scan.nextInt();

                                switch (val1) {
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
                                        x = 2;
                                        break;
                                }
                            }
                        }
                        if (x == 2) {
                            while (val2 != 0) {
                                System.out.println("VOCÊ SELECIONOU CRUD PRODUTOS");
                                System.out.println("[1] - PARA INSERIR PRODUTO");
                                System.out.println("[2] - PARA VER PRODUTO");
                                System.out.println("[3] - PARA ATUALIZAR PRODUTO");
                                System.out.println("[4] - PARA DELETAR PRODUTO");
                                System.out.println("[5] - CRUD CLIENTE");
                                System.out.println("[0]EXIT");
                                val2 = scan.nextInt();
                                switch (val2) {
                                    case 1:
                                        produto.adicionarProduto();
                                        break;
                                    case 2:
                                        produto.verProduto();
                                        break;
                                    case 3:
                                        produto.updateProduto();
                                        break;
                                    case 4:
                                        produto.deleteProduto();
                                        break;
                                    case 5:
                                        x = 1;
                                        break;

                                }
                            }
                        }

//faz com que todos os cruds sejam acessiveis
                    }

            }

        }

    }
}
