package co.simplon.contatore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza extends AbstractEntity {

    @Column(name = "command_number")
    private String commandNumber;

    @Column(name = "initial")
    private String initial;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "base_id")
    private Base base;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "shape_id")
    private Shape shape;

    public Pizza() {
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

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Base getBase() {
	return base;
    }

    public void setBase(Base base) {
	this.base = base;
    }

    public Size getSize() {
	return size;
    }

    public void setSize(Size size) {
	this.size = size;
    }

    public Shape getShape() {
	return shape;
    }

    public void setShape(Shape shape) {
	this.shape = shape;
    }

    @Override
    public String toString() {
	return " {commandNumber=" + commandNumber
		+ ", initial=" + initial + ", status="
		+ status + ", base=" + base + ", size="
		+ size + ", shape=" + shape + "}";
    }
}
