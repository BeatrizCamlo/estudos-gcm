package src.main.java.com.imd.entity;

import java.util.List;
import java.util.ArrayList;

public class Pizzaria {
    private List<Pedido> pedidos;

    public Pizzaria(){
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }


}
