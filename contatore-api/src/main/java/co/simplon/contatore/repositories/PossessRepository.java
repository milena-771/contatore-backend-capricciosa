package co.simplon.contatore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.entities.Possess;

public interface PossessRepository
	extends JpaRepository<Possess, Long> {

    List<Possess> findByPizzaId(Long pizzaId);
}
