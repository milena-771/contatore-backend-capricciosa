package co.simplon.contatore.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.dtos.IngredientLabel;
import co.simplon.contatore.entities.Ingredient;

public interface IngredientRepository
	extends JpaRepository<Ingredient, Long> {

    Collection<IngredientLabel> findAllProjectedByOrderByIngredientName();

}
