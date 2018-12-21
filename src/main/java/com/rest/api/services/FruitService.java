package com.rest.api.services;

import com.rest.api.models.Fruit;

import java.util.List;

public interface FruitService {

    Fruit create(Fruit fruit);

    Fruit get(long id);

    Fruit delete(long id);

    List<Fruit> list();

    void removeAll();
}
