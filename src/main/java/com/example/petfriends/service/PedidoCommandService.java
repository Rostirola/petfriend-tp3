package com.example.petfriends.service;

import com.example.petfriends.command.CriarPedidoCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PedidoCommandService {
    private final CommandGateway commandGateway;

    public CompletableFuture<String> criarPedido(String id, String clienteId, List<String> produtos) {
        return commandGateway.send(new CriarPedidoCommand(id, clienteId, produtos));
    }
}
