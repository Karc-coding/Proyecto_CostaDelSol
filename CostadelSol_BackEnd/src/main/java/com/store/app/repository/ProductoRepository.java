package com.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.app.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

	@Query("select p from Producto p where (p.description is '' or p.description like :p_description) and"
			+ "( p.idcat is '' or p.idcat like :p_categoria )")
	public abstract List<Producto> findProductoByDescriptionOrCategoria(@Param("p_description") String description,
			@Param("p_categoria") String categoria);
	
}
