package com.example.petfriends.service;

import com.example.petfriends.model.PedidoAggregate;
import com.example.petfriends.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoQueryService {

    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    public List<Object> getEventosPorPedidoId(String pedidoId) {
        return eventStore.readEvents(pedidoId).asStream().map(Message::getPayload).collect(Collectors.toList());
    }

    public PedidoAggregate getPedidoById(String id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}

