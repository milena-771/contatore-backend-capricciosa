package co.simplon.contatore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bases")
public class Base extends AbstractEntity {

    @Column(name = "base_name")
    private String baseName;

    public Base() {
    }

    public String getBaseName() {
	return baseName;
    }

    public void setBaseName(String baseName) {
	this.baseName = baseName;
    }

    @Override
    public String toString() {
	return " {baseName=" + baseName + "}";
    }

}
