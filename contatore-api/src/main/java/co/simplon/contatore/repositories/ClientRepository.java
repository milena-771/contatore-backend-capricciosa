package co.simplon.contatore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.entities.Client;

public interface ClientRepository
	extends JpaRepository<Client, Long> {

}
