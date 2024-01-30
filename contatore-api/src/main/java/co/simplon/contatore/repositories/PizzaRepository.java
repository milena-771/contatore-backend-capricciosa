package co.simplon.contatore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.entities.Pizza;

public interface PizzaRepository
	extends JpaRepository<Pizza, Long> {

    void deleteByIdIn(List<Long> listId);

}
