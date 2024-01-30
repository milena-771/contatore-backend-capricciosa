package co.simplon.contatore.dtos;

public class IngredientDetails {

    private String ingredientName;

    private String quantity;

    public IngredientDetails() {
    }

    public String getIngredientName() {
	return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
	this.ingredientName = ingredientName;
    }

    public String getQuantity() {
	return quantity;
    }

    public void setQuantity(String quantity) {
	this.quantity = quantity;
    }

    @Override
    public String toString() {
	return " {ingredientName=" + ingredientName
		+ ", quantity=" + quantity + "}";
    }

}
