package com.example.petfriends.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
public class BaseCommand<T> {
    @TargetAggregateIdentifier
    private final T id;

    protected BaseCommand(T id) {
        this.id = id;
    }
}
