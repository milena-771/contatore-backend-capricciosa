package co.simplon.contatore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "shapes")
public class Shape extends AbstractEntity {

    @Column(name = "shape_name")
    private String shapeName;

    public Shape() {
    }

    public String getShapeName() {
	return shapeName;
    }

    public void setShapeName(String shapeName) {
	this.shapeName = shapeName;
    }

    @Override
    public String toString() {
	return " {shapeName=" + shapeName + "}";
    }
}
