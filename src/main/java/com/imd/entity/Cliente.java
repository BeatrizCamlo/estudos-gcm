package main.java.com.imd.entity;

public class Cliente{
    private String nome;
    private List<Pedido> pedidos;

    public Cliente(String nome){
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}