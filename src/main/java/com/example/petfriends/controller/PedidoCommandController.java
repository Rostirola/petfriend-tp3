package com.example.petfriends.controller;

import com.example.petfriends.command.CriarPedidoCommand;
import com.example.petfriends.payload.MessagePayload;
import com.example.petfriends.service.PedidoCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoCommandController {
    private final PedidoCommandService pedidoCommandService;

    @Operation(summary = "Cria um pedido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Ocorreu um erro.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            )
    })
    @PostMapping
    public CompletableFuture<String> criarPedido(@RequestBody CriarPedidoCommand command) {
        return pedidoCommandService.criarPedido(command.getId(), command.getClienteId(), command.getProdutos());
    }
}
