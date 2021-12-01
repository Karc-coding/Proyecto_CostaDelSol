package com.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

}
