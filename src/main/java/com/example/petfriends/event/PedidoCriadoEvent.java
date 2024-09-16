package com.example.petfriends.event;

import lombok.Getter;

import java.util.List;

@Getter
public class PedidoCriadoEvent extends BaseEvent<String> {
    private final String clienteId;
    private final List<String> produtos;

    public PedidoCriadoEvent(String id, String clienteId, List<String> produtos) {
        super(id);
        this.clienteId = clienteId;
        this.produtos = produtos;
    }
}
