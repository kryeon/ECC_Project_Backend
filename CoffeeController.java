package com.example.coffeeapi.controller;

import com.example.coffeeapi.domain.Coffee;
import com.example.coffeeapi.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    public List<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coffee getCoffee(@PathVariable Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 커피를 찾을 수 없음"));
    }

    @PostMapping
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PatchMapping("/{id}")
    public Coffee patchCoffee(@PathVariable Long id, @RequestBody Coffee updated) {
        Coffee coffee = coffeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 커피를 찾을 수 없음"));

        if (updated.getKoreanName() != null) {
            coffee.setKoreanName(updated.getKoreanName());
        }
        if (updated.getEnglishName() != null) {
            coffee.setEnglishName(updated.getEnglishName());
        }
        return coffeeRepository.save(coffee);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        coffeeRepository.deleteById(id);
    }
}