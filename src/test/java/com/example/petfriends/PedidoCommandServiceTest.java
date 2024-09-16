package com.example.petfriends;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.petfriends.command.CriarPedidoCommand;
import com.example.petfriends.service.PedidoCommandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.concurrent.CompletableFuture;

class PedidoCommandServiceTest {

    @Mock
    private CommandGateway commandGateway;

    @InjectMocks
    private PedidoCommandService pedidoCommandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarPedido() {
        String pedidoId = "pedido01";
        String clienteId = "cliente01";
        List<String> produtos = List.of("produto01", "produto02");

        when(commandGateway.send(any())).thenReturn(CompletableFuture.completedFuture(pedidoId));

        CompletableFuture<String> result = pedidoCommandService.criarPedido(pedidoId, clienteId, produtos);

        assertEquals(pedidoId, result.join());

        verify(commandGateway, times(1)).send(any(CriarPedidoCommand.class));
    }
}
