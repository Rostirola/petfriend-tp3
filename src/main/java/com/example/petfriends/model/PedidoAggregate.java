package com.example.petfriends.model;

import com.example.petfriends.command.CriarPedidoCommand;
import com.example.petfriends.converter.ListToJsonConverter;
import com.example.petfriends.event.PedidoCriadoEvent;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Data
@Entity
public class PedidoAggregate {

    @Id
    @AggregateIdentifier
    private String id;
    private String clienteId;
    @Convert(converter = ListToJsonConverter.class)
    private List<String> produtos;

    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand command) {
        apply(new PedidoCriadoEvent(command.getId(), command.getClienteId(), command.getProdutos()));
    }

    @EventSourcingHandler
    protected void on(PedidoCriadoEvent event) {
        this.id = event.getId();
        this.clienteId = event.getClienteId();
        this.produtos = event.getProdutos();
    }
}
