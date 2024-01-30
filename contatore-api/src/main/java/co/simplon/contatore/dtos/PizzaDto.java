package co.simplon.contatore.dtos;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PizzaDto {

    @NotBlank
    private String commandNumber;

    @NotBlank
    private String initial;

    @NotNull
    private Long baseId;

    @NotNull
    private Long shapeId;

    @NotNull
    private Long sizeId;

    private Set<IngredientDto> ingredientDetails;

    public PizzaDto() {
    }

    public String getCommandNumber() {
	return commandNumber;
    }

    public void setCommandNumber(String commandNumber) {
	this.commandNumber = commandNumber;
    }

    public String getInitial() {
	return initial;
    }

    public void setInitial(String initial) {
	this.initial = initial;
    }

    public Long getBaseId() {
	return baseId;
    }

    public void setBaseId(Long baseId) {
	this.baseId = baseId;
    }

    public Long getShapeId() {
	return shapeId;
    }

    public void setShapeId(Long shapeId) {
	this.shapeId = shapeId;
    }

    public Long getSizeId() {
	return sizeId;
    }

    public void setSizeId(Long sizeId) {
	this.sizeId = sizeId;
    }

    public Set<IngredientDto> getIngredientDetails() {
	return ingredientDetails;
    }

    public void setIngredientDetails(
	    Set<IngredientDto> ingredientDetails) {
	this.ingredientDetails = ingredientDetails;
    }

    @Override
    public String toString() {
	return " {commandNumber=" + commandNumber
		+ ", initial=" + initial + ", baseId="
		+ baseId + ", shapeId=" + shapeId
		+ ", sizeId=" + sizeId
		+ ", ingredientDetails=" + ingredientDetails
		+ "}";
    }
}
