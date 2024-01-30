package co.simplon.contatore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "possess")
public class Possess extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    public Possess() {
    }

    public Ingredient getIngredient() {
	return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
	this.ingredient = ingredient;
    }

    public Pizza getPizza() {
	return pizza;
    }

    public void setPizza(Pizza pizza) {
	this.pizza = pizza;
    }

    @Override
    public String toString() {
	return " {ingredient=" + ingredient + ", pizza="
		+ pizza + "}";
    }
}
