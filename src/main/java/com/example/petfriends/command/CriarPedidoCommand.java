package com.example.petfriends.command;

import lombok.Getter;

import java.util.List;

@Getter
public class CriarPedidoCommand extends BaseCommand<String> {
    private final String clienteId;
    private final List<String> produtos;

    public CriarPedidoCommand(String id, String clienteId, List<String> produtos) {
        super(id);
        this.clienteId = clienteId;
        this.produtos = produtos;
    }
}
