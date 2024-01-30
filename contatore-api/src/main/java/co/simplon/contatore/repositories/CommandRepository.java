package co.simplon.contatore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.entities.Command;

public interface CommandRepository
	extends JpaRepository<Command, Long> {

    List<Command> findByClientId(Long clientId);

    // void deleteByPizzaId(Long pizzaId);

    void deleteByPizzaIdIn(List<Long> listId);

}
