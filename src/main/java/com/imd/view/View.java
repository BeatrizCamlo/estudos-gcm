package src.main.java.com.imd.view;

import java.util.Scanner;
import src.main.java.com.imd.entity.Cliente;
import src.main.java.com.imd.entity.Pedido;
import src.main.java.com.imd.entity.EnumEstadoPedido;
import src.main.java.com.imd.respository.ClienteRepository;
import src.main.java.com.imd.respository.PedidoRepository;
import src.main.java.com.imd.controller.ClienteController;
import src.main.java.com.imd.controller.PizzariaController;

public class View {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteController clienteController;
        PedidoRepository pedidoRepository = new PedidoRepository();
        PizzariaController pizzariaController = new PizzariaController(pedidoRepository);

        Pedido pedido1 = new Pedido("Pizza Margherita", new Cliente("Ana"), EnumEstadoPedido.RECEBIDO);
        pedidoRepository.save(pedido1);
        Cliente cliente1 = new Cliente("Ana");
        clienteRepository.save(cliente1);


        int op = 0;

        while (op != 3) {
            System.out.println("\n========== Bem-vindo ==========");
            System.out.println("1 - Entrar como Cliente");
            System.out.println("2 - Entrar como Pizzaria");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("Insira seu nome: ");
                String nome = sc.nextLine();
                if(nome == null || nome.trim().isEmpty()) {
                    System.out.println("Nome inválido.");
                    continue;
                }
                Cliente cliente = new Cliente(nome);
                clienteRepository.save(cliente);
                clienteController = new ClienteController(cliente);

                int subOp = 0;
                while (subOp != 3) {
                    System.out.println("\n--- Bem-vindo, " + cliente.getNome() + "! ---");
                    System.out.println("1 - Fazer um pedido");
                    System.out.println("2 - Visualizar meus pedidos");
                    System.out.println("3 - Sair");
                    subOp = sc.nextInt();
                    sc.nextLine();

                    if (subOp == 1) {
                        System.out.println("Insira o nome do pedido: ");
                        String nomePedido = sc.nextLine();
                        pedidoRepository.save(new Pedido(nomePedido, cliente, EnumEstadoPedido.RECEBIDO));
                        clienteController.adicionarPedido(nomePedido);
                        System.out.println("Pedido realizado com sucesso!");
                    } else if (subOp == 2) {
                        clienteController.visualizarPedidos();
                    }
                }

            } else if (op == 2) {
                int subOp = 0;

                do{
                    System.out.println("\n============ Pizzaria Bom Sabor ============");
                    pizzariaController.listarPedidos();

                    System.out.println("1 - Atualizar status de um pedido");
                    System.out.println("2 - Voltar");
                    System.out.print("Escolha uma opção: ");
                    subOp = sc.nextInt();
                    sc.nextLine();

                    if (subOp == 1) {
                        System.out.println("Insira o nome do pedido: ");
                        String nomePedido = sc.nextLine();


                        if (pedidoRepository.buscarPorNome(nomePedido) != null  ) {
                            Pedido pedido = pedidoRepository.buscarPorNome(nomePedido);
                            System.out.println("Escolha: 1-RECEBIDO, 2-EM_PREPARO, 3-PRONTO");
                            int status = sc.nextInt();
                            if (status == 1) {
                                pizzariaController.atualizarEstadoPedido(pedido, EnumEstadoPedido.RECEBIDO);
                            }
                            else if (status == 2) {
                                pizzariaController.atualizarEstadoPedido(pedido, EnumEstadoPedido.EM_PREPARO);
                            }
                            else if (status == 3) {
                                pizzariaController.atualizarEstadoPedido(pedido, EnumEstadoPedido.PRONTO);
                            }
                            System.out.println("Status atualizado!");
                        } else {
                            System.out.println("Pedido não encontrado.");
                        }
                    }
                } while (subOp != 2);
                
            }
        }
        System.out.println("Programa encerrado.");
        sc.close();
    }
}