package br.com.pizzaria.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pizzas")
@SequenceGenerator(
   name = "pizza_seq",
   sequenceName = "pizza_seq",
   initialValue = 1,
   allocationSize = 1
)
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class Pizza { 
    @Id
     @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "pizza_seq"
   )
    private Long id;
    private String nome; 
    private String descricao;
    private String ingrediente; 
    private String tipo; 
    
    
}
