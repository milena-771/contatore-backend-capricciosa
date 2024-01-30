package co.simplon.contatore.dtos;

public class IngredientDto {

    private Long ingredientId;

    private String quantity;

    public IngredientDto() {

    }

    public Long getIngredientId() {
	return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
	this.ingredientId = ingredientId;
    }

    public String getQuantity() {
	return quantity;
    }

    public void setQuantity(String quantity) {
	this.quantity = quantity;
    }

    @Override
    public String toString() {
	return " {ingredientId=" + ingredientId
		+ ", quantity=" + quantity + "}";
    }

}
