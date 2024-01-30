package co.simplon.contatore.dtos;

import java.util.Set;

public class CommandDetails {

    private Long id;

    private String identifier;

    private String status;

    private String baseName;

    private String shapeName;

    private String sizeName;

    private Set<IngredientDetails> ingredientList;

    public CommandDetails() {
    }

    public String getIdentifier() {
	return identifier;
    }

    public void setIdentifier(String identifier) {
	this.identifier = identifier;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getBaseName() {
	return baseName;
    }

    public void setBaseName(String baseName) {
	this.baseName = baseName;
    }

    public String getShapeName() {
	return shapeName;
    }

    public void setShapeName(String shapeName) {
	this.shapeName = shapeName;
    }

    public String getSizeName() {
	return sizeName;
    }

    public void setSizeName(String sizeName) {
	this.sizeName = sizeName;
    }

    public Set<IngredientDetails> getIngredientList() {
	return ingredientList;
    }

    public void setIngredientList(
	    Set<IngredientDetails> ingredientList) {
	this.ingredientList = ingredientList;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return " {id=" + id + ", identifier=" + identifier
		+ ", status=" + status + ", baseName="
		+ baseName + ", shapeName=" + shapeName
		+ ", sizeName=" + sizeName
		+ ", ingredientList=" + ingredientList
		+ "}";
    }
}
