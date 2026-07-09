package src.main.java.com.imd.respository;

import java.util.ArrayList;
import java.util.List;

import src.main.java.com.imd.entity.Cliente;
import src.main.java.com.imd.entity.Pedido;

public class ClienteRepository implements RepositoryInterface<Cliente> {
    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public Cliente buscarPorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Pedido> buscarPedidosPorCliente(String nomeCliente){
        List<Pedido> pedidosDoCliente = new ArrayList<>();
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(nomeCliente)){
                pedidosDoCliente.addAll(cliente.getPedidos());
            }
        }
        return pedidosDoCliente;
    }

    public Cliente getClientePorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
