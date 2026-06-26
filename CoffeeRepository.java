package com.example.coffeeapi.repository;

import com.example.coffeeapi.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    Optional<Coffee> findByEnglishName(String englishName);
}