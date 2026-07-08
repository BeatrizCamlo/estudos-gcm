package src.main.java.com.imd.entity;

import java.util.ArrayList;
import java.util.List;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void adiconarPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}