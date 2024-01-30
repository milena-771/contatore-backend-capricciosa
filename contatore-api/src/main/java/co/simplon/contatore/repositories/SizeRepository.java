package co.simplon.contatore.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.dtos.SizeDetail;
import co.simplon.contatore.entities.Size;

public interface SizeRepository
	extends JpaRepository<Size, Long> {

    Collection<SizeDetail> findAllProjectedByOrderBySizeName();

}
