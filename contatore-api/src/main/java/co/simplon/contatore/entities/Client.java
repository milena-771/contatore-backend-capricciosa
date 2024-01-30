package co.simplon.contatore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {

    public Client() {

    }

}
