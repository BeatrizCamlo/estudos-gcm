package main.java.com.imd.respository;

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
    public void buscarPorNome(String nome) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getNome().equals(nome)) {
                System.out.println("Pedido encontrado: " + pedido);
                return;
            }
        }
        System.out.println("Pedido não encontrado para o cliente: " + nome);
    }
    
}
