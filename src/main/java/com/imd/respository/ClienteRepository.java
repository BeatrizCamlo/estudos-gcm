package main.java.com.imd.respository;

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
    public void buscarPorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                System.out.println("Cliente encontrado: " + cliente.getNome());
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
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
}
