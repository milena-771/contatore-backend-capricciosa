package co.simplon.contatore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sizes")
public class Size extends AbstractEntity {

    @Column(name = "size_name")
    private String sizeName;

    public Size() {
    }

    public String getSizeName() {
	return sizeName;
    }

    public void setSizeName(String sizeName) {
	this.sizeName = sizeName;
    }

    @Override
    public String toString() {
	return " {sizeName=" + sizeName + "}";
    }
}
