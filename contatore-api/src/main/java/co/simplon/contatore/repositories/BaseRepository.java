package co.simplon.contatore.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.dtos.BaseDetail;
import co.simplon.contatore.entities.Base;

public interface BaseRepository
	extends JpaRepository<Base, Long> {

    Collection<BaseDetail> findAllProjectedByOrderByBaseName();

}
