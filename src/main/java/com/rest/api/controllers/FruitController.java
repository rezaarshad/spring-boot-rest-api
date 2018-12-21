package com.rest.api.controllers;

import com.rest.api.models.Fruit;
import com.rest.api.services.FruitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Reza Arshad
 */
@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {

    @Autowired
    FruitService fruitService;

    @PutMapping("/")
    @ApiOperation(value = "get a fruit",
            notes = "")
    public Fruit put(@RequestBody Fruit fruit) {
        return fruitService.create(fruit);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete a fruit",
            notes = "")
    public Fruit delete(@PathVariable long id) {
        return fruitService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get a fruit",
            notes = "")
    public Fruit get(@PathVariable long id) {
        return fruitService.get(id);
    }


    @GetMapping("/")
    @ApiOperation(value = "get list of fruits",
            notes = "")
    public List<Fruit> list() {
        return fruitService.list();
    }


}
