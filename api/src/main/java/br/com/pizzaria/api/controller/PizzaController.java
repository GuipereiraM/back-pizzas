package br.com.pizzaria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzaria.api.model.Pizza;
import br.com.pizzaria.api.repository.PizzaRepository;
@CrossOrigin("http://127.0.0.1:5500/")
@RestController
@RequestMapping({"/pizzas"})
public class PizzaController {
    @Autowired 
    private PizzaRepository repository;
    
    @PostMapping
   public String cadastrar(@RequestBody Pizza obj) {
      this.repository.save(obj);
      return "Cadastrado com sucesso";
   }

   @GetMapping
   public List<Pizza> listar() {
      return this.repository.findAll();
   }

   @DeleteMapping({"/{id}"})
   public String delete(@PathVariable Long id) {
      this.repository.deleteById(id);
      return "removido com sucesso";
   }

   @PutMapping
   public String alterar(@RequestBody Pizza pizza) {
      if (pizza.getId() == 0L) {
         return "Id n\u00e3o foi informado";
      } else {
         Pizza c = (Pizza)this.repository.findById(pizza.getId()).get();
         if (c == null) {
            return "Id n\u00e3o encontrado";
         } else {
            this.repository.saveAndFlush(pizza);
            return "Alterado com sucesso";
         }
      }
   } 
}
