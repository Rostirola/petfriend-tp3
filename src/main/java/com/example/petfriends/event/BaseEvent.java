package com.example.petfriends.event;

import lombok.Getter;

@Getter
public class BaseEvent<T> {
    private final T id;

    protected BaseEvent(T id) {
        this.id = id;
    }
}
