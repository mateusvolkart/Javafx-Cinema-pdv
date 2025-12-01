package com.models;

import java.util.ArrayList;
import java.util.List;
import com.DTO.PedidoDTO;

public class ListaPedidos {

    private static final List<Pedido> pedidos = new ArrayList<>();

    public static void adicionar(Pedido p) {
        pedidos.add(p);
    }

    public static List<Pedido> getPedidos() {
        return pedidos;
    }

    public static List<PedidoDTO> getPedidosDesnormalized() {
        List<PedidoDTO> lista = new ArrayList<>();

        for (Pedido p : pedidos) {
            PedidoDTO dto = new PedidoDTO(
                p.getNumeroPedido(),
                p.getFilmeSelecionado().getNome(),
                String.valueOf(p.getSalaSelecionada().getNumero()),
                p.getLugarSelecionado()
            );
            lista.add(dto);
        }

        return lista;
    }

}
