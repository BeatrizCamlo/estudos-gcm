package src.main.java.com.imd.respository;

import java.util.ArrayList;
import java.util.List;

import src.main.java.com.imd.entity.EnumEstadoPedido;
import src.main.java.com.imd.entity.Pedido;

public class PedidoRepository implements RepositoryInterface<Pedido> {
    private List<Pedido> pedidos;

    public PedidoRepository() {
        this.pedidos = new ArrayList<>();
    }

    @Override
    public void save(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        pedidos.remove(pedido);
    }

    @Override
    public Pedido buscarPorNome(String nome) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNome().equals(nome)) {
                return pedido;
            }
        }
        return null;
    }

    public void adicionarPedido(Pedido p) {
    this.pedidos.add(p);
    }

    public void atualizarPedido(Pedido pedido, EnumEstadoPedido novoEstado) {
        pedido.setEstado(novoEstado);
    }


    public List<Pedido> buscarPedidosPorCliente(String nomeCliente) {
        List<Pedido> pedidosDoCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNome().equals(nomeCliente)) {
                pedidosDoCliente.add(pedido);
            }
        }
        return pedidosDoCliente;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }
        
}
