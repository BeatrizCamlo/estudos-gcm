package src.main.java.com.imd.controller;

import src.main.java.com.imd.entity.Cliente;
import src.main.java.com.imd.entity.EnumEstadoPedido;
import src.main.java.com.imd.entity.Pedido;

public class ClienteController {
    
    private Cliente cliente;

    public ClienteController(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarPedido(String nomePedido) {
        Pedido pedido = new Pedido(nomePedido, cliente, EnumEstadoPedido.RECEBIDO);
        cliente.adiconarPedidos(pedido);
    }

    public void visualizarPedidos() {
        System.out.printf(" ============== Pedidos de %s ==============\n", cliente.getNome());
        System.out.println("-------------------------------------------------------------");
        for (Pedido pedido : cliente.getPedidos()) {   
            System.out.println("- " + pedido.getNome() + " (Estado: " + pedido.getEstado() + ")");
            System.out.println("-------------------------------------------------------------");
        }
         System.out.println("============================================");
    }
}
