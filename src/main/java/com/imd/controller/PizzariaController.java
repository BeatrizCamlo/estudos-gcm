package src.main.java.com.imd.controller;

import src.main.java.com.imd.entity.EnumEstadoPedido;
import src.main.java.com.imd.entity.Pedido;
import src.main.java.com.imd.respository.PedidoRepository;

public class PizzariaController {
    private PedidoRepository pedidoRepository;

    public PizzariaController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void atualizarEstadoPedido(Pedido pedido, EnumEstadoPedido novoEstado) {
        pedido.setEstado(novoEstado);
        pedidoRepository.atualizarPedido(pedido, novoEstado);
    }

    public void listarPedidos() {
        System.out.println(" ============== Pedidos ==============");
        System.out.println("-------------------------------------------------------------");
        for (Pedido pedido : pedidoRepository.getPedidos()) {
            System.out.println("- " + pedido.getNome() + " (Estado: " + pedido.getEstado() + ")");
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("============================================");
    }

}
