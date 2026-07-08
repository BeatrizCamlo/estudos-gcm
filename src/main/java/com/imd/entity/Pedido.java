package src.main.java.com.imd.entity;

public class Pedido {
    private String nome;
    private Cliente donoPedido;
    private EnumEstadoPedido estado;

    public Pedido(String nome, Cliente donoPedido, EnumEstadoPedido estado) {
        this.nome = nome;
        this.donoPedido = donoPedido;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public Cliente getDonoPedido() {
        return donoPedido;
    }

    public EnumEstadoPedido getEstado() {
        return estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDonoPedido(Cliente donoPedido) {
        this.donoPedido = donoPedido;
    }

    public void setEstado(EnumEstadoPedido estado) {
        this.estado = estado;
    }
}
