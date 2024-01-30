package co.simplon.contatore.dtos;

import java.util.Collection;

public class AllLabels {

    private Collection<BaseDetail> baseLabels;

    private Collection<ShapeDetail> shapeLabels;

    private Collection<IngredientLabel> ingredientLabel;

    private Collection<SizeDetail> sizeLabel;

    public AllLabels() {
    }

    public Collection<BaseDetail> getBaseLabels() {
	return baseLabels;
    }

    public void setBaseLabels(
	    Collection<BaseDetail> baseLabels) {
	this.baseLabels = baseLabels;
    }

    public Collection<ShapeDetail> getShapeLabels() {
	return shapeLabels;
    }

    public void setShapeLabels(
	    Collection<ShapeDetail> shapeLabels) {
	this.shapeLabels = shapeLabels;
    }

    public Collection<IngredientLabel> getIngredientLabel() {
	return ingredientLabel;
    }

    public void setIngredientLabel(
	    Collection<IngredientLabel> ingredientLabel) {
	this.ingredientLabel = ingredientLabel;
    }

    public Collection<SizeDetail> getSizeLabel() {
	return sizeLabel;
    }

    public void setSizeLabel(
	    Collection<SizeDetail> sizeLabel) {
	this.sizeLabel = sizeLabel;
    }

    @Override
    public String toString() {
	return " {baseLabels=" + baseLabels
		+ ", shapeLabels=" + shapeLabels
		+ ", ingredientLabel=" + ingredientLabel
		+ ", sizeLabel=" + sizeLabel + "}";
    }
}
