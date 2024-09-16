package com.example.petfriends.controller;

import com.example.petfriends.model.PedidoAggregate;
import com.example.petfriends.payload.MessagePayload;
import com.example.petfriends.service.PedidoQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoQueryController {

    private final PedidoQueryService pedidoQueryService;

    @Operation(summary = "Recupera eventos pelo id de um pedido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "recuperado com sucesso.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Ocorreu um erro.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            )
    })
    @GetMapping("/{id}/eventos")
    public List<Object> getEventosPorPedidoId(@PathVariable String id) {
        return pedidoQueryService.getEventosPorPedidoId(id);
    }

    @Operation(summary = "Recupera um pedido pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "recuperado com sucesso.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            ),
            @ApiResponse(responseCode = "404", description = "Ocorreu um erro.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessagePayload.class))}
            )
    })
    @GetMapping("/{id}")
    public PedidoAggregate getPedidoById(@PathVariable String id) {
        return pedidoQueryService.getPedidoById(id);
    }
}
