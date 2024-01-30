package co.simplon.contatore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "command")
public class Command extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Command() {
	// TODO Auto-generated constructor stub
    }

    public Pizza getPizza() {
	return pizza;
    }

    public void setPizza(Pizza pizza) {
	this.pizza = pizza;
    }

    public Client getClient() {
	return client;
    }

    public void setClient(Client client) {
	this.client = client;
    }

    @Override
    public String toString() {
	return " {pizza=" + pizza + ", client=" + client
		+ "}";
    }

}
