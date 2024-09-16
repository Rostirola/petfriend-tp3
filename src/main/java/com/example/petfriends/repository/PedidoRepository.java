package com.example.petfriends.repository;

import com.example.petfriends.model.PedidoAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoAggregate, String> {
}
