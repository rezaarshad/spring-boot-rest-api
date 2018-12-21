package com.rest.api.services;

import com.rest.api.exceptions.RestApiException;
import com.rest.api.models.Fruit;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FruitServiceImpl implements FruitService {

    private Map<Long, Fruit> db = new HashMap<>();

    @Override
    public Fruit create(Fruit fruit) {
        db.put(fruit.getId(), fruit);
        return fruit;
    }

    @Override
    public Fruit get(long id) {
        Fruit fruit = db.get(id);

        if (fruit == null) throw new RestApiException(RestApiException.FRUIT_NOT_FOUND_EXCEPTION);

        return fruit;
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = db.remove(id);

        if (fruit == null) throw new RestApiException(RestApiException.FRUIT_NOT_FOUND_EXCEPTION);

        return fruit;
    }

    @Override
    public List<Fruit> list() {
        return new ArrayList(Arrays.asList(db.values().toArray()));
    }

    @Override
    public void removeAll(){
        db.clear();
    }
}
