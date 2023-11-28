package br.com.pizzaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pizzaria.api.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    
}
