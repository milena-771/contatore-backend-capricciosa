package co.simplon.contatore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient extends AbstractEntity {

    @Column(name = "ingredient_name")
    private String ingredientName;

    public Ingredient() {
    }

    public String getIngredientName() {
	return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
	this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
	return " {ingredientName=" + ingredientName + "}";
    }
}
