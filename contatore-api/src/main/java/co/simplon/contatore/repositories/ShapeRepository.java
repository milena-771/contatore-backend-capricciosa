package co.simplon.contatore.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.contatore.dtos.ShapeDetail;
import co.simplon.contatore.entities.Shape;

public interface ShapeRepository
	extends JpaRepository<Shape, Long> {

    Collection<ShapeDetail> findAllProjectedByOrderByShapeName();
}
